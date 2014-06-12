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
public class UserManagerTableModel extends AbstractTableModel {
    List<UserManager> userManagerResultList;   // stores the model data in a List collection of type UserManager
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private UserManager userManager;	
    private UserManagerService userManagerService;
    
    int numcols, numrows;           // number of rows and columns
    
    public UserManagerTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	userManager = new UserManager();
	userManagerService = new UserManagerService(manager);
	    
	// read all the records from courselist
	userManagerResultList = userManagerService.readAll();
	    
	// update the number of rows and columns in the model
	numrows = userManagerResultList.size();
	numcols = userManager.getNumberOfColumns();
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
            return userManagerResultList.get(row).getColumnData(col);
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
            return userManager.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            UserManager element = userManagerResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<UserManager> getList() {
        return userManagerResultList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public UserManagerTableModel(List<UserManager> list, EntityManager em)  {
        userManagerResultList = list;
	numrows = userManagerResultList.size();
	userManager = new UserManager();
	numcols = userManager.getNumberOfColumns();     
	manager = em;  
	userManagerService = new UserManagerService(manager);
    }
	 
    // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
    // The argument to this method is an array containing the data in the textfields of the new row.
    public void addRow(Object[] array) {
        //data[rowIndex][columnIndex] = (String) aValue;	        
        
	// add row to database
	EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	UserManager newRecord = userManagerService.createUserManager((String)array[0],(String)array[1]);
	userTransaction.commit();
		 
	// set the current row to rowIndex
        userManagerResultList.add(newRecord);
        
        int row = userManagerResultList.size();  
        int col = 0;

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
	UserManager updatedRecord = userManagerService.updateUserManager((long)index, array[0], array[1] , array[2]);
	userTransaction.commit();
        
        for (String data : array) {
            setValueAt ((String) data, index, 1);            
        }
    }
    
    // delete a row from the table
    public void deleteRow(int row) {
        long id = Long.parseLong(getValueAt(row,0).toString());
        String userName = getValueAt(row,1).toString();
	
        EntityTransaction userTransaction = manager.getTransaction();          
        userTransaction.begin();
        userManagerService.deleteUserManager(id);
        userTransaction.commit();
        userManagerResultList.remove(row);        
        fireTableRowsUpdated(row, row);
        
        numrows--;
    }
    
    // locate a file type in the table
    public boolean locate(String userName) {
        if (userManagerService.findUserManager(userName))        
            return true;
        return false;
    }
}