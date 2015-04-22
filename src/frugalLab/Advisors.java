/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frugalLab;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.sql.*;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Hinsen Chan
 */
@Entity(name = "ADVISORS")
public class Advisors implements Serializable {
    //primary key id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // column name
    @Column(name = "NAME")
    private String name;    

    // column project id
    @Column(name = "PID")
    private Long pid;    
    
    @ManyToOne
    @JoinColumn(name="pid", insertable = false, updatable = false)
    private Project project; 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }    
    
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    // return number of columns in the table
    public int getNumberOfColumns() {
        return 2;
    }
    
    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0)
            return getId().toString();
	else if (i == 1)
            return getName();      
	else
            throw new Exception("Error: invalid column index in ADVISORS table");    
   }
    
   // return the name of column i
   public String getColumnName(int i) throws Exception {
        String colName = null;
        
        if (i == 0) 
            colName = "ID";
	else if (i == 1)
            colName = "NAME";
	else 
            throw new Exception("Access to invalid column number in ADVISORS table");
	   
	return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       if (i == 0) 
            throw new Exception("Error: illegal to alter primary key in ADVISORS table");               
       else if (i == 1) 
            name = (String) value;
       else
            throw new Exception("Error: invalid column index in ADVISORS table");    
   }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advisors)) {
            return false;
        }
        Advisors other = (Advisors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ADVISORS [Id = " + id + ", Name = " + name + ", Pid = " + pid + "]";
    }    
}
