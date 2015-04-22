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
public class AdvisorsTableController implements ListSelectionListener, TableModelListener{
    private AdvisorsTableModel advisorsTableModel;
    private AdvisorsPanel advisorsPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
    private String projectID;
	
    public AdvisorsTableController(AdvisorsPanel advisorsPanel) {
        this.advisorsPanel = advisorsPanel; 
        projectID = this.advisorsPanel.getProjectID();
	advisorsTableModel = new AdvisorsTableModel(getProjectID()); // create new table model
	advisorsTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return advisorsTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
        advisorsPanel.setAdvisorID( (String)advisorsTableModel.getValueAt(firstIndex, 0));
        advisorsPanel.setAdvisorNameTextField( (String)advisorsTableModel.getValueAt(firstIndex, 1));
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
            
	    // create a new table model with the new data
	    advisorsTableModel = new AdvisorsTableModel(getProjectID(), advisorsTableModel.getList(), advisorsTableModel.getEntityManager());
	    advisorsTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    advisorsPanel.updateTable();	                
            advisorsPanel.setAdvisorNameTextField((String)advisorsTableModel.getValueAt(firstIndex, 1));
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array) {   
        try {
            if (!locate(array[0])) {
                advisorsTableModel.addRow(array); // add row to database
            }
            else {
                JOptionPane.showMessageDialog(advisorsPanel, "This advisors title already exists!", "Error", JOptionPane.ERROR_MESSAGE);
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
                if (locate(array[1])) {                    
                    JOptionPane.showMessageDialog(advisorsPanel, "This advisors name already exists!", 
                        "Error", JOptionPane.ERROR_MESSAGE);      
                }
                else {
                    advisorsTableModel.updateRow(firstIndex, array);
                }
            }
            else {
                JOptionPane.showMessageDialog(advisorsPanel, "Please select a advisors to update.", 
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
                    advisorsTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                advisorsPanel.setAdvisorNameTextField("");
            }
            else {
                JOptionPane.showMessageDialog(advisorsPanel, "Please select a advisor to delete.", 
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
        advisorsPanel.setAdvisorNameTextField("");
    }
    
    // locate an item in the table
    public boolean locate(String name) {
        return advisorsTableModel.locate(name);
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
