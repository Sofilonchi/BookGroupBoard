package com.fdmgroup.SofiaSoloProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class BookGroup {
	
	@Id
	@GeneratedValue
	@Column(name="bookGroupId")
	private int id;

	@Column(nullable=false)
	private int noOfMembers;		//no. of users with this bg_id
	
	@ManyToOne
	@JoinColumn(name="locationId", nullable=false)
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="genreId", nullable=false) 
	private Genre genre;
	
	
	/////// DEFAULT CONSTRUCTOR
	
	public BookGroup() {
		super();
	}

	
	/////// FIELD CONSTRUCTOR (no id)

	public BookGroup(int noOfMembers) {
		super();
		this.noOfMembers = noOfMembers;
	}
	
	public BookGroup(int id, int noOfMembers) {
		super();
		this.id = id;
		this.noOfMembers = noOfMembers;
	}


	/////// TO STRING
	
	@Override
	public String toString() {
		return "BookGroup [id=" + id + ", genre=" + genre + ", location=" + location + ", noOfMembers=" + noOfMembers
				+ "]";
	}
	
	
	/////// GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoOfMembers() {
		return noOfMembers;
	}
	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	

}
