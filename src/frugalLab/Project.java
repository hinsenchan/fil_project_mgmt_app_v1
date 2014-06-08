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
import javax.persistence.*;
import java.sql.*;
import java.util.Set;

/**
 *
 * @author Hinsen Chan
 */
@Entity(name = "PROJECT")
public class Project implements Serializable {
    //primary key id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // column title
    @Column(name = "TITLE")
    private String title;
    
    // column status
    @Column(name = "STATUS")
    private String status;
    
    // column start date
    @Column(name = "START_DATE")
    private Date startDate;

    // column end date
    @Column(name = "END_DATE")
    private Date endDate;
    
    // column start date
    @Column(name = "OUTCOME")
    private String outcome;
    
    /*
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="PROJECT_STUDENTS", 
    joinColumns = @JoinColumn(name="PID"),
    inverseJoinColumns = @JoinColumn(name="SID"))
    */
    /*
    @ManyToMany(cascade=CascadeType.PERSIST, mappedBy="projects")
    private Set<Students> students;
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Students> students;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
    
    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
    
    // return number of columns in the table
    public int getNumberOfColumns() {
        return 6;
    }
    
    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0)
            return getId().toString();
	else if (i == 1)
            return getTitle();      
        else if (i == 2)
            return getStatus();
        else if (i == 3)
            return getStartDate().toString();        
        else if (i == 4)
            return getEndDate().toString();        
        else if (i == 5)
            return getOutcome();        
	else
            throw new Exception("Error: invalid column index in PROJECT table");    
   }
    
   // return the name of column i
   public String getColumnName(int i) throws Exception {
        String colName = null;
        
        if (i == 0) 
            colName = "ID";
	else if (i == 1)
            colName = "TITLE";
	else if (i == 2)
            colName = "STATUS";
	else if (i == 3)
            colName = "START_DATE";
	else if (i == 4)
            colName = "END_DATE";
	else if (i == 5)
            colName = "OUTCOME";
	else 
            throw new Exception("Access to invalid column number in PROJECT table");
	   
	return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       if (i == 0) 
            throw new Exception("Error: illegal to alter primary key in PROJECT table");               
       else if (i == 1) 
            title = (String) value;
       else if (i == 2) 
            status = (String) value;       
       else if (i == 3) 
            startDate = (Date) value;       
       else if (i == 4) 
            endDate = (Date) value;       
       else if (i == 5) 
            outcome = (String) value;       
       else
            throw new Exception("Error: invalid column index in PROJECT table");    
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PROJECT [Id = " + id + ", Title = " + title + 
                ", Status = " + status + ", Start Date = " + startDate + 
                ", End Date = " + endDate + ", Outcome = " + outcome + "]";
    }    
}
