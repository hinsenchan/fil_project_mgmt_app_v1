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
public class StudentsTableModel extends AbstractTableModel {
    List<Students> studentsResultList;   // stores the model data in a List collection of type Students
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Students students;	
    private StudentsService studentsService;
    
    int numcols, numrows;           // number of rows and columns
    
    public StudentsTableModel(String projectID) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	students = new Students();
	studentsService = new StudentsService(manager, projectID);
	    
	// read all the records from courselist
	studentsResultList = studentsService.readAll();
	    
	// update the number of rows and columns in the model
	numrows = studentsResultList.size();
	numcols = students.getNumberOfColumns();
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
            return studentsResultList.get(row).getColumnData(col);
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
            return students.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            Students element = studentsResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<Students> getList() {
        return studentsResultList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public StudentsTableModel(String projectID, List<Students> list, EntityManager em)  {
        studentsResultList = list;
	numrows = studentsResultList.size();
	students = new Students();
	numcols = students.getNumberOfColumns();     
	manager = em;  
	studentsService = new StudentsService(manager, projectID);
    }
	 
    // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
    // The argument to this method is an array containing the data in the textfields of the new row.
    public void addRow(Object[] array) {
        //data[rowIndex][columnIndex] = (String) aValue;
        
	// add row to database
	EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	Students newRecord = studentsService.createStudents((String)array[0]);
	userTransaction.commit();		 
        
	// set the current row to rowIndex
        studentsResultList.add(newRecord);
        
        int row = studentsResultList.size();  
        int col = 1;

        // update the data in the model to the entries in array
        for (Object data : array) {
            setValueAt((String) data, row-1, col);
        }
         
        numrows++;
    }	    
    
    // update a row in the table
    public void updateRow(int index, String[] array) {        
        EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();

	Students updatedRecord = studentsService.updateStudents(array[0], array[1]);
	userTransaction.commit();
        
        int col = 0;
        for (String data : array) {
            setValueAt ((String) data, index, col++);            
        }
    }
    
    // delete a row from the table
    public void deleteRow(int row) {
        long id = Long.parseLong(getValueAt(row,0).toString());
        String students = getValueAt(row,1).toString();
	
        EntityTransaction userTransaction = manager.getTransaction();          
        userTransaction.begin();
        studentsService.deleteStudents(id);
        userTransaction.commit();
        studentsResultList.remove(row);        
        fireTableRowsUpdated(row, row);
        
        numrows--;
    }
    
    // locate a students in the table
    public boolean locate(String title) {
        if (studentsService.findStudents(title))        
            return true;
        return false;
    }
    
    // locate a students in the table excluding specied primary key
    public boolean locate(String title, String id) {
        if (studentsService.findStudents(title, id))        
            return true;
        return false;
    }
}
