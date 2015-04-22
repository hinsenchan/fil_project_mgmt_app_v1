/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import javax.persistence.*;
import java.util.*;
import java.sql.Date;

/**
 *
 * @author Hinsen Chan
 */
public class ProjectService {
    private EntityManager manager;
    
    public ProjectService(EntityManager manager) {
        this.manager = manager;
    }    
    
        // method to create a new record
    public Project createProject(String title, String status, String startDate, String endDate, String outcome, String category, List<String> tags) {        
        Project project = new Project();
        project.setTitle(title);
        project.setStatus(status);
        project.setStartDate(Date.valueOf(startDate));
        if (!endDate.isEmpty()) {
            project.setEndDate(Date.valueOf(endDate));
        }
        project.setOutcome(outcome);
        
        Long newID = -1L;
        List<Category> catList = readCategories();
        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).getCategory().equals(category)) {
                newID = catList.get(i).getId();
                break;
            }
        }
        
        Set<Category> newCategoryList = new TreeSet<Category>();
        Category newCategory = new Category();
        newCategory.setCategory(category);
        newCategory.setId(newID);
        newCategoryList.add(newCategory);
        project.setCategory(newCategoryList);
                
        Long newID2 = -1L;
        List<Tag> tagList = readTags();
        Set<Tag> newTagList = new TreeSet<Tag>();
        for (int i = 0; i < tagList.size(); i++) {
            for (int j = 0; j < tags.size(); j++) {
                if (tagList.get(i).getTag().equals(tags.get(j).toString())) {
                    Tag newTag = new Tag();
                    newID2 = tagList.get(i).getId();
                    newTag.setTag(tags.get(j));
                    newTag.setId(newID2);
                    newTagList.add(newTag);  
                    break;
                }
            }
        }
        project.setTag(newTagList);        
        
        manager.persist(project);
 	return project;
    }
    
    // method to read a record
    public Project readProject(Long id) {
        Project project = manager.find(Project.class, id);
    	return project;   	 
    }
    
    public List<Project> read()
    {

        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e", Project.class);
        List<Project> result =  query.getResultList();
        
    	return result;     
    }
    // method to read all records
    public List<Project> readAll() {
        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e", Project.class);
        List<Project> result =  query.getResultList();
        
        
        List<Project> projList = findCatRelatedProjects();
        List<Category> catList = findRelatedCategories();        
        
        for (int i = 0; i < projList.size(); i++) {
            if (result.contains(projList.get(i))) {
                for (int j = 0; j < result.size(); j++) {
                    if (result.get(j).getId().equals(projList.get(i).getId())) {
                        Set<Category> catSet = new TreeSet<Category>();
                        catSet.add(catList.get(i));                        
                        result.get(j).setCategory(catSet);
                    }
                }
            }
        }
        
        //List<Project> projList2 = findTagRelatedProjects();
        //List<Tag> tagList = findRelatedTags();
        /*
        for (int i=0; i<projList2.size(); i++) {
            System.out.println(projList2.get(i));
        }
        for (int i=0; i<projList2.size(); i++) {
            System.out.println(tagList.get(i));
        }
        
        for (int i = 0; i < projList2.size(); i++) {            
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).getId().equals(projList2.get(i).getId())) {     
                    result.get(j).getTag().add(tagList.get(i));
                    break;
                }
            }
        }
        
        for (int i = 0; i< result.size(); i++) {
            System.out.println(result.get(i));
        }
        */
        
    	return result;   	 
    }
    
    public List<Project> findCatRelatedProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e JOIN e.category f", Project.class);
        List<Project> result =  query.getResultList();
        return result;
    }            
    
    public List<Category> findRelatedCategories() {
        TypedQuery<Category> query = manager.createQuery("SELECT e FROM CATEGORY e JOIN e.projects f", Category.class);
        List<Category> result =  query.getResultList();
        return result;
    }        
    
    public List<Project> findTagRelatedProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e JOIN e.tags f", Project.class);
        List<Project> result =  query.getResultList();
        return result;
    }            
    
    public List<Tag> findRelatedTags() {
        TypedQuery<Tag> query = manager.createQuery("SELECT e FROM TAG e JOIN e.projects f", Tag.class);
        List<Tag> result =  query.getResultList();
        return result;
    }     
    
    
    public List<Category> readCategories() {
        TypedQuery<Category> query = manager.createQuery("SELECT e FROM CATEGORY e", Category.class);
        List<Category> result =  query.getResultList();

    	return result;           
    }    
    
    public List<Tag> readTags() {
        TypedQuery<Tag> query = manager.createQuery("SELECT e FROM TAG e", Tag.class);
        List<Tag> result =  query.getResultList();

    	return result;           
    }  
