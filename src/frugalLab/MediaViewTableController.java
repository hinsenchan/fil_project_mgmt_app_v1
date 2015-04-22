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
public class MediaViewTableController implements ListSelectionListener, TableModelListener{
    private MediaViewTableModel mediaViewTableModel;
    private MediaViewPanel mediaPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
    private String projectID;
	
    public MediaViewTableController(MediaViewPanel mediaPanel) {
        this.mediaPanel = mediaPanel; 
        projectID = this.mediaPanel.getProjectID();
	mediaViewTableModel = new MediaViewTableModel(getProjectID()); // create new table model
	mediaViewTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public MediaViewTableModel getMediaViewTableModel() {
        return mediaViewTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();     
		
	// read the data in each column using getValueAt and display it on corresponding textfield
        mediaPanel.setMediaID( (String)mediaViewTableModel.getValueAt(firstIndex, 0));
        mediaPanel.setFileNameTextField1( (String)mediaViewTableModel.getValueAt(firstIndex, 1));
        mediaPanel.setFileNameTextField( (String)mediaViewTableModel.getValueAt(firstIndex, 2));
        mediaPanel.setFileLocationTextField( (String)mediaViewTableModel.getValueAt(firstIndex, 3));
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
            
	    // create a new table model with the new data
	    mediaViewTableModel = new MediaViewTableModel(getProjectID(), mediaViewTableModel.getList(), mediaViewTableModel.getEntityManager());
	    mediaViewTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    mediaPanel.updateTable();	                
            mediaPanel.setFileNameTextField1( (String)mediaViewTableModel.getValueAt(firstIndex, 1));
            mediaPanel.setFileNameTextField( (String)mediaViewTableModel.getValueAt(firstIndex, 2));
            mediaPanel.setFileLocationTextField( (String)mediaViewTableModel.getValueAt(firstIndex, 3));
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
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
