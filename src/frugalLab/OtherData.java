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
@Entity(name = "OTHER_DATA")
public class OtherData implements Serializable {
    //primary key id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // column name
    @Column(name = "OTHERDATATYPE")
    private String otherDataType;    
    
    // column name
    @Column(name = "OTHERDATAVALUE")
    private String otherDataValue;        

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
    
    public String getOtherDataType() {
        return otherDataType;
    }
    
    public void setOtherDataType(String otherDataType) {
        this.otherDataType = otherDataType;
    }    
    
    public String getOtherDataValue() {
        return otherDataValue;
    }
    
    public void setOtherDataValue(String otherDataValue) {
        this.otherDataValue = otherDataValue;
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
        return 3;
    }
    
    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0)
            return getId().toString();
	else if (i == 1)
            return getOtherDataType();      
	else if (i == 2)
            return getOtherDataValue();              
	else
            throw new Exception("Error: invalid column index in OTHER_DATA table");    
   }
    
   // return the name of column i
   public String getColumnName(int i) throws Exception {
        String colName = null;
        
        if (i == 0) 
            colName = "ID";
	else if (i == 1)
            colName = "OTHERDATATYPE";
	else if (i == 2)
            colName = "OTHERDATAVALUE";        
	else 
            throw new Exception("Access to invalid column number in OTHER_DATA table");
	   
	return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       if (i == 0) 
            throw new Exception("Error: illegal to alter primary key in OTHER_DATA table");               
       else if (i == 1) 
            otherDataType = (String) value;
       else if (i == 2) 
            otherDataValue = (String) value;       
       else
            throw new Exception("Error: invalid column index in OTHER_DATA table");    
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
        if (!(object instanceof OtherData)) {
            return false;
        }
        OtherData other = (OtherData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OTHERDATA [Id = " + id + ", OtherDataType = " + otherDataType +
                ", OtherDataValue = " + otherDataValue + ", Pid = " + pid + "]";
    }    
}
