package frugalLab;

import javax.swing.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
* 
* @author Hinsen Chan
*/
public class UserManagerTableController implements ListSelectionListener, TableModelListener{
    private UserManagerTableModel userManagerTableModel;
    private UserManagerPanel userManagerPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
	
    public UserManagerTableController(UserManagerPanel userManagerPanel) {
        this.userManagerPanel = userManagerPanel;   
	userManagerTableModel = new UserManagerTableModel(); // create new table model
	userManagerTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return userManagerTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
        userManagerPanel.setUserIDTextField( (String)userManagerTableModel.getValueAt(firstIndex, 0));
	userManagerPanel.setUsernameTextField( (String)userManagerTableModel.getValueAt(firstIndex, 1));
        userManagerPanel.setPwPasswordField( (String)userManagerTableModel.getValueAt(firstIndex, 2));
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
	    	
	    // create a new table model with the new data
	    userManagerTableModel = new UserManagerTableModel(userManagerTableModel.getList(), userManagerTableModel.getEntityManager());
	    userManagerTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    userManagerPanel.updateTable();	    	   
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array) {   
        try {
            if (!locate(array[0])) {
                userManagerTableModel.addRow(array); // add row to database
                tableChanged(new TableModelEvent(getTableModel())); 
            }
            else {                
                //JOptionPane.showMessageDialog(userManagerPanel, "This username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
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
                    //JOptionPane.showMessageDialog(userManagerPanel, "This username already exists!", 
                        //"Error", JOptionPane.ERROR_MESSAGE);      
                }
                userManagerTableModel.updateRow(firstIndex, array);
                tableChanged(new TableModelEvent(getTableModel()));
                        userManagerPanel.setUserIDTextField( (String)userManagerTableModel.getValueAt(firstIndex, 0));
	                userManagerPanel.setUsernameTextField( (String)userManagerTableModel.getValueAt(firstIndex, 1));
                        userManagerPanel.setPwPasswordField( (String)userManagerTableModel.getValueAt(firstIndex, 2));
            }
            else {
                //JOptionPane.showMessageDialog(userManagerPanel, "Please select a user account to update.", 
                    //"Error", JOptionPane.ERROR_MESSAGE);  
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
                    userManagerTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                userManagerPanel.setUserIDTextField("");
                userManagerPanel.setUsernameTextField("");
                userManagerPanel.setPwPasswordField("");
            }
            else {
                //JOptionPane.showMessageDialog(this, "Please select a user account to delete.", 
                        //"Error", JOptionPane.ERROR_MESSAGE);  
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
                userManagerPanel.setUserIDTextField("");
                userManagerPanel.setUsernameTextField("");
                userManagerPanel.setPwPasswordField("");
    }
    
    // locate an item in the table
    public boolean locate(String userName ){
        return userManagerTableModel.locate(userName);
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
