package org.chegus.Pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="STUDENT_ENROLMENT")
public class Student {


@Id
@GeneratedValue(generator="system-increment")
@GenericGenerator(name="system-increment",strategy="increment")
@Column(name = "ID", unique = true, nullable = false)
private Integer id;
	@Column(name="REGNUM")
private String regnum;
	
	
	@NotEmpty()
	@Column(name="FIRSTNAME")
private String firstname;
	
	@Column(name="MIDDLENAME")
private String middlename;
	@Column(name="LASTNAME")
private String lastname;
	
	
	@NotEmpty
	@Column(name="FATHERNAME")
private String fathername;
	@Column(name="FATHEROCCUPATION")
private String fatherocc;
	
	
	@NotEmpty
	@Column(name="MOTHERNAME")
private String mothername;
	@Column(name="DOB") @DateTimeFormat(pattern = "dd/MM/yyyy") 
private Date dob;
	@Column(name="AGE")
private String age;
	@Column(name="GENDER")
private String gender;
	
	
	@NotEmpty
	@Column(name="BRANCH")
private String branch;
	@Column(name="YEAR")
private int year;
	
	
	@NotEmpty
	@Column(name="EMAIL")
private String email;
	
	
	@NotNull
	@Column(name="PHONE")
private String phone;
	@Column(name="ADDRESS")
private String address;
	@Column(name="COLLEGEID")
private String collegeid;
	@Column(name="COLLEGENAME")
private String collegename;

	
	

@ManyToOne()
@JoinColumn(name="COLLEGE_ID")

private College college;

public College getCollege() {
	return college;
}
public void setCollege(College college) {
	this.college = college;
}



public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getRegnum() {
	return regnum;
}
public void setRegnum(String regnum) {
	this.regnum = regnum;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getMiddlename() {
	return middlename;
}
public void setMiddlename(String middlename) {
	this.middlename = middlename;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
public String getFatherocc() {
	return fatherocc;
}
public void setFatherocc(String fatherocc) {
	this.fatherocc = fatherocc;
}
public String getMothername() {
	return mothername;
}
public void setMothername(String mothername) {
	this.mothername = mothername;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
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

@Override
public String toString() {
	return "Student [id=" + id + ", regnum=" + regnum + ", firstname="
			+ firstname + ", middlename=" + middlename + ", lastname="
			+ lastname + ", fathername=" + fathername + ", fatherocc="
			+ fatherocc + ", mothername=" + mothername + ", dob=" + dob
			+ ", age=" + age + ", gender=" + gender + ", branch=" + branch
			+ ", year=" + year + ", email=" + email + ", phone=" + phone
			+ ", address=" + address + ", collegeid=" + collegeid
			+ ", collegename=" + collegename + ", college=" + college + "]";
}
}
