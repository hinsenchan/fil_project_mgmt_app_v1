/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import javax.persistence.*;
import java.util.*;

/**
 *
 * @author fattymcphatfat
 */
public class FrugalModel {
    private static final String PERSISTENCE_UNIT_NAME = "coen275projectPU";
    private static EntityManagerFactory factory;
    //private EntityManager manager;
    
    /*
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM FILE_TYPE e");
        List<FileType> result = query.getResultList();
        System.out.println(result);
        factory.close();                
    }
    */
    
    public List<FileType> getFileTypeEntity() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM FILE_TYPE e");
        List<FileType> result = query.getResultList();
        factory.close();        
        return result;
    }
}
