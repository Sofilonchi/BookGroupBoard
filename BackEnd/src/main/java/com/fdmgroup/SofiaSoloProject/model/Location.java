package com.fdmgroup.SofiaSoloProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Location {

	
	/////// ATTRIBUTES
	
	@Id
	@GeneratedValue
	@Column(name="location_id")
	private int id;
	
	@Column(name="location_name", nullable=false, unique=true)
	private String name;

	
	/////// DEFAULT CONSTRUCTOR
	
	public Location() {
		super();
	}
	
	
	/////// FIELD CONSTRUCTOR

	public Location(String name) {
		super();
		this.name = name;
	}
	
	
	/////// TO STRING

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + "]";
	}
	
	
	/////// GETTERS AND SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
