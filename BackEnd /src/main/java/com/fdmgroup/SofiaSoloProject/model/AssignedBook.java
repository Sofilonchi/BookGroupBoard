package com.fdmgroup.SofiaSoloProject.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssignedBook {
	
	@Id
	@GeneratedValue
	@Column(name="assignmentId", nullable=false)
	int id;
	
	@Column(name="assignedDate", nullable=false)
	Date date;
	
	@ManyToOne
	@JoinColumn(name="bookId", nullable=false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="bookGroupId", nullable=false)
	private BookGroup bookGroup;

		
	
	/////// DEFAULT CONSTRUCTOR
	
	public AssignedBook() {
		super();

	}


	/////// FIELD CONSTRUCTOR (no id)

	public AssignedBook(Date date, Book book, BookGroup bookGroup) {
		super();
		this.date = date;
		this.book = book;
		this.bookGroup = bookGroup;
	}

	


	/////// TO STRING

	@Override
	public String toString() {
		return "AssignedBook [id=" + id + ", date=" + date + ", book=" + book + ", bookGroup=" + bookGroup + "]";
	}

	
	/////// GETTERS AND SETTERS

	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public BookGroup getBookGroup() {
		return bookGroup;
	}


	public void setBookGroup(BookGroup bookGroup) {
		this.bookGroup = bookGroup;
	}
	
	

}
