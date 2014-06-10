package frugalLab;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;


/**
* 
* @author Hinsen Chan
*/
public class ProjectTableController implements ListSelectionListener, TableModelListener{
    private ProjectTableModel projectTableModel;
    private ProjectPanel projectPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
	
    public ProjectTableController(ProjectPanel projectPanel) {
        this.projectPanel = projectPanel;   
	projectTableModel = new ProjectTableModel(); // create new table model
	projectTableModel.addTableModelListener(this); // listen to this controller with table model
    }	
	
    // returns the table model for this controller
    public TableModel getTableModel() {
        return projectTableModel;
    }
	
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();             
		
	// read the data in each column using getValueAt and display it on corresponding textfield
	projectPanel.setProjectIDTextField( (String)projectTableModel.getValueAt(firstIndex, 0));
        projectPanel.setTitleTextField( (String)projectTableModel.getValueAt(firstIndex, 1));
        projectPanel.setStatusComboBox( (String)projectTableModel.getValueAt(firstIndex, 2));
        projectPanel.setStartDateTextField( (String)projectTableModel.getValueAt(firstIndex, 3));
        projectPanel.setEndDateTextField( (String)projectTableModel.getValueAt(firstIndex, 4));
        projectPanel.setOutcomeTextArea( (String)projectTableModel.getValueAt(firstIndex, 5));
        
        Set<Category> catSet;
        String[] catList;
        Iterator<Category> iter;
        int counter = 0;
        
        try {
            catSet = projectTableModel.getList().get(firstIndex).getCategory();
            catList = new String[catSet.size()];
            iter = catSet.iterator();
            
            while (iter.hasNext()) {
                catList[counter++] = iter.next().getCategory();
            }
            
            projectPanel.setCategoriesList(catList);
        }
        catch (Exception ex) {}     
        
        Set<Tag> tagSet;
        String[] tagList;
        Iterator<Tag> iter2;
        counter = 0;
        
        try {
            tagSet = projectTableModel.getList().get(firstIndex).getTag();
            tagList = new String[tagSet.size()];
            iter2 = tagSet.iterator();
            
            while (iter2.hasNext()) {
                tagList[counter++] = iter2.next().getTag();
            }
            
            /*
            for (String data : tagList) {
                //System.out.println(data);
            }
            */
            
            int[] indices = new int[tagList.length];
            counter = 0;

            for (int i = 0; i < projectPanel.getTagJList().getModel().getSize(); i++) {
                for (int j = 0; j < tagList.length; j++) {
                    if (projectPanel.getTagJList().getModel().getElementAt(i).toString().equals(tagList[j])) {
                        indices[counter++] = i;
                    }
                }
            }           
            projectPanel.getTagJList().setSelectedIndices(indices);
        }
        catch (Exception ex) {}                         
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
            
	    // create a new table model with the new data
	    projectTableModel = new ProjectTableModel(projectTableModel.getList(), projectTableModel.getEntityManager(), projectTableModel.getCategories(), projectTableModel.getTags());
	    projectTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    projectPanel.updateTable();	    
            
            projectPanel.setProjectIDTextField((String)projectTableModel.getValueAt(firstIndex, 0));
            projectPanel.setTitleTextField((String)projectTableModel.getValueAt(firstIndex, 1));
            projectPanel.setStatusComboBox((String)projectTableModel.getValueAt(firstIndex, 2));
            projectPanel.setStartDateTextField((String)projectTableModel.getValueAt(firstIndex, 3));
            projectPanel.setEndDateTextField((String)projectTableModel.getValueAt(firstIndex, 4));
            projectPanel.setOutcomeTextArea((String)projectTableModel.getValueAt(firstIndex, 5));
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // add a new row to the table
    public void addRow(String[] array, String category, List<String> tags) {   
        try {
            if (!locate(array[0])) {
                projectTableModel.addRow(array, category, tags); // add row to database
            }
            else {
                JOptionPane.showMessageDialog(projectPanel, "This project title already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            jTableRowSelected = false; // row is deselected in jTable
        }
    }
    
    // update a row in the table
    public void updateRow(String[] array, String category, List<String> tags) {
        try {
            if (jTableRowSelected == true) {
                if (locate(array[1], array[0])) {                    
                    JOptionPane.showMessageDialog(projectPanel, "This project title already exists!", 
                        "Error", JOptionPane.ERROR_MESSAGE);      
                }
                else {
                    projectTableModel.updateRow(firstIndex, array, category, tags);
                }
            }
            else {
                JOptionPane.showMessageDialog(projectPanel, "Please select a project to update.", 
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
                    projectTableModel.deleteRow(data); // delete row from jTable                
                }
                
                tableChanged(new TableModelEvent(getTableModel()));                
                projectPanel.setProjectIDTextField("");
                projectPanel.setTitleTextField("");
                projectPanel.setStatusComboBox("Please select one...");
                projectPanel.setStartDateTextField("");
                projectPanel.setEndDateTextField("");
                projectPanel.setOutcomeTextArea("");
            }
            else {
                JOptionPane.showMessageDialog(projectPanel, "Please select a project to delete.", 
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
        projectPanel.setProjectIDTextField("");
        projectPanel.setTitleTextField("");
        projectPanel.setStatusComboBox("Please select one...");
        projectPanel.setStartDateTextField("");
        projectPanel.setEndDateTextField("");
        projectPanel.setOutcomeTextArea("");
    }
    
    // locate an item in the table
    public boolean locate(String title) {
        return projectTableModel.locate(title);
    }
    
    // locate an item excluding specified primary key
    public boolean locate(String title, String id) {
        return projectTableModel.locate(title, id);
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
