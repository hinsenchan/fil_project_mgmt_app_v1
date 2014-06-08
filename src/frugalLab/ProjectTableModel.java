/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author Hinsen Chan
 */
public class ProjectTableModel extends AbstractTableModel {
    List<Project> projectResultList;   // stores the model data in a List collection of type Project
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Project project;	
    private ProjectService projectService;
    
    int numcols, numrows;           // number of rows and columns
    
    public ProjectTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	project = new Project();
	projectService = new ProjectService(manager);
	    
	// read all the records from courselist
	projectResultList = projectService.readAll();
	    
	// update the number of rows and columns in the model
	numrows = projectResultList.size();
	numcols = project.getNumberOfColumns();
    }
    
    // returns a count of the number of rows
    public int getRowCount() {
        return numrows;
    }
	
    // returns a count of the number of columns
    public int getColumnCount() {
        return numcols;
    }    
    
    // returns the data at the given row and column number
    public Object getValueAt(int row, int col) {
        try {
            return projectResultList.get(row).getColumnData(col);
	} catch (Exception e) {
            e.getMessage();
            return null;
	}
    }
    
    // table cells are not editable
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }
	
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
	
    // returns the name of the column
    public String getColumnName(int col) {
        try {
            return project.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            Project element = projectResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<Project> getList() {
        return projectResultList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public ProjectTableModel(List<Project> list, EntityManager em)  {
        projectResultList = list;
	numrows = projectResultList.size();
	project = new Project();
	numcols = project.getNumberOfColumns();     
	manager = em;  
	projectService = new ProjectService(manager);
    }
	 
    // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
    // The argument to this method is an array containing the data in the textfields of the new row.
    public void addRow(Object[] array) {
        //data[rowIndex][columnIndex] = (String) aValue;
        
	// add row to database
	EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	Project newRecord = projectService.createProject((String)array[0],(String)array[1],
                (String)array[2],(String)array[3],(String)array[4]);
	userTransaction.commit();		 
        
	// set the current row to rowIndex
        projectResultList.add(newRecord);
        
        int row = projectResultList.size();  
        int col = 1;

        // update the data in the model to the entries in array
        for (Object data : array) {
            setValueAt((String) data, row-1, col++);
        }
         
        numrows++;
    }	    
    
    // update a row in the table
    public void updateRow(int index, String[] array) {        
        EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();

	Project updatedRecord = projectService.updateProject(Long.parseLong(array[0]), array[1], 
                array[2], array[3], array[4], array[5]);
	userTransaction.commit();
        
        int col = 0;
        for (String data : array) {
            setValueAt ((String) data, index, col++);            
        }
    }
    
    // delete a row from the table
    public void deleteRow(int row) {
        long id = Long.parseLong(getValueAt(row,0).toString());
        String project = getValueAt(row,1).toString();
	
        EntityTransaction userTransaction = manager.getTransaction();          
        userTransaction.begin();
        projectService.deleteProject(id);
        userTransaction.commit();
        projectResultList.remove(row);        
        fireTableRowsUpdated(row, row);
        
        numrows--;
    }
    
    // locate a project in the table
    public boolean locate(String title) {
        if (projectService.findProject(title))        
            return true;
        return false;
    }
    
    // locate a project in the table excluding specied primary key
    public boolean locate(String title, String id) {
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(id);
        }
        catch (NumberFormatException e) {}
        
        if (projectService.findProject(title, longProjectID))        
            return true;
        return false;
    }
}