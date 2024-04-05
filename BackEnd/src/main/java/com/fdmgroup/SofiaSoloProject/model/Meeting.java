package com.fdmgroup.SofiaSoloProject.model;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Meeting {
	
	@Id
	@GeneratedValue
	@Column(name="meetingId")
	private int id;
	
	@Column(name="meetingDate", nullable=false)
	private Timestamp date;
	
	@ManyToOne
	@JoinColumn(name="bookGroupId", nullable=false)
	private BookGroup bookGroup;	//see all meetings of one group by bg_id

	
	/////// DEFAULT CONSTRUCTOR

	public Meeting() {
		super();
	}


	/////// FILED CONSTRUCTOR (no id)
	
	public Meeting(Timestamp date) {
		super();
		this.date = date;
	}	

	public Meeting(Timestamp date, BookGroup bookgroup) {
		super();
		this.date = date;
		this.bookGroup = bookGroup;
	}

	/////// TO STRING
	
	@Override
	public String toString() {
		return "Meeting [id=" + id + ", date=" + date + "]";
	}	
	
	
	/////// GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
