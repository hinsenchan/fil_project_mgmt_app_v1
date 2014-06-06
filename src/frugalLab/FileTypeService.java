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
public class FileTypeService {
    private EntityManager manager;
    
    public FileTypeService(EntityManager manager) {
        this.manager = manager;
    }    
    
        // method to create a new record
    public FileType createFileType(String newFileType) {
        FileType fileType = new FileType();
 	fileType.setFileType(newFileType);
 	manager.persist(fileType);
 	return fileType;
    }
    
    // method to read a record
    public FileType readFileType(Long id) {
        FileType fileType = manager.find(FileType.class, id);
    	return fileType;   	 
    }

    // method to read all records
    public List<FileType> readAll() {
        TypedQuery<FileType> query = manager.createQuery("SELECT e FROM FILE_TYPE e", FileType.class);
        List<FileType> result =  query.getResultList();

    	return result;   	 
    }
     
    // method to update a record
    public FileType updateFileType(Long id, String newFileType) {
        FileType fileType = manager.find(FileType.class, id);
    	if (fileType != null) {
            fileType.setFileType(newFileType);
    	}
    	return fileType;
    }

    // method to delete a record
    public void deleteFileType(Long id) {
        FileType fileType = manager.find(FileType.class, id);
    	if (fileType != null) {
            manager.remove(fileType);
    	}
    }
    
    // method to find a record using file type
    public boolean findFileType(String fileTypeName) {
        TypedQuery<FileType> query = manager.createQuery("SELECT e.fileType FROM FILE_TYPE e", FileType.class);
        List<FileType> result = query.getResultList();        

        if (result.contains(fileTypeName)) {
            return true;
        }
        
        return false;
    }
}