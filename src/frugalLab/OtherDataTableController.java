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
public class OtherDataTableController implements ListSelectionListener, TableModelListener{
    private OtherDataTableModel otherDataTableModel;
    private OtherDataPanel otherDataPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
    private String projectID;
	
    public OtherDataTableController(OtherDataPanel otherDataPanel) {
        this.otherDataPanel = otherDataPanel; 
        projectID = this.otherDataPanel.getProjectID();
	otherDataTableModel = new OtherDataTableModel(getProjectID()); // create new table model
	otherDataTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return otherDataTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
        otherDataPanel.setOtherDataID( (String)otherDataTableModel.getValueAt(firstIndex, 0));
        otherDataPanel.setOtherDataTypeTextField( (String)otherDataTableModel.getValueAt(firstIndex, 1));
        otherDataPanel.setOtherDataValueTextField( (String)otherDataTableModel.getValueAt(firstIndex, 2));        
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
            
	    // create a new table model with the new data
	    otherDataTableModel = new OtherDataTableModel(getProjectID(), otherDataTableModel.getList(), otherDataTableModel.getEntityManager());
	    otherDataTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    otherDataPanel.updateTable();	                
            otherDataPanel.setOtherDataTypeTextField((String)otherDataTableModel.getValueAt(firstIndex, 1));
            otherDataPanel.setOtherDataValueTextField((String)otherDataTableModel.getValueAt(firstIndex, 2));            
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array) {   
        otherDataTableModel.addRow(array); // add row to database
        jTableRowSelected = false; // row is deselected in jTable
    }
    
    // update a row in the table
    public void updateRow(String[] array) {
        try {
            if (jTableRowSelected == true) {
                otherDataTableModel.updateRow(firstIndex, array);
            }
            else {
                JOptionPane.showMessageDialog(otherDataPanel, "Please select an option to update.", 
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
                    otherDataTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                otherDataPanel.setOtherDataTypeTextField("");
                otherDataPanel.setOtherDataValueTextField("");
            }
            else {
                JOptionPane.showMessageDialog(otherDataPanel, "Please select an option to delete.", 
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
        otherDataPanel.setOtherDataTypeTextField("");
        otherDataPanel.setOtherDataValueTextField("");
    }
    
    /*
    // locate an item in the table
    public boolean locate(String name) {
        return otherDataTableModel.locate(name);
    }
    */

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

    /**
     * @return the projectID
     */
    public String getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
}
