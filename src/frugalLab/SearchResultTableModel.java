/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Hinsen Chan
 */
public class SearchResultTableModel extends AbstractTableModel {
    List<Project> projectResultList;   // stores the model data in a List collection of type Project
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  
    private EntityManager manager;
    private Project project;	
    private ProjectService projectService;
    private String searchTerm;
    
    private String[] statusFilter;
    private String[] categoryFilter;
    private String[] tagFilter;
    private String[] studentFilter; 
    private String[] partnerFilter; 
    private String[] advisorFilter; 
    private String[] mediaFilter;

    
    int numcols, numrows;           // number of rows and columns
    
    public void updateTableModel() {
                //searchTerm = "";
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	project = new Project();

        
        try{
            Scanner in = new Scanner(new FileReader("searchTerm.txt"));
            if(in.hasNext())
                searchTerm = in.nextLine();
            in.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }	// read all the records from courselist
        
        //System.out.println("SearchResultTableModel --------" + searchTerm);
        if(searchTerm==null || searchTerm.isEmpty())
        {
            projectResultList = projectService.readAll();
        }
        else
        {
            projectResultList = projectService.searchProjects(searchTerm);
        }
        List<Project> TempList = new ArrayList<Project>();
        Iterator<Project> i = projectResultList.iterator();
        while (i.hasNext()) {
            Project p = i.next();
            Set<Tag> s = p.getTag();
            Set<Category> c = p.getCategory();
            Set<Students> S = p.getStudents();

            for(Tag t: s)
            {
                if(tagFilter!=null)
                for(int x = 0; x < tagFilter.length; x++)
                {
                    if(t.getTag().equals(tagFilter[x]))
                    {
                        if(!TempList.contains(p))
                            TempList.add(p);

                    }
                }
            }
            for(Category t: c)
            {
                if(categoryFilter!=null)
                for(int x = 0; x < categoryFilter.length; x++)
                {
                    if(t.getCategory().equals(categoryFilter[x]))
                    {
                        if(!TempList.contains(p))
                            TempList.add(p);

                    }
                }
            }
            if(statusFilter!=null)
                for(int x = 0; x < statusFilter.length; x++)
                {
                    if(p.getStatus().equals(statusFilter[x]))
                    {
                        if(!TempList.contains(p))
                            TempList.add(p);                    }
                }
                        
            for(Students t: S)
            {
                if(studentFilter!=null)
                for(int x = 0; x < studentFilter.length; x++)
                {
                    if(t.getName().equals(studentFilter[x]))
                    {
                        if(!TempList.contains(p))
                            TempList.add(p);
                    }
                }
            }
            if(partnerFilter!=null)
            for(int x = 0; x < partnerFilter.length; x++)
            {
                String pid = p.getId().toString();
                PartnersService partnersService = new PartnersService(manager, pid);
                List<Partners> PTemp = partnersService.readAll();
                
                for(Partners n: PTemp)
                {
                    if(n.getName().equals(partnerFilter[x]))
                        if(!TempList.contains(p))
                            TempList.add(p);
                }
            }
            if(advisorFilter!=null)
            for(int x = 0; x < advisorFilter.length; x++)
            {
                String pid = p.getId().toString();
                AdvisorsService advisorsService = new AdvisorsService(manager, pid);
                List<Advisors> ATemp = advisorsService.readAll();
                
                for(Advisors n: ATemp)
                {
                    if(n.getName().equals(advisorFilter[x]))
                        if(!TempList.contains(p))
                            TempList.add(p);
                }
            }
            
            if(mediaFilter!=null)
            for(int x = 0; x < mediaFilter.length; x++)
            {
                String pid = p.getId().toString();
                MediaService mediaService = new MediaService(manager, pid);
                List<Media> MTemp = mediaService.readAll();
                
                for(Media n: MTemp)
                {
                    if(n.getFileName().equals(mediaFilter[x]))
                        if(!TempList.contains(p))
                            TempList.add(p);
                }
            }
        }
        if(mediaFilter==null && advisorFilter == null && partnerFilter == null && studentFilter == null && statusFilter == null && categoryFilter == null && tagFilter == null)
            TempList = projectResultList;
        
        projectResultList = TempList;
        numrows = projectResultList.size();
	numcols = project.getNumberOfColumns();     

    }
    
    
    public SearchResultTableModel() {
        System.out.println("RESETING EVERYTHING");
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	project = new Project();
	projectService = new ProjectService(manager);
	    
        //searchTerm = "";
        try{
            Scanner in = new Scanner(new FileReader("searchTerm.txt"));
            if(in.hasNext())
                searchTerm = in.nextLine();
            in.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }	// read all the records from courselist
        
        //System.out.println("SearchResultTableModel --------" + searchTerm);
        if(searchTerm==null || searchTerm.isEmpty())
        {
            projectResultList = projectService.readAll();
        }
        else
        {
            projectResultList = projectService.searchProjects(searchTerm);
        }
        
        //go through filters, exclude those that don't correspond with at least one
        
     //statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter, advisorFilter, mediaFilter

        
        
	// update the number of rows and columns in the model
	numrows = projectResultList.size();
	numcols = project.getNumberOfColumns();
        
        
    }
    
