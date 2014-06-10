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
public class TagTableModel extends AbstractTableModel {
    List<Tag> tagResultList;   // stores the model data in a List collection of type Tag
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Tag tag;	
    private TagService tagService;
    
    int numcols, numrows;           // number of rows and columns
    
    public TagTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	tag = new Tag();
	tagService = new TagService(manager);
	    
	// read all the records from courselist
	tagResultList = tagService.readAll();
	    
	// update the number of rows and columns in the model
	numrows = tagResultList.size();
	numcols = tag.getNumberOfColumns();
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
            return tagResultList.get(row).getColumnData(col);
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
            return tag.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            Tag element = tagResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<Tag> getList() {
        return tagResultList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public TagTableModel(List<Tag> list, EntityManager em)  {
        tagResultList = list;
	numrows = tagResultList.size();
	tag = new Tag();
	numcols = tag.getNumberOfColumns();     
	manager = em;  
	tagService = new TagService(manager);
    }
	 
    // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
    // The argument to this method is an array containing the data in the textfields of the new row.
    public void addRow(Object[] array) {
        //data[rowIndex][columnIndex] = (String) aValue;	        
        
	// add row to database
	EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	Tag newRecord = tagService.createTag((String)array[0]);
	userTransaction.commit();
		 
	// set the current row to rowIndex
        tagResultList.add(newRecord);
        
        int row = tagResultList.size();  
        //int col = 0;
        int col = 1;

        // update the data in the model to the entries in array
        for (Object data : array) {
            //setValueAt((String) data, row-1, col++);
            setValueAt((String) data, row-1, col);
        }
         
        numrows++;
    }	    
    
    // update a row in the table
    public void updateRow(int index, String[] array) {        
        EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	Tag updatedRecord = tagService.updateTag(tagResultList.get(index).getId(), array[0]);
	userTransaction.commit();
        
        int col = 1;
        
        for (String data : array) {
            setValueAt ((String) data, index, col);            
        }
    }
    
    // delete a row from the table
    public void deleteRow(int row) {
        long id = Long.parseLong(getValueAt(row,0).toString());
        String tag = getValueAt(row,1).toString();
	
        EntityTransaction userTransaction = manager.getTransaction();          
        userTransaction.begin();
        tagService.deleteTag(id);
        userTransaction.commit();
        tagResultList.remove(row);        
        fireTableRowsUpdated(row, row);
        
        numrows--;
    }
    
    // locate a file type in the table
    public boolean locate(String tag) {
        if (tagService.findTag(tag))        
            return true;
        return false;
    }
}