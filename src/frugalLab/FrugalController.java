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
    private String searchTerm;
    
    private String[] statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter, advisorFilter, mediaFilter;

    public String[] getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String[] statusFilter) {
        this.statusFilter = statusFilter;
    }

    public String[] getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String[] categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    public String[] getTagFilter() {
        return tagFilter;
    }

    public void setTagFilter(String[] tagFilter) {
        this.tagFilter = tagFilter;
    }

    public String[] getStudentFilter() {
        return studentFilter;
    }

    public void setStudentFilter(String[] studentFilter) {
        this.studentFilter = studentFilter;
    }

    public String[] getPartnerFilter() {
        return partnerFilter;
    }

    public void setPartnerFilter(String[] partnerFilter) {
        this.partnerFilter = partnerFilter;
    }

    public String[] getAdvisorFilter() {
        return advisorFilter;
    }

    public void setAdvisorFilter(String[] advisorFilter) {
        this.advisorFilter = advisorFilter;
    }

    public String[] getMediaFilter() {
        return mediaFilter;
    }

    public void setMediaFilter(String[] mediaFilter) {
        this.mediaFilter = mediaFilter;
    }

    
    public FrugalController(FrugalView frugalView) {
        this.frugalView = frugalView;
        frugalModel = new FrugalModel();        
        setupComponents();
    }
    
    public void setFilters(String[] statusFilter, String[] categoryFilter, String[] tagFilter, String[] studentFilter, String[] partnerFilter, String[] advisorFilter, String[] mediaFilter)
    {
        this.statusFilter = statusFilter;
        this.categoryFilter = categoryFilter;
        this.tagFilter = tagFilter;
        this.statusFilter = statusFilter;
        this.studentFilter = studentFilter;
        this.partnerFilter = partnerFilter;
        this.advisorFilter = advisorFilter;
        this.mediaFilter = mediaFilter;
        
        frugalView.upFilters();
        
    }
    
    public void populateCounts(String startDate, String projectCount, String statusCount, String categoryCount, String tagCount, String endDate, String studentsCount, String partnersCount, String advisorsCount)
    {
        frugalView.updateCounts(startDate, projectCount, statusCount, categoryCount, tagCount,endDate, studentsCount, partnersCount, advisorsCount);
    }
    
    public void setupComponents() {
        mainPanel = frugalView.getMainPanel();
        cardLayout = (CardLayout)mainPanel.getLayout();        
    }
    
    public void launchSearchPanel() {
        cardLayout.show(mainPanel, "SearchPanel");
    }
            
    public void launchResultPanel() {  
        frugalView.refreshSearchResultPanel();        
        cardLayout.show(mainPanel, "ResultPanel");
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void launchMediaViewPanel() {    
        frugalView.refreshMediaViewPanel();
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
        frugalView.setProjectPanel(new ProjectPanel(this));
        mainPanel.add(frugalView.getProjectPanel(), "ProjectPanel");          
        cardLayout.show(mainPanel, "ProjectPanel");
    }
    
    public void launchStudentsPanel() {
        frugalView.setStudentsPanel(new StudentsPanel(this));
        mainPanel.add(frugalView.getStudentsPanel(), "StudentsPanel");        
        cardLayout.show(mainPanel, "StudentsPanel");
    }
    
    public void launchPartnersPanel() {
        frugalView.setPartnersPanel(new PartnersPanel(this));
        mainPanel.add(frugalView.getPartnersPanel(), "PartnersPanel"); 
        cardLayout.show(mainPanel, "PartnersPanel");
    }    
    
    public void launchAdvisorsPanel() {
        frugalView.setAdvisorsPanel(new AdvisorsPanel(this));
        mainPanel.add(frugalView.getAdvisorsPanel(), "AdvisorsPanel");        
        cardLayout.show(mainPanel, "AdvisorsPanel");
    }    

    public void launchCategoryPanel() {
        cardLayout.show(mainPanel, "CategoryPanel");
    }    
    
    public void launchTagPanel() {
        cardLayout.show(mainPanel, "TagPanel");
    }
    
    public void launchMediaPanel() {
        frugalView.setMediaPanel(new MediaPanel(this));
        mainPanel.add(frugalView.getMediaPanel(), "MediaPanel");        
        cardLayout.show(mainPanel, "MediaPanel");
    }
    
    public void launchFileTypePanel() {
        cardLayout.show(mainPanel, "FileTypePanel");
    }
    
    public void launchOtherDataPanel() {
        frugalView.setOtherDataPanel(new OtherDataPanel(this));
        mainPanel.add(frugalView.getOtherDataPanel(), "OtherDataPanel");        
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
    
    public void setSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }
    public String getSearchTerm(){
        return this.searchTerm;
    }
}
