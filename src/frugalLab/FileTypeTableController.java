package frugalLab;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;


/**
* 
* @author Hinsen Chan
*/
public class FileTypeTableController implements ListSelectionListener, TableModelListener{
    private FileTypeTableModel fileTypeTableModel;
    private FileTypePanel fileTypePanel;
	
    public FileTypeTableController(FileTypePanel fileTypePanel) {
        this.fileTypePanel = fileTypePanel;   
        // create the tableModel using the data in the cachedRowSet
	fileTypeTableModel = new FileTypeTableModel(); 
	fileTypeTableModel.addTableModelListener(this);
    }	
	
    // new code
    public TableModel getTableModel() {
        return fileTypeTableModel;
    }
	
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	int firstIndex = selectModel.getMinSelectionIndex();
		
	// read the data in each column using getValueAt and display it on corresponding textfield
	fileTypePanel.setFileTypeTextField( (String)fileTypeTableModel.getValueAt(firstIndex, 1));
    }
	
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    //tableModel.getRowSet().moveToCurrentRow();
	    int firstIndex =  e.getFirstRow();
	    	
	    // create a new table model with the new data
	    fileTypeTableModel = new FileTypeTableModel(fileTypeTableModel.getList(), fileTypeTableModel.getEntityManager());
	    fileTypeTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    fileTypePanel.updateTable();
	    
	    // read the data in each column using getValueAt and display it on corresponding textfield
            fileTypePanel.setFileTypeTextField( (String) fileTypeTableModel.getValueAt(firstIndex, 0));            
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    public void addRow(String[] array) {
        fileTypeTableModel.addRow(array);			
    }
    
    public boolean locate(String fileType) {
        return fileTypeTableModel.locate(fileType);
    }
}