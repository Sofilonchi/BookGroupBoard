package com.fdmgroup.SofiaSoloProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Author {

	/////// ATTRIBUTES
	
	@Id
	@GeneratedValue
	@Column(name="authorId")
	private int id;
	
	@Column(name="authorFName")
	private String fname;
	
	@Column(name="authorLName")
	private String lname;

	
	
	/////// DEFAULT CONSTRUCTOR
	
	public Author() {
		super();
	}
	
	
	/////// FIELD CONSTRUCTOR

	public Author(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
	public Author(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}


	/////// TO STRING
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
	
	/////// GETTERS AND SETTERS 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	
	
	
}