    public void setFilters(String[] statusFilter, String[] categoryFilter, String[] tagFilter, String[] studentFilter, String[] partnerFilter, String[] advisorFilter, String[] mediaFilter)
    {
        //System.out.println("HERE - - - -" +tagFilter.length);
        this.statusFilter = statusFilter;
        this.categoryFilter = categoryFilter;
        this.tagFilter = tagFilter;
        this.statusFilter = statusFilter;
        this.studentFilter = studentFilter;
        this.partnerFilter = partnerFilter;
        this.advisorFilter = advisorFilter;
        this.mediaFilter = mediaFilter;
        //System.out.println("HERE + " + tagFilter[0]);
    }
    
    
    // returns a count of the number of rows
    public int getRowCount() {
        return numrows;
    }
	
    // returns a count of the number of columns
    public int getColumnCount() {
        return numcols;
    }    
    
    // returns the data at the given row and column number
    public Object getValueAt(int row, int col) {
        try {
            return projectResultList.get(row).getColumnData(col);
	} catch (Exception e) {
            e.getMessage();
            return null;
	}
    }
    
    // table cells are not editable
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }
	/*
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
	*/
    // returns the name of the column
    public String getColumnName(int col) {
        try {
            return project.getColumnName(col);
	} catch (Exception err) {
            return err.toString();
	}             
    }
	
    public void setSearchTerm(String searchTerm){
        
        this.searchTerm = searchTerm;
    }
    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
	try {
            Project element = projectResultList.get(row);
            element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
	} catch(Exception err) {
            err.toString();
        }	
    }
	
    public List<Project> getList() {
        return projectResultList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public SearchResultTableModel(List<Project> list, EntityManager em)  {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	project = new Project();
	projectService = new ProjectService(manager);
	    
        //searchTerm = "";
        try{
            Scanner in = new Scanner(new FileReader("searchTerm.txt"));
            if(in.hasNext())
                searchTerm = in.nextLine();
            in.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }	// read all the records from courselist
        
        //System.out.println("SearchResultTableModel --------" + searchTerm);
        if(searchTerm==null || searchTerm.isEmpty())
        {
            projectResultList = projectService.readAll();
        }
        else
        {
            projectResultList = projectService.searchProjects(searchTerm);
        }
        
        //go through filters, exclude those that don't correspond with at least one
        
     //statusFilter, categoryFilter, tagFilter, studentFilter, partnerFilter, advisorFilter, mediaFilter

        
        
        
	numrows = projectResultList.size();
	project = new Project();
	numcols = project.getNumberOfColumns();     
	manager = em;  
	projectService = new ProjectService(manager);
    }
	
    // locate a project in the table
    public boolean locate(String title) {
        if (projectService.findProject(title))        
            return true;
        return false;
    }
    
    // locate a project in the table excluding specied primary key
    public boolean locate(String title, String id) {
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(id);
        }
        catch (NumberFormatException e) {}
        
        if (projectService.findProject(title, longProjectID))        
            return true;
        return false;
    }
}