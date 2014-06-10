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
    public Project createProject(String title, String status, String startDate, String endDate, String outcome) {        
        Project project = new Project();
        project.setTitle(title);
        project.setStatus(status);
        project.setStartDate(Date.valueOf(startDate));
        project.setEndDate(Date.valueOf(endDate));
        project.setOutcome(outcome);
 	manager.persist(project);
 	return project;
    }
    
    // method to read a record
    public Project readProject(Long id) {
        Project project = manager.find(Project.class, id);
    	return project;   	 
    }

    // method to read all records
    public List<Project> readAll() {
        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e", Project.class);
        List<Project> result =  query.getResultList();

    	return result;   	 
    }
    /*SELECT * FROM blog_posts WHERE keywords LIKE '%design%' ORDER BY timestamp */
    // method to read all records that contain search term
    public List<Project> searchProjects(String s) {
        System.out.println("S = "+s);
        TypedQuery<Project> query = manager.createQuery("SELECT e FROM PROJECT e WHERE e.title = :searchTerm", Project.class).setParameter("searchTerm", s);
        List<Project> result =  query.getResultList();
        //System.out.println(result);
        TypedQuery<String> q = manager.createQuery("SELECT e FROM PROJECT e WHERE e.title = :searchTerm", String.class).setParameter("searchTerm", s);
    
        /*
        createQuery(
    "SELECT c FROM Customer c WHERE c.name LIKE :custName")
    .setParameter("custName", name)
    .setMaxResults(10)
    .getResultList();
}
        */
        
        System.out.println(q);
    	return result;   	 
    }
    
     
    // method to update a record
    public Project updateProject(Long id, String title, String status, String startDate, String endDate, String outcome) {
        Project project = manager.find(Project.class, id);
        
    	if (project != null) {
            project.setTitle(title);
            project.setStatus(status);
            project.setStartDate(Date.valueOf(startDate));
            project.setEndDate(Date.valueOf(endDate));
            project.setOutcome(outcome);
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