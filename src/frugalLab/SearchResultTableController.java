package frugalLab;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;


/**
* 
* @author Hinsen Chan
*/
public class SearchResultTableController implements ListSelectionListener, TableModelListener{
    private SearchResultTableModel searchResultTableModel;

    public SearchResultTableModel getSearchResultTableModel() {
        return searchResultTableModel;
    }

    public void setSearchResultTableModel(SearchResultTableModel searchResultTableModel) {
        this.searchResultTableModel = searchResultTableModel;
    }
    private SearchResultPanel searchResultPanel; 
    private boolean jTableRowSelected = false; // monitors if row is selected in jTable
    private int firstIndex; // first selected index in the table
    private int selectedIndex; // selected index in the table
    String searchTerm;
    
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml

    
    private static EntityManagerFactory factory;  

    private EntityManager manager;

    private StudentsService studentsService;
    private PartnersService partnersService;
    private AdvisorsService advisorsService;
    private CategoryService categoryService;
    
	
    public SearchResultTableController(SearchResultPanel searchResultPanel) {
        this.searchResultPanel = searchResultPanel;
       // searchResultTableModel.setSearchTerm(searchTerm);

	searchResultTableModel = new SearchResultTableModel(); // create new table model
	searchResultTableModel.addTableModelListener(this); // listen to this controller with table model
        
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();

        studentsService = new StudentsService(manager, "");
        partnersService = new PartnersService(manager, "");
        advisorsService = new AdvisorsService(manager, "");

        //searchResultTableModel.setSearchTerm(searchTerm);
        //System.out.println("SearchResultTableController------"+searchTerm);
    }	
	
    public void setFilters(String[] statusFilter, String[] categoryFilter, String[] tagFilter, String[] studentFilter, String[] partnerFilter, String[] advisorFilter, String[] mediaFilter)
    {
        searchResultTableModel.setFilters(statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter ,advisorFilter, mediaFilter);
        searchResultTableModel.updateTableModel();
    }
    
    // returns the table model for this controller
    public TableModel getTableModel() {
        return searchResultTableModel;
    }
    
