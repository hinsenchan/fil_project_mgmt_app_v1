/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author Hinsen Chan
 */
public class TagService {
    private EntityManager manager;
    
    public TagService(EntityManager manager) {
        this.manager = manager;
    }    
    
        // method to create a new record
    public Tag createTag(String newTag) {
        Tag tag = new Tag();
 	tag.setTag(newTag);
 	manager.persist(tag);
 	return tag;
    }
    
    // method to read a record
    public Tag readTag(Long id) {
        Tag tag = manager.find(Tag.class, id);
    	return tag;   	 
    }

    // method to read all records
    public List<Tag> readAll() {
        TypedQuery<Tag> query = manager.createQuery("SELECT e FROM TAG e", Tag.class);
        List<Tag> result =  query.getResultList();

    	return result;   	 
    }
     
    // method to update a record
    public Tag updateTag(Long id, String newTag) {
        Tag tag = manager.find(Tag.class, id);        
    	if (tag != null) {
            tag.setTag(newTag);
            manager.persist(tag);
    	}
    	return tag;
    }

    // method to delete a record
    public void deleteTag(Long id) {
        Tag tag = manager.find(Tag.class, id);
    	if (tag != null) {
            manager.remove(tag);
    	}
    }
    
    // method to find a record using file type
    public boolean findTag(String tagName) {
        TypedQuery<Tag> query = manager.createQuery("SELECT e.tag FROM TAG e", Tag.class);
        List<Tag> result = query.getResultList();        

        if (result.contains(tagName)) {
            return true;
        }
        
        return false;
    }
}