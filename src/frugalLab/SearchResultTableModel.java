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
import java.io.*;
/**
 *
 * @author Hinsen Chan
 */
public class SearchResultTableModel extends AbstractTableModel {
    List<Project> projectResultList;   // stores the model data in a List collection of type Project
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Project project;	
    private ProjectService projectService;
    private String searchTerm;
    
    int numcols, numrows;           // number of rows and columns
    
    public SearchResultTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	project = new Project();
	projectService = new ProjectService(manager);
	    
        //searchTerm = "";
        try{
            Scanner in = new Scanner(new FileReader("searchTerm.txt"));
            if(in.hasNext())
                searchTerm = in.nextLine();
            in.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }	// read all the records from courselist
        
        System.out.println("SearchResultTableModel --------" + searchTerm);
        if(searchTerm==null || searchTerm.isEmpty())
        {
            projectResultList = projectService.readAll();
        }
        else
        {
            projectResultList = projectService.searchProjects(searchTerm);
        }
        
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
	/*
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
	*/
    // returns the name of the column
    public String getColumnName(int col) {
        try {
            return project.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    public void setSearchTerm(String searchTerm){
        
        this.searchTerm = searchTerm;
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
    public SearchResultTableModel(List<Project> list, EntityManager em)  {
                //searchTerm = "";
        try{
            Scanner in = new Scanner(new FileReader("searchTerm.txt"));
            if(in.hasNext())
                searchTerm = in.nextLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }	// read all the records from courselist
        
        if(searchTerm==null || searchTerm.isEmpty())
        {
            projectResultList = list;
        }
        else
        {
            projectResultList = projectService.searchProjects(searchTerm);
        }
        
	numrows = projectResultList.size();
	project = new Project();
	numcols = project.getNumberOfColumns();     
	manager = em;  
	projectService = new ProjectService(manager);
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