/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Hinsen Chan
 */
public class FrugalController {
    private FrugalView frugalView;
    private FrugalModel frugalModel;
    private boolean loggedIn = false;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private String pid;
    
    public FrugalController(FrugalView frugalView) {
        this.frugalView = frugalView;
        frugalModel = new FrugalModel();        
        setupComponents();
    }
    
    public void setupComponents() {
        mainPanel = frugalView.getMainPanel();
        cardLayout = (CardLayout)mainPanel.getLayout();        
    }
    
    public void launchSearchPanel() {
        cardLayout.show(mainPanel, "SearchPanel");
    }
            
    public void launchResultPanel() {       
        cardLayout.show(mainPanel, "ResultPanel");
    }
    
    public void launchMediaViewPanel() {       
        cardLayout.show(mainPanel, "MediaViewPanel");
    }
    
    public void launchOtherDataViewPanel() {       
        cardLayout.show(mainPanel, "OtherDataViewPanel");
    }    
    
    public void launchFilterPanel() {
        cardLayout.show(mainPanel, "FilterPanel");
    }
        
    public void launchLoginPanel() {
        cardLayout.show(mainPanel, "LoginPanel");
    }
    
    public void launchManagePanel() {
        if (isLoggedIn()) {
            cardLayout.show(mainPanel, "ManagePanel");            
        }
        else 
            launchLoginPanel();
    }
    
    public void launchUserManagerPanel() {
        cardLayout.show(mainPanel, "UserManagerPanel");
    }
    
    public void launchProjectPanel() {
        cardLayout.show(mainPanel, "ProjectPanel");
    }
    
    public void launchStudentsPanel() {
        frugalView.setStudentsPanel(new StudentsPanel(this));
        mainPanel.add(frugalView.getStudentsPanel(), "StudentsPanel");        
        cardLayout.show(mainPanel, "StudentsPanel");
    }
    
    public void launchPartnersPanel() {
        cardLayout.show(mainPanel, "PartnersPanel");
    }    
    
    public void launchAdvisorsPanel() {
        cardLayout.show(mainPanel, "AdvisorsPanel");
    }    

    public void launchCategoryPanel() {
        cardLayout.show(mainPanel, "CategoryPanel");
    }    
    
    public void launchTagPanel() {
        cardLayout.show(mainPanel, "TagPanel");
    }
    
    public void launchMediaPanel() {
        cardLayout.show(mainPanel, "MediaPanel");
    }
    
    public void launchFileTypePanel() {
        cardLayout.show(mainPanel, "FileTypePanel");
    }
    
    public void launchOtherDataPanel() {
        cardLayout.show(mainPanel, "OtherDataPanel");
    }    

    /**
     * @return the isLoggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }
}
