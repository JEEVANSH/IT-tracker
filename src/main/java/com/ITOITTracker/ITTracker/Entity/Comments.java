package com.ITOITTracker.ITTracker.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_genrator")
	private int comment_id;
	private String comment_msg;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ticket_id")
	@JsonIgnore
	private Ticket ticket;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "id")
	@JsonIgnore
	private Admin admin;
	public Comments(String comment_msg) {
	super();
	this.comment_msg = comment_msg;
	}
	public Comments() {
	super();
	}
	public String getComment_msg() {
	return comment_msg;
	}
	public void setComment_msg(String comment_msg) {
	this.comment_msg = comment_msg;
	}
	public int getComment_id() {
	return comment_id;
	}
	public void setComment_id(int comment_id) {
	this.comment_id = comment_id;
	}
	public Ticket getTicket() {
	return ticket;
	}
	public void setTicket(Ticket ticket) {
	this.ticket = ticket;
	}
	public User getUser() {
	return user;
	}
	public void setUser(User user) {
	this.user = user;
	}
	public Admin getAdmin() {
	return admin;
	}
	public void setAdmin(Admin admin) {
	this.admin = admin;
	}
}
