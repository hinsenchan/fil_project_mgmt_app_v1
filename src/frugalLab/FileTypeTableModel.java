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
public class FileTypeTableModel extends AbstractTableModel {
    List<FileType> fileTypeResultList;   // stores the model data in a List collection of type FileType
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private FileType fileType;	
    private FileTypeService fileTypeService;
    
    int numcols, numrows;           // number of rows and columns
    
    public FileTypeTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	fileType = new FileType();
	fileTypeService = new FileTypeService(manager);
	    
	// read all the records from courselist
	fileTypeResultList = fileTypeService.readAll();
	    
	// update the number of rows and columns in the model
	numrows = fileTypeResultList.size();
	numcols = fileType.getNumberOfColumns();
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
            return fileTypeResultList.get(row).getColumnData(col);
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
            return fileType.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            FileType element = fileTypeResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<FileType> getList() {
        return fileTypeResultList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public FileTypeTableModel(List<FileType> list, EntityManager em)  {
        fileTypeResultList = list;
	numrows = fileTypeResultList.size();
	fileType = new FileType();
	numcols = fileType.getNumberOfColumns();     
	manager = em;  
	fileTypeService = new FileTypeService(manager);
    }
	 
    // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
    // The argument to this method is an array containing the data in the textfields of the new row.
    public void addRow(Object[] array) {
        //data[rowIndex][columnIndex] = (String) aValue;	        
        
	// add row to database
	EntityTransaction userTransaction = manager.getTransaction();  
	userTransaction.begin();
	FileType newRecord = fileTypeService.createFileType((String)array[0]);
	userTransaction.commit();
		 
	// set the current row to rowIndex
        fileTypeResultList.add(newRecord);
        
        int row = fileTypeResultList.size();  
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
	FileType updatedRecord = fileTypeService.updateFileType((long)index, array[0]);
	userTransaction.commit();
        
        for (String data : array) {
            setValueAt ((String) data, index, 1);            
        }
    }
    
    // delete a row from the table
    public void deleteRow(int row) {
        long id = Long.parseLong(getValueAt(row,0).toString());
        String fileType = getValueAt(row,1).toString();
	
        EntityTransaction userTransaction = manager.getTransaction();          
        userTransaction.begin();
        fileTypeService.deleteFileType(id);
        userTransaction.commit();
        fileTypeResultList.remove(row);        
        fireTableRowsUpdated(row, row);
        
        numrows--;
    }
    
    // locate a file type in the table
    public boolean locate(String fileType) {
        if (fileTypeService.findFileType(fileType))        
            return true;
        return false;
    }
}