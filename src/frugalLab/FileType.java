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

/**
 *
 * @author Hinsen Chan
 */
@Entity(name = "FILE_TYPE")
public class FileType implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "FILETYPE")
    private String fileType;

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
    
    // return number of columns in the table
    public int getNumberOfColumns() {
        return 2;
    }
    
    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0)
            return getId().toString();
	else if (i == 1)
            return getFileType();
	else
            throw new Exception("Error: invalid column index in FILE_TYPE table");    
   }
    
   // return the name of column i
   public String getColumnName(int i) throws Exception {
        String colName = null;
        
        if (i == 0) 
            colName = "ID";
	else if (i == 1)
            colName = "FILETYPE";
	else 
            throw new Exception("Access to invalid column number in FILE_TYPE table");
	   
	return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       if (i == 0) 
            throw new Exception("Error: illegal to alter primary key in FILE_TYPE table");               
       else if (i == 1) 
            fileType = (String) value;
	else
            throw new Exception("Error: invalid column index in FILE_TYPE table");    
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
        if (!(object instanceof FileType)) {
            return false;
        }
        FileType other = (FileType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FILE_TYPE [Id = " + id + ", FileType = " + fileType + "]";
    }
    
}
