package com.fdmgroup.SofiaSoloProject.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name="bookId")
	private int id;
	
	@Column(nullable=false)
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Genre> genres;
	
	@ManyToOne
	@JoinColumn(name="authorId", nullable=false)
	private Author author;
	
	
	/////// DEFAULT CONSTRUCTOR
	
	public Book() {
		super();
	}
	
	
	/////// FIELD CONSTRUCTR (no id)

	public Book(String title) {
		super();
		this.title = title;
	}
	
	
	/////// TO STRING

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genres + "]";
	}
	
	
	/////// GETTERS AND SETTERS

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Genre> getGenre() {
		return genres;
	}
	public void setGenre(List<Genre> genres) {
		this.genres = genres;
	}
	
	

}