    // listselection handler. updates textfield in panel
    public void valueChanged(ListSelectionEvent e) {        
        jTableRowSelected = true; // row is selected in jTable
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	firstIndex = selectModel.getMinSelectionIndex();             

	// read the data in each column using getValueAt and display it on corresponding textfield
	searchResultPanel.setProjectIDTextField( (String)searchResultTableModel.getValueAt(firstIndex, 0));
        searchResultPanel.setTitleTextField( (String)searchResultTableModel.getValueAt(firstIndex, 1));
        searchResultPanel.setStatusTextField( (String)searchResultTableModel.getValueAt(firstIndex, 2));
        searchResultPanel.setStartDateTextField( (String)searchResultTableModel.getValueAt(firstIndex, 3));
        searchResultPanel.setEndDateTextField( (String)searchResultTableModel.getValueAt(firstIndex, 4));
        
        //textareas
        
        searchResultPanel.setOutcomeTextArea( (String)searchResultTableModel.getValueAt(firstIndex, 5));
        
        // other sql calls
        
        // Handling students field
        
        studentsService = new StudentsService(manager, (String)searchResultTableModel.getValueAt(firstIndex, 0));
        
        List<Students> studentList = studentsService.readAll();//(Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0)));

        String students = "";
        //System.out.println("--------------here" + studentList.size());
        for(int i = 0; i < studentList.size(); i++)
        {
                students+=studentList.get(i).getName();
                if(i+1 != studentList.size())
                    students+=", ";
        }
                
        searchResultPanel.setStudentsTextArea( students );
        
        // Handling Partners field
        
        partnersService = new PartnersService(manager, (String)searchResultTableModel.getValueAt(firstIndex, 0));
        
        List<Partners> partnerList = partnersService.readAll();//(Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0)));

        String partners = "";
        //System.out.println("--------------here" + studentList.size());
        for(int i = 0; i < partnerList.size(); i++)
        {
                partners+=partnerList.get(i).getName();
                if(i+1 != partnerList.size())
                    partners+=", ";
        }
                
        searchResultPanel.setPartnersTextArea( partners );        
        
        // Handling Advisors field
        
        advisorsService = new AdvisorsService(manager, (String)searchResultTableModel.getValueAt(firstIndex, 0));
        
        List<Advisors> advisorList = advisorsService.readAll();//(Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0)));

        String advisors = "";
        //System.out.println("--------------here" + studentList.size());
        for(int i = 0; i < advisorList.size(); i++)
        {
                advisors+=advisorList.get(i).getName();
                if(i+1 != advisorList.size())
                    advisors+=", ";
            
        }
                
        searchResultPanel.setAdvisorsTextArea( advisors );        
        
        
        // Handling Categories field
        
        
        CategoryService categoryService = new CategoryService(manager);//, (String)searchResultTableModel.getValueAt(firstIndex, 0));
        
        List<Category> categoryList = categoryService.readAll();//(Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0)));

        String categories = "";
        //System.out.println("--------------here" + studentList.size());
        Long pid = Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0));
        for(int i = 0; i < categoryList.size(); i++)
        {
            Set<Project> S = categoryList.get(i).getProjects();
            
            for (Project p : S)
            {
                //System.out.println("Categories -- : " + categoryList.get(i).getCategory()+ " -- ProjectID -- : " + p.getId() + " compare to : "+ pid);
                if(p.getId().longValue() == pid.longValue())
                {
                    //System.out.println("HELLO IN Category"+categoryList.get(i).getCategory());
                        if(!categories.isEmpty())
                            categories+=", ";
                        categories+=categoryList.get(i).getCategory();

                }
            }
        }       
        
        searchResultPanel.setCategoriesTextArea( categories );        

        
        // Handling Tags field
        
        TagService tagService = new TagService(manager);//, (String)searchResultTableModel.getValueAt(firstIndex, 0));
        
        List<Tag> tagList = tagService.readAll();//(Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0)));

        String tags = "";
        //System.out.println("--------------here" + studentList.size());
        //Long pid = Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0));
        for(int i = 0; i < tagList.size(); i++)
        {
            Set<Project> S = tagList.get(i).getProjects();
            
            for (Project p : S)
            {
                //System.out.println("Tags -- : " + tagList.get(i).getTag()+ " -- ProjectID -- : " + p.getId() + " compare to : "+ pid);
                if(p.getId().longValue() == pid.longValue())
                {
                    //System.out.println("HELLO IN TAG");
                        if(!tags.isEmpty())
                           tags+=", ";
                        tags+=tagList.get(i).getTag();

                }
            }
        }
                
        searchResultPanel.setTagsTextArea( tags );        
        
        

        
        String startDate = ""; 
        String endDate = "";         
        String projectCount = ""; 
        String statusCount = ""; 
        
        List<Project> projectList = searchResultTableModel.getList();
        ArrayList<String> stitle = new ArrayList<String>();
        ArrayList<Integer> scount = new ArrayList<Integer>();
        int x;
        Date laterDate = new Date(3000, 03, 03);
        
        if(projectList.size()>0)
        {
        Date sdate = projectList.get(0).getStartDate();
        Date edate = projectList.get(0).getEndDate();
        
        
        for(Project p : projectList)
        {
            if(!stitle.contains(p.getTitle()))
            {
                stitle.add(p.getTitle());
                scount.add(1);
            }
            else if(stitle.contains(p.getTitle()))
            {
                scount.set(stitle.indexOf(p.getTitle()), stitle.indexOf(p.getTitle())+1);
            }
            

            if(sdate.before(p.getStartDate()))
            {
                sdate = p.getStartDate();
            }
            if(p.getEndDate() == null || edate == null)
            {
                edate = null;
            }
            else if(edate.after(p.getEndDate()))
            {
                edate = p.getEndDate();
            }
        }
        x = 0;
        for(String p : stitle)
        {
            statusCount += p + " : " + scount.get(x) + "\n";
            x++;
        }
        
        startDate += sdate.toString();
        if(edate == null)
            endDate = "In Progress";
        else
            endDate += edate.toString();
        
        }
        else
            statusCount = "";
        

        
        projectCount = "" + projectList.size();
        
        String categoryCount = "";
        
        stitle = new ArrayList<String>();
        scount = new ArrayList<Integer>();
        for(Category p : categoryList)
        {
            if(!stitle.contains(p.getCategory()))
            {
                stitle.add(p.getCategory());
                scount.add(1);
            }
            else if(stitle.contains(p.getCategory()))
            {
                scount.set(stitle.indexOf(p.getCategory()), stitle.indexOf(p.getCategory())+1);
            }
        }
        
        x = 0;
        for(String p : stitle)
        {
            categoryCount += p + " : " + scount.get(x) + "\n";
            x++;
        }
        
        
        String tagCount = ""; 
        
        stitle = new ArrayList<String>();
        scount = new ArrayList<Integer>();
        for(Tag p : tagList)
        {
            if(!stitle.contains(p.getTag()))
            {
                stitle.add(p.getTag());
                scount.add(1);
            }
            else if(stitle.contains(p.getTag()))
            {
                scount.set(stitle.indexOf(p.getTag()), stitle.indexOf(p.getTag())+1);
            }
        }
        
        x = 0;
        for(String p : stitle)
        {
            tagCount += p + " : " + scount.get(x) + "\n";
            x++;
        }
        
        String studentsCount = ""; 
        
        studentsCount =  "Total number of students in this search : " + studentList.size();
        
        String partnersCount = ""; 
        
        partnersCount =  "Total number of partners in this search : " + partnerList.size();

        
        String advisorsCount = "";        
        
        advisorsCount =  "Total number of advisors in this search : " + advisorList.size();

        searchResultPanel.updateCounts(startDate, projectCount, statusCount, categoryCount, tagCount, endDate, studentsCount, partnersCount, advisorsCount);
    
    }
	
    // table listener. updates table in panel
    public void tableChanged(TableModelEvent e)
    {
        try {
            // get the index of the inserted row
	    firstIndex =  e.getFirstRow();
            
	    // create a new table model with the new data
	    searchResultTableModel = new SearchResultTableModel(searchResultTableModel.getList(), searchResultTableModel.getEntityManager());
	    searchResultTableModel.addTableModelListener(this);
	    // update the JTable with the data
	    searchResultPanel.updateTable();	    
            
            searchResultPanel.setProjectIDTextField((String)searchResultTableModel.getValueAt(firstIndex, 0));
            searchResultPanel.setTitleTextField((String)searchResultTableModel.getValueAt(firstIndex, 1));
            searchResultPanel.setStatusTextField((String)searchResultTableModel.getValueAt(firstIndex, 2));
            searchResultPanel.setStartDateTextField((String)searchResultTableModel.getValueAt(firstIndex, 3));
            searchResultPanel.setEndDateTextField((String)searchResultTableModel.getValueAt(firstIndex, 4));
            
            //textareas
                    
            searchResultPanel.setOutcomeTextArea( (String)searchResultTableModel.getValueAt(firstIndex, 5));
            
                    // Handling students field
        List<Students> studentList = studentsService.readAll();//(Long.parseLong((String)searchResultTableModel.getValueAt(firstIndex, 0)));
        
        
        
        String students = "";
                
        for(int i = 0; i < studentList.size(); i++)
        {
            System.out.println(searchResultTableModel.getValueAt(firstIndex, 0));

            if(searchResultTableModel.getValueAt(firstIndex, 0) == studentList.get(i).getPid())
                students+=studentList.get(i).getName()+" ";
        }
                
        searchResultPanel.setStudentsTextArea( students );
        
        //

            
            searchResultPanel.setPartnersTextArea( (String)searchResultTableModel.getValueAt(firstIndex, 6));
            searchResultPanel.setAdvisorsTextArea( (String)searchResultTableModel.getValueAt(firstIndex, 7));
            searchResultPanel.setCategoriesTextArea( (String)searchResultTableModel.getValueAt(firstIndex, 8));
            searchResultPanel.setTagsTextArea( (String)searchResultTableModel.getValueAt(firstIndex, 9));

        
	} catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
	}
    }

    // locate an item in the table
    public boolean locate(String title) {
        return searchResultTableModel.locate(title);
    }
    
    // locate an item excluding specified primary key
    public boolean locate(String title, String id) {
        return searchResultTableModel.locate(title, id);
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
