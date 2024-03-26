package com.fdmgroup.SofiaSoloProject.model;

import java.sql.Timestamp;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	
	
	/////// ATTRIBUTES
	
	@Id
	@GeneratedValue
	@Column(name="messageId")
	private int id;
	
	@Column(nullable=false)
	private String message;
	
	@Column(name="messageDate", nullable=false)
	private Timestamp date;

	@ManyToOne
	@JoinColumn(name="bgId", nullable=false)
	private BookGroup bookGroup;	//to find all messages for one group search messages by bg_id
	
	@ManyToOne(cascade= {CascadeType.REMOVE})
	@OnDelete(action = OnDeleteAction.CASCADE )
	@JoinColumn(name="userId")
	private User user;
	
	
	
	/////// DEFAULT CONSTRUCTOR

	public Message() {
		super();
	}
	
	
	/////// FIELD CONSTRUCTOR (no id)

	public Message(String message, Timestamp date) {
		super();
		this.message = message;
		this.date = date;
	}

	public Message(String message, Timestamp date, BookGroup bookGroup, User user) {
		super();
		this.message = message;
		this.date = date;
		this.bookGroup = bookGroup;
		this.user = user;
	}


	/////// TO STRING
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}
	
	
	/////// GETTERS AND SETTERS

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	public BookGroup getBookGroup() {
		return bookGroup;
	}
	public void setBookGroup(BookGroup bookGroup) {
		this.bookGroup = bookGroup;
	}
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
