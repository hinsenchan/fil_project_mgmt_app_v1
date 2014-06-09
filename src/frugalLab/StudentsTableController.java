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
public class StudentsTableController implements ListSelectionListener, TableModelListener{
    private StudentsTableModel studentsTableModel;
    private StudentsPanel studentsPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
    private String projectID;
	
    public StudentsTableController(StudentsPanel studentsPanel) {
        this.studentsPanel = studentsPanel; 
        projectID = this.studentsPanel.getProjectID();
	studentsTableModel = new StudentsTableModel(getProjectID()); // create new table model
	studentsTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return studentsTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
        studentsPanel.setStudentID( (String)studentsTableModel.getValueAt(firstIndex, 0));
        studentsPanel.setStudentNameTextField( (String)studentsTableModel.getValueAt(firstIndex, 1));
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
            
	    // create a new table model with the new data
	    studentsTableModel = new StudentsTableModel(getProjectID(), studentsTableModel.getList(), studentsTableModel.getEntityManager());
	    studentsTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    studentsPanel.updateTable();	                
            studentsPanel.setStudentNameTextField((String)studentsTableModel.getValueAt(firstIndex, 1));
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array) {   
        try {
            if (!locate(array[0])) {
                studentsTableModel.addRow(array); // add row to database
            }
            else {
                JOptionPane.showMessageDialog(studentsPanel, "This students title already exists!", "Error", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(studentsPanel, "This students name already exists!", 
                        "Error", JOptionPane.ERROR_MESSAGE);      
                }
                else {
                    studentsTableModel.updateRow(firstIndex, array);
                }
            }
            else {
                JOptionPane.showMessageDialog(studentsPanel, "Please select a students to update.", 
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
                    studentsTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                studentsPanel.setStudentNameTextField("");
            }
            else {
                JOptionPane.showMessageDialog(studentsPanel, "Please select a student to delete.", 
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
        studentsPanel.setStudentNameTextField("");
    }
    
    // locate an item in the table
    public boolean locate(String name) {
        return studentsTableModel.locate(name);
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
