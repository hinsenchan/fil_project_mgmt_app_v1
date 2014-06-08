package frugalLab;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/**
* 
* @author Hinsen Chan
*/
public class FileTypeTableController implements ListSelectionListener, TableModelListener{
    private FileTypeTableModel fileTypeTableModel;
    private FileTypePanel fileTypePanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
	
    public FileTypeTableController(FileTypePanel fileTypePanel) {
        this.fileTypePanel = fileTypePanel;   
	fileTypeTableModel = new FileTypeTableModel(); // create new table model
	fileTypeTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return fileTypeTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
	fileTypePanel.setFileTypeTextField( (String)fileTypeTableModel.getValueAt(firstIndex, 1));
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
	    	
	    // create a new table model with the new data
	    fileTypeTableModel = new FileTypeTableModel(fileTypeTableModel.getList(), fileTypeTableModel.getEntityManager());
	    fileTypeTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    fileTypePanel.updateTable();	    	   
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array) {   
        try {
            if (!locate(array[0])) {
                fileTypeTableModel.addRow(array); // add row to database
                tableChanged(new TableModelEvent(getTableModel())); 
            }
            else {
                JOptionPane.showMessageDialog(fileTypePanel, "This file type already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            jTableRowSelected = false; // row is deselected in jTable
        }
    }
    
    // update a row in the table
    public void updateRow(String[] array) {
        try {
            if (jTableRowSelected == true) {
                if (locate(array[0])) {
                    JOptionPane.showMessageDialog(fileTypePanel, "This file type already exists!", 
                        "Error", JOptionPane.ERROR_MESSAGE);      
                }
                fileTypeTableModel.updateRow(firstIndex, array);
                tableChanged(new TableModelEvent(getTableModel()));
                fileTypePanel.setFileTypeTextField((String)fileTypeTableModel.getValueAt(getSelectedIndex(),1));
            }
            else {
                JOptionPane.showMessageDialog(fileTypePanel, "Please select a file type to update.", 
                    "Error", JOptionPane.ERROR_MESSAGE);  
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            jTableRowSelected = false; // row is deselected in jTable
        }
    }

    // delete a row from the table
    public void deleteRow(int[] index) {
        try {            
            List<Integer> list = new ArrayList<Integer>();
            
            for (int data: index) {
                list.add(data);
            }
            
            Collections.sort(list,Collections.reverseOrder());

            
            if (jTableRowSelected == true) {
                for (int data : list) {
                    fileTypeTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                fileTypePanel.setFileTypeTextField("");
            }
            else {
                JOptionPane.showMessageDialog(fileTypePanel, "Please select a file type to delete.", 
            	    "Error", JOptionPane.ERROR_MESSAGE);  
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            jTableRowSelected = false; // row is deselected in jTable
        }
    }
    
    // clear textfield in panel
    public void clearRow() {
        fileTypePanel.setFileTypeTextField("");
    }
    
    // locate an item in the table
    public boolean locate(String fileType) {
        return fileTypeTableModel.locate(fileType);
    }

    /**
     * @return the selectedIndex
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param selectedIndex the selectedIndex to set
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
}
