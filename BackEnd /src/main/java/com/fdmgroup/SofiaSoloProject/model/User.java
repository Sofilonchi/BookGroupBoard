package com.fdmgroup.SofiaSoloProject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
	
	
	/////// ATTRIBUTES
	
	@Id
	@GeneratedValue
	@Column(name="userId")
	private int id;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="locationId", nullable=false) 
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="genreId", nullable=false)
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name="bookGroupId")
	private BookGroup bookGroup;	//to find all members of book group search "user" by bg_id
	
	
	
	/////// DEFAULT CONSTRUCTOR

	public User() {
		super();

	}
	
	
	/////// FIELD CONSTRUCTOR (no id)

	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public User(String username, String password, String name, Location location, Genre genre, BookGroup bookGroup) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.location = location;
		this.genre = genre;
		this.bookGroup = bookGroup;
	}


	/////// TO STRING
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", location="
				+ location + ", genre=" + genre + "]";
	}
	
	
	/////// GETTERS AND SETTERS 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	public BookGroup getBookGroup() {
		return bookGroup;
	}
	public void setBookGroup(BookGroup bookGroup) {
		this.bookGroup = bookGroup;
	}

}
