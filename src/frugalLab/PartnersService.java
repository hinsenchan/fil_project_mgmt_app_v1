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
public class PartnersService {
    private EntityManager manager;
    public String projectID;
    
    public PartnersService(EntityManager manager, String projectID) {
        this.manager = manager;
        this.projectID = projectID;
    }    
    
        // method to create a new record
    public Partners createPartners(String name) {        
        Partners partners = new Partners();
        partners.setName(name);
        
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}
        
        partners.setPid(longProjectID);

        manager.persist(partners);
 	return partners;
    }
    
    // method to read a record
    public Partners readPartners(Long id) {
        Partners partners = manager.find(Partners.class, id);
    	return partners;   	 
    }
    public List<Partners> read()
    {
        TypedQuery<Partners> query = manager.createQuery("SELECT e FROM PARTNERS e", Partners.class);
        List<Partners> result =  query.getResultList();
        
    	return result;     
    }
    // method to read all records
    public List<Partners> readAll() {        

        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}

        TypedQuery<Partners> query = manager.createQuery("SELECT e FROM PARTNERS e WHERE e.pid = :pidValue", Partners.class);
        query.setParameter("pidValue", longProjectID);
        List<Partners> result =  query.getResultList();
        
    	return result;   	 
    }
     
    // method to update a record
    public Partners updatePartners(String sid, String name) {
        long longAdvisorID = -1;
        
        try {
            longAdvisorID = Long.parseLong(sid);
        }
        catch(NumberFormatException e) {}
        
        Partners partners = manager.find(Partners.class, longAdvisorID);
        
    	if (partners != null) {
            partners.setName(name);
            manager.persist(partners);
    	}
        
    	return partners;
    }

    // method to delete a record
    public void deletePartners(Long id) {
        Partners partners = manager.find(Partners.class, id);
    	if (partners != null) {
            manager.remove(partners);
    	}
    }
    
    // method to find a record using title
    public boolean findPartners(String name) {
        long longProjectID = -1;
        
        try {
            longProjectID = Long.parseLong(projectID);
        }        
        catch (NumberFormatException e) {}
        
        TypedQuery<Partners> query = manager.createQuery("SELECT e FROM PARTNERS e WHERE e.pid = :pidValue AND e.name = :nameValue", Partners.class);
        query.setParameter("pidValue", longProjectID);
        query.setParameter("nameValue", name);
        List<Partners> result = query.getResultList();        
        
        System.out.println(result);
        
        if (result.size() > 0) {
            return true;
        }
        
        return false;
    }
}
