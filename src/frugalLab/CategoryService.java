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
public class CategoryService {
    private EntityManager manager;
    
    public CategoryService(EntityManager manager) {
        this.manager = manager;
    }    
    
        // method to create a new record
    public Category createCategory(String newCategory) {
        Category category = new Category();
 	category.setCategory(newCategory);
 	manager.persist(category);
 	return category;
    }
    
    // method to read a record
    public Category readCategory(Long id) {
        Category category = manager.find(Category.class, id);
    	return category;   	 
    }

    // method to read all records
    public List<Category> readAll() {
        TypedQuery<Category> query = manager.createQuery("SELECT e FROM CATEGORY e", Category.class);
        List<Category> result =  query.getResultList();

    	return result;   	 
    }
     
    // method to update a record
    public Category updateCategory(Long id, String newCategory) {
        System.out.println(id);
        System.out.println(newCategory);
        Category category = manager.find(Category.class, id);        
        System.out.println(category);
    	if (category != null) {
            category.setCategory(newCategory);
            manager.persist(category);
    	}
    	return category;
    }

    // method to delete a record
    public void deleteCategory(Long id) {
        Category category = manager.find(Category.class, id);
    	if (category != null) {
            manager.remove(category);
    	}
    }
    
    // method to find a record using file type
    public boolean findCategory(String categoryName) {
        TypedQuery<Category> query = manager.createQuery("SELECT e.category FROM CATEGORY e", Category.class);
        List<Category> result = query.getResultList();        

        if (result.contains(categoryName)) {
            return true;
        }
        
        return false;
    }
}