//
//<<<<<<< HEAD
    /*SELECT * FROM blog_posts WHERE keywords LIKE '%design%' ORDER BY timestamp */
    // method to read all records that contain search term
    public List<Project> searchProjects(String s) {
        System.out.println("S = "+s);
        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e WHERE e.title LIKE :searchTerm", Project.class).setParameter("searchTerm", "%" + s + "%");
        List<Project> result =  query.getResultList();
        //System.out.println(result);
        //TypedQuery<String> q = manager.createQuery("SELECT e FROM PROJECT e WHERE e.title = :searchTerm", String.class).setParameter("searchTerm", s);
    
        
        /*
        createQuery(
    "SELECT c FROM Customer c WHERE c.name LIKE :custName")
    .setParameter("custName", name)
    .setMaxResults(10)
    .getResultList();
}
        */
        
        //System.out.println(q);
    	return result;   	 
    }
    
//

    // method to update a record
    public Project updateProject(Long id, String title, String status, String startDate, String endDate, String outcome, String category, List<String> tags) {
        Project project = manager.find(Project.class, id);
        
    	if (project != null) {
            project.setTitle(title);
            project.setStatus(status);
            project.setStartDate(Date.valueOf(startDate));
            project.setEndDate(Date.valueOf(endDate));
            project.setOutcome(outcome);
            
            Long newID = -1L;
            List<Category> catList = readCategories();
            for (int i = 0; i < catList.size(); i++) {
                if (catList.get(i).getCategory().equals(category)) {
                    newID = catList.get(i).getId();
                    break;
                }
            }
        
            Set<Category> newCategoryList = new TreeSet<Category>();
            Category newCategory = new Category();
            newCategory.setCategory(category);
            newCategory.setId(newID);
            newCategoryList.add(newCategory);
            project.setCategory(newCategoryList);   
            
            Set<Tag> newTagList = new TreeSet<Tag>();
            Long newID2 = -1L;
            List<Tag> tagList = readTags();
            for (int i = 0; i < tagList.size(); i++) {
                for (int j = 0; j < tags.size(); j++) {
                    if (tagList.get(i).getTag().equals(tags.get(j).toString())) {
                        Tag newTag = new Tag();
                        newID2 = tagList.get(i).getId();
                        newTag.setTag(tags.get(j));
                        newTag.setId(newID2);
                        newTagList.add(newTag);  
                        break;
                    }
                }
            }
            project.setTag(newTagList);             
            
            manager.persist(project);
    	}
        
    	return project;
    }

    // method to delete a record
    public void deleteProject(Long id) {
        Project project = manager.find(Project.class, id);
    	if (project != null) {
            manager.remove(project);
    	}
    }
    
    // method to find a record using title
    public boolean findProject(String projectName) {
        TypedQuery<Project> query = manager.createQuery("SELECT e.title FROM PROJECT e", Project.class);
        List<Project> result = query.getResultList();        

        if (result.contains(projectName)) {
            return true;
        }
        
        return false;
    }
    
    // method to find a record using title excluding specified primary key
    public boolean findProject(String projectName, long id) {
        TypedQuery<Project> query = manager.createQuery("SELECT e.title FROM PROJECT e WHERE e.id != :targetID", Project.class);
        query.setParameter("targetID", id);
        List<Project> result = query.getResultList();        

        if (result.contains(projectName)) {
            return true;
        }
        
        return false;
    }
}
