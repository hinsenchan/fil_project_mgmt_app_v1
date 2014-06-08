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
public class StudentsService {
    private EntityManager manager;
    public String projectID;
    
    public StudentsService(EntityManager manager, String projectID) {
        this.manager = manager;
        this.projectID = projectID;
    }    
    
        // method to create a new record
    public Students createStudents(String name) {        
        Students students = new Students();
        students.setName(name);
        
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}
        
        students.setPid(longProjectID);
        
        /*
        Project project = new Project();
        HashSet<Project> projectSet = new HashSet<Project>();
        
        project.setId((long)2403);
        project.setTitle("test");
        project.setStatus("ACTIVE");
        project.setStartDate(Date.valueOf("2012-01-01"));
        project.setEndDate(Date.valueOf("2012-01-01"));
        project.setOutcome("testoutcome");
        
        projectSet.add(project);
        students.setProjects(projectSet);
        */

        manager.persist(students);
 	return students;
    }
    
    // method to read a record
    public Students readStudents(Long id) {
        Students students = manager.find(Students.class, id);
    	return students;   	 
    }

    // method to read all records
    public List<Students> readAll() {        

        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}

        TypedQuery<Students> query = manager.createQuery("SELECT e FROM STUDENTS e WHERE e.pid = :pidValue", Students.class);
        query.setParameter("pidValue", longProjectID);
        List<Students> result =  query.getResultList();
        
    	return result;   	 
    }
     
    // method to update a record
    public Students updateStudents(Long id, String name) {
        Students students = manager.find(Students.class, id);
        
    	if (students != null) {
            students.setName(name);
            manager.persist(students);
    	}
        
    	return students;
    }

    // method to delete a record
    public void deleteStudents(Long id) {
        Students students = manager.find(Students.class, id);
    	if (students != null) {
            manager.remove(students);
    	}
    }
    
    // method to find a record using title
    public boolean findStudents(String name) {
        TypedQuery<Students> query = manager.createQuery("SELECT e.name FROM STUDENTS e", Students.class);
        List<Students> result = query.getResultList();        

        if (result.contains(name)) {
            return true;
        }
        
        return false;
    }
    
    // method to find a record using title excluding specified primary key
    public boolean findStudents(String name, long id) {
        TypedQuery<Students> query = manager.createQuery("SELECT e.name FROM STUDENTS e WHERE e.id = :targetID", Students.class);
        query.setParameter("targetID", id);
        List<Students> result = query.getResultList();        

        if (result.contains(name)) {
            return true;
        }
        
        return false;
    }
}