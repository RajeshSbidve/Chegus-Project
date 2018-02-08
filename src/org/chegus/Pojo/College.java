package org.chegus.Pojo;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="COLLEGE_DETAILS")
public class College{
	

@Id 
@GeneratedValue(generator = "system-increment") 
@GenericGenerator(name="system-increment",strategy="increment")
@Column(name ="ID",unique= true , nullable=false)
private Integer id;
	  

@Column(name="COLLEGEID")
private String collegeid;


@Column(name="COLLEGENAME")
private String collegename;


@OneToMany(mappedBy = "college")
private List<Student> students;
  
	 

	
public Integer getId() {
		return id;
}
public void setId(Integer id) {
		this.id = id;
}
public String getCollegeid() {
		return collegeid;
}
public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
}
public String getCollegename() {
		return collegename;
}
public void setCollegename(String collegename) {
		this.collegename = collegename;
}
	
public String toString() {
		return "College [id=" + id + ", collegeid=" + collegeid
				+ ", collegename=" + collegename + "]";
	}
	
}