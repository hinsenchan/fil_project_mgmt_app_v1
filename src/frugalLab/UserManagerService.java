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
public class UserManagerService {
    private EntityManager manager;
    
    public UserManagerService(EntityManager manager) {
        this.manager = manager;
    }    
    
        // method to create a new record
    public UserManager createUserManager(String userName, String passWord) {
        UserManager userManager = new UserManager();
 	userManager.setUserName(userName);
        userManager.setPassword(passWord);
 	manager.persist(userManager);
 	return userManager;
    }
    
    // method to read a record
    public UserManager readUserManager(Long id) {
        UserManager userManager = manager.find(UserManager.class, id);
    	return userManager;   	 
    }

    // method to read all records
    public List<UserManager> readAll() {
        TypedQuery<UserManager> query = manager.createQuery("SELECT e FROM USER_MANAGER e", UserManager.class);
        List<UserManager> result =  query.getResultList();

    	return result;   	 
    }
     
    // method to update a record
    public UserManager updateUserManager(Long id, String newUserName, String newPassWord, String userid) {
        UserManager userManager = manager.find(UserManager.class, id);
    	if (userManager != null) {
            userManager.setUserName(newUserName);
            userManager.setPassword(newPassWord);
    	}
    	return userManager;
    }

    // method to delete a record
    public void deleteUserManager(Long id) {
        UserManager userManager = manager.find(UserManager.class, id);
    	if (userManager != null) {
            manager.remove(userManager);
    	}
    }
    
    // method to find a record using file type
    public boolean findUserManager(String userName) {
        TypedQuery<UserManager> query = manager.createQuery("SELECT e.userName FROM USER_MANAGER e", UserManager.class);
        List<UserManager> result = query.getResultList();        

        if (result.contains(userName)) {
            return true;
        }
        
        return false;
    }
}