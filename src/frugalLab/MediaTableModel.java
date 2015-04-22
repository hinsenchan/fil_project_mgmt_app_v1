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
public class MediaTableModel extends AbstractTableModel {
    List<Media> mediaResultList;   // stores the model data in a List collection of type Media
    List<FileType> fileTypes;
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Media media;	
    private MediaService mediaService;    
    
    int numcols, numrows;           // number of rows and columns
    
    public MediaTableModel(String projectID) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	media = new Media();
	mediaService = new MediaService(manager, projectID);
	    
	// read all the records from courselist
	mediaResultList = mediaService.readAll();
        fileTypes = mediaService.readFileTypes();
	    
	// update the number of rows and columns in the model
	numrows = mediaResultList.size();
	numcols = media.getNumberOfColumns();
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
            return mediaResultList.get(row).getColumnData(col);
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
            return media.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            Media element = mediaResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<Media> getList() {
        return mediaResultList;
    }
    
    public List<FileType> getFileTypes() {
        return fileTypes;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public MediaTableModel(String projectID, List<Media> list, EntityManager em, List<FileType> fileTypes)  {
        mediaResultList = list;
        this.fileTypes = fileTypes;
	numrows = mediaResultList.size();
	media = new Media();
	numcols = media.getNumberOfColumns();     
	manager = em;  
	mediaService = new MediaService(manager, projectID);
    }
	 
    // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
    // The argument to this method is an array containing the data in the textfields of the new row.
    public void addRow(Object[] array) {
        //data[rowIndex][columnIndex] = (String) aValue;
        
	// add row to database
	EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	Media newRecord = mediaService.createMedia((String)array[0], (String)array[1], (String)array[2]);
	userTransaction.commit();		 
        
	// set the current row to rowIndex
        mediaResultList.add(newRecord);
        
        int row = mediaResultList.size();  
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

	Media updatedRecord = mediaService.updateMedia(array[0], array[1], array[2], array[3]);
	userTransaction.commit();
        
        int col = 0;
        for (String data : array) {
            setValueAt ((String) data, index, col++);            
        }
    }
    
    // delete a row from the table
    public void deleteRow(int row) {
        long id = Long.parseLong(getValueAt(row,0).toString());
        String media = getValueAt(row,1).toString();
	
        EntityTransaction userTransaction = manager.getTransaction();          
        userTransaction.begin();
        mediaService.deleteMedia(id);
        userTransaction.commit();
        mediaResultList.remove(row);        
        fireTableRowsUpdated(row, row);
        
        numrows--;
    }
    
    // locate a media in the table
    public boolean locate(String location) {
        if (mediaService.findMedia(location))        
            return true;
        return false;
    }
}
