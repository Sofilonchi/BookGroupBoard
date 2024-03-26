package com.fdmgroup.SofiaSoloProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	@Column(name="genreId")
	private int id;
	
	@Column(name="genreName", nullable=false, unique=true)
	private String name;
	
	
	
	/////// DEFAULT CONSTRUCTOR
	
	public Genre() {
		super();
	}


	/////// FIELD CONSTRUCTOR (no id)
	
	public Genre(String name) {
		super();
		this.name = name;
	}

	
	/////// TO STRING

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
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
