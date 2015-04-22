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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.util.Set;

/**
 *
 * @author Hinsen Chan
 */
@Entity(name = "TAG")
public class Tag implements Serializable, Comparable {
    //primary key id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // column filetype
    @Column(name = "TAG")
    private String tag;
    
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="PROJECT_TAG", 
    joinColumns = @JoinColumn(name="TID"),
    inverseJoinColumns = @JoinColumn(name="PID"))
    private Set<Project> projects; 
    //private Project projects; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
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
            return getTag();
	else
            throw new Exception("Error: invalid column index in TAG table");    
   }
    
   // return the name of column i
   public String getColumnName(int i) throws Exception {
        String colName = null;
        
        if (i == 0) 
            colName = "ID";
	else if (i == 1)
            colName = "TAG";
	else 
            throw new Exception("Access to invalid column number in TAG table");
	   
	return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       if (i == 0) 
            throw new Exception("Error: illegal to alter primary key in TAG table");               
       else if (i == 1) 
            tag = (String) value;
	else
            throw new Exception("Error: invalid column index in TAG table");    
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
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAG [Id = " + id + ", Tag = " + tag + "]";
    }

    /**
     * @return the projects
     */
    public Set<Project> getProjects() {
        return projects;
    }

    /**
     * @param projects the projects to set
     */
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    
    public int compareTo(Object o1) {
        if (getTag().compareTo(((Tag)o1).getTag()) == 0)
            return 0;
        else if (getTag().compareTo(((Tag)o1).getTag()) > 0)
            return 1;
        else
            return -1;
    }
}
