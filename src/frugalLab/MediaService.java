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
public class MediaService {
    private EntityManager manager;
    public String projectID;
    
    public MediaService(EntityManager manager, String projectID) {
        this.manager = manager;
        this.projectID = projectID;
    }    
    
        // method to create a new record
    public Media createMedia(String fileType, String fileName, String fileLocation) {        
        Media media = new Media();
        media.setFileType(fileType);
        media.setFileName(fileName);
        media.setFileLocation(fileLocation);
        
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}
        
        media.setPid(longProjectID);

        manager.persist(media);
 	return media;
    }
    
    // method to read a record
    public Media readMedia(Long id) {
        Media media = manager.find(Media.class, id);
    	return media;   	 
    }
    public List<Media> read()
    {
        TypedQuery<Media> query = manager.createQuery("SELECT e FROM MEDIA e", Media.class);
        List<Media> result =  query.getResultList();
        
    	return result;     
    }
    // method to read all records
    public List<Media> readAll() {        
        long longProjectID = -1;
        try {
            longProjectID = Long.parseLong(projectID);
        }
        catch (NumberFormatException e) {}

        TypedQuery<Media> query = manager.createQuery("SELECT e FROM MEDIA e WHERE e.pid = :pidValue", Media.class);
        query.setParameter("pidValue", longProjectID);
        List<Media> result =  query.getResultList();
        //System.out.println(result);
    	return result;   	 
    }
    
    public List<FileType> readFileTypes() {
        TypedQuery<FileType> query = manager.createQuery("SELECT e FROM FILE_TYPE e", FileType.class);
        List<FileType> result =  query.getResultList();

    	return result;           
    }
     
    // method to update a record
    public Media updateMedia(String id, String fileType, String fileName, String fileLocation) {
        long longMediaID = -1;
        
        try {
            longMediaID = Long.parseLong(id);
        }
        catch(NumberFormatException e) {}
        
        Media media = manager.find(Media.class, longMediaID);
        
    	if (media != null) {
            media.setFileType(fileType);
            media.setFileName(fileName);
            media.setFileLocation(fileLocation);
            manager.persist(media);
    	}
        
    	return media;
    }

    // method to delete a record
    public void deleteMedia(Long id) {
        Media media = manager.find(Media.class, id);
    	if (media != null) {
            manager.remove(media);
    	}
    }
    
    // method to find a record using location
    public boolean findMedia(String locationValue) {
        long longProjectID = -1;
        
        try {
            longProjectID = Long.parseLong(projectID);
        }        
        catch (NumberFormatException e) {}
        
        TypedQuery<Media> query = manager.createQuery("SELECT e FROM MEDIA e WHERE e.pid = :pidValue AND e.fileLocation = :locationValue", Media.class);
        query.setParameter("pidValue", longProjectID);
        query.setParameter("locationValue", locationValue);
        List<Media> result = query.getResultList();        
        
        System.out.println(result);
        
        if (result.size() > 0) {
            return true;
        }
        
        return false;
    }
}
