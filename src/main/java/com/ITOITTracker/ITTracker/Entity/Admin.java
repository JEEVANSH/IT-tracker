package com.ITOITTracker.ITTracker.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Admin implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_generator")
	@SequenceGenerator(name = "admin_generator", sequenceName = "admin_seq", initialValue = 5)
	private int id;
	private String name;
	private String email;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assignee", cascade = { CascadeType.ALL })
	@JsonBackReference
	private List<Ticket> ticketlist;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "admin", cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<Comments> commentList;
	public Admin() {
	super();
	}
	public Admin(String name, String email) {
	super();
	this.name = name;
	this.email = email;
	}
	public int getId() {
	return id;
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public List<Ticket> getTicketlist() {
	return ticketlist;
	}
	public void setTicketlist(List<Ticket> ticketlist) {
	this.ticketlist = ticketlist;
	}
	public List<Comments> getCommentList() {
	return commentList;
	}
	public void setCommentList(List<Comments> commentList) {
	this.commentList = commentList;
	}	
}
