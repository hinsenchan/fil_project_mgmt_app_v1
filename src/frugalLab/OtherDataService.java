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
public class OtherDataService {
    private EntityManager manager;
    public String projectID;
    
    public OtherDataService(EntityManager manager, String projectID) {
        this.manager = manager;
        this.projectID = projectID;
    }    
    
        // method to create a new record
    public OtherData createOtherData(String otherDataType, String otherDataValue) {        
        OtherData otherdata = new OtherData();
        otherdata.setOtherDataType(otherDataType);
        otherdata.setOtherDataValue(otherDataValue);
        
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}
        
        otherdata.setPid(longProjectID);

        manager.persist(otherdata);
 	return otherdata;
    }
    
    // method to read a record
    public OtherData readOtherData(Long id) {
        OtherData otherdata = manager.find(OtherData.class, id);
    	return otherdata;   	 
    }

    // method to read all records
    public List<OtherData> readAll() {        

        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}

        TypedQuery<OtherData> query = manager.createQuery("SELECT e FROM OTHER_DATA e WHERE e.pid = :pidValue", OtherData.class);
        query.setParameter("pidValue", longProjectID);
        List<OtherData> result =  query.getResultList();
        
    	return result;   	 
    }
     
    // method to update a record
    public OtherData updateOtherData(String sid, String otherDataType, String otherDataValue) {
        long longOtherDataID = -1;
        
        try {
            longOtherDataID = Long.parseLong(sid);
        }
        catch(NumberFormatException e) {}
        
        OtherData otherdata = manager.find(OtherData.class, longOtherDataID);
        
    	if (otherdata != null) {
            otherdata.setOtherDataType(otherDataType);
            otherdata.setOtherDataValue(otherDataValue);
            manager.persist(otherdata);
    	}
        
    	return otherdata;
    }

    // method to delete a record
    public void deleteOtherData(Long id) {
        OtherData otherdata = manager.find(OtherData.class, id);
    	if (otherdata != null) {
            manager.remove(otherdata);
    	}
    }
    
    /*
    // method to find a record using title
    public boolean findOtherData(String name) {
        long longProjectID = -1;
        
        try {
            longProjectID = Long.parseLong(projectID);
        }        
        catch (NumberFormatException e) {}
        
        TypedQuery<OtherData> query = manager.createQuery("SELECT e FROM OTHER_DATA e WHERE e.pid = :pidValue AND e.name = :nameValue", OtherData.class);
        query.setParameter("pidValue", longProjectID);
        query.setParameter("nameValue", name);
        List<OtherData> result = query.getResultList();        
        
        System.out.println(result);
        
        if (result.size() > 0) {
            return true;
        }
        
        return false;
    }
    */
}
