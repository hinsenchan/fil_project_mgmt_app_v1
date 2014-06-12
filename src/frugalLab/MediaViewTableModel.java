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
public class MediaViewTableModel extends AbstractTableModel {
    List<Media> mediaResultList;   // stores the model data in a List collection of type Media
//    List<FileType> fileTypes;
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Media media;	
    private MediaService mediaService;    
    int numcols, numrows;           // number of rows and columns
    
    public void updateViewTableModel(String projectID)
    {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	media = new Media();
	mediaService = new MediaService(manager, projectID);
	    
	// read all the records from courselist
	mediaResultList = mediaService.readAll();

        //fileTypes = mediaService.readFileTypes();
	    
	// update the number of rows and columns in the model
	numrows = mediaResultList.size();
	numcols = media.getNumberOfColumns();
    }
    
    public MediaViewTableModel(String projectID) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	media = new Media();
	mediaService = new MediaService(manager, projectID);
	
	// read all the records from courselist
	mediaResultList = mediaService.read();

        //fileTypes = mediaService.readFileTypes();
	    
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
    
    /*public List<FileType> getFileTypes() {
        return fileTypes;
    }*/

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public MediaViewTableModel(String projectID, List<Media> list, EntityManager em)  {
        mediaResultList = list;
	numrows = mediaResultList.size();
	media = new Media();
	numcols = media.getNumberOfColumns();     
	manager = em;  
	mediaService = new MediaService(manager, projectID);
    }
	 

    
    // locate a media in the table
    public boolean locate(String location) {
        if (mediaService.findMedia(location))        
            return true;
        return false;
    }
}
