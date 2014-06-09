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
public class AdvisorsService {
    private EntityManager manager;
    public String projectID;
    
    public AdvisorsService(EntityManager manager, String projectID) {
        this.manager = manager;
        this.projectID = projectID;
    }    
    
        // method to create a new record
    public Advisors createAdvisors(String name) {        
        Advisors advisors = new Advisors();
        advisors.setName(name);
        
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}
        
        advisors.setPid(longProjectID);

        manager.persist(advisors);
 	return advisors;
    }
    
    // method to read a record
    public Advisors readAdvisors(Long id) {
        Advisors advisors = manager.find(Advisors.class, id);
    	return advisors;   	 
    }

    // method to read all records
    public List<Advisors> readAll() {        

        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}

        TypedQuery<Advisors> query = manager.createQuery("SELECT e FROM ADVISORS e WHERE e.pid = :pidValue", Advisors.class);
        query.setParameter("pidValue", longProjectID);
        List<Advisors> result =  query.getResultList();
        
    	return result;   	 
    }
     
    // method to update a record
    public Advisors updateAdvisors(String sid, String name) {
        long longAdvisorID = -1;
        
        try {
            longAdvisorID = Long.parseLong(sid);
        }
        catch(NumberFormatException e) {}
        
        Advisors advisors = manager.find(Advisors.class, longAdvisorID);
        
    	if (advisors != null) {
            advisors.setName(name);
            manager.persist(advisors);
    	}
        
    	return advisors;
    }

    // method to delete a record
    public void deleteAdvisors(Long id) {
        Advisors advisors = manager.find(Advisors.class, id);
    	if (advisors != null) {
            manager.remove(advisors);
    	}
    }
    
    // method to find a record using title
    public boolean findAdvisors(String name) {
        long longProjectID = -1;
        
        try {
            longProjectID = Long.parseLong(projectID);
        }        
        catch (NumberFormatException e) {}
        
        TypedQuery<Advisors> query = manager.createQuery("SELECT e FROM ADVISORS e WHERE e.pid = :pidValue AND e.name = :nameValue", Advisors.class);
        query.setParameter("pidValue", longProjectID);
        query.setParameter("nameValue", name);
        List<Advisors> result = query.getResultList();        
        
        System.out.println(result);
        
        if (result.size() > 0) {
            return true;
        }
        
        return false;
    }
}
