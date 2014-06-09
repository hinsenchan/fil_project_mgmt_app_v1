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
@Entity(name = "MEDIA")
public class Media implements Serializable {
    //primary key id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // column name
    @Column(name = "FILETYPE")
    private String fileType;    
    
    // column name
    @Column(name = "FILENAME")
    private String fileName;    
    
    // column name
    @Column(name = "FILELOCATION")
    private String fileLocation;    

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
    
    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }    
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
        
    public String getFileLocation() {
        return fileLocation;
    }
    
    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation; 
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
        return 4;
    }
    
    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0)
            return getId().toString();
	else if (i == 1)
            return getFileType();      
	else if (i == 2)
            return getFileName();      
	else if (i == 3)
            return getFileLocation();              
	else
            throw new Exception("Error: invalid column index in MEDIA table");    
   }
    
   // return the name of column i
   public String getColumnName(int i) throws Exception {
        String colName = null;
        
        if (i == 0) 
            colName = "ID";
	else if (i == 1)
            colName = "FILETYPE";
	else if (i == 2)
            colName = "FILENAME";
	else if (i == 3)
            colName = "FILELOCATION";        
	else 
            throw new Exception("Access to invalid column number in MEDIA table");
	   
	return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       if (i == 0) 
            throw new Exception("Error: illegal to alter primary key in MEDIA table");               
       else if (i == 1) 
            fileType = (String) value;
       else if (i == 2) 
            fileName = (String) value;
       else if (i == 3) 
            fileLocation = (String) value;       
       else
            throw new Exception("Error: invalid column index in MEDIA table");    
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
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MEDIA [Id = " + id + ", File Type = " + fileType + ", File Name = " + fileName + ", File Location = " + fileLocation + ", Pid = " + pid + "]";
    }    
}
