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
public class TagTableController implements ListSelectionListener, TableModelListener{
    private TagTableModel tagTableModel;
    private TagPanel tagPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
	
    public TagTableController(TagPanel tagPanel) {
        this.tagPanel = tagPanel;   
	tagTableModel = new TagTableModel(); // create new table model
	tagTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return tagTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
	tagPanel.setTagTextField( (String)tagTableModel.getValueAt(firstIndex, 1));
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
	    	
	    // create a new table model with the new data
	    tagTableModel = new TagTableModel(tagTableModel.getList(), tagTableModel.getEntityManager());
	    tagTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    tagPanel.updateTable();	    	   
            
            //experimenting with this...
            tagPanel.setTagTextField( (String)tagTableModel.getValueAt(firstIndex, 1));
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array) {   
        try {
            if (!locate(array[0])) {
                tagTableModel.addRow(array); // add row to database
                tableChanged(new TableModelEvent(getTableModel())); 
            }
            else {
                JOptionPane.showMessageDialog(tagPanel, "This tag already exists!", "Error", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(tagPanel, "This tag already exists!", 
                        "Error", JOptionPane.ERROR_MESSAGE);      
                }
                else {
                    tagTableModel.updateRow(firstIndex, array);
                    //tableChanged(new TableModelEvent(getTableModel()));
                    //tagPanel.setTagTextField((String)tagTableModel.getValueAt(getSelectedIndex(),1));
                }
            }
            else {
                JOptionPane.showMessageDialog(tagPanel, "Please select a tag to update.", 
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
                    tagTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                tagPanel.setTagTextField("");
            }
            else {
                JOptionPane.showMessageDialog(tagPanel, "Please select a tag to delete.", 
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
        tagPanel.setTagTextField("");
    }
    
    // locate an item in the table
    public boolean locate(String tag) {
        return tagTableModel.locate(tag);
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
