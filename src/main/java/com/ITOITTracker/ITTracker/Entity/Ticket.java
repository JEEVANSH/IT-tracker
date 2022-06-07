package com.ITOITTracker.ITTracker.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
public class Ticket implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_genrator")	
	@SequenceGenerator(name = "ticket_genrator", sequenceName = "ticket_seq")
	private int ticket_id;
	private int category_id;
	private int subCategory_id;
	private int report_id;
	private String subject;
	private String description;
	private String status_id;
	private int priority_id;
	private String create_datetime;
	private String last_modified_datetime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignee_id", referencedColumnName = "id")
	private Admin assignee;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonIgnore
	private User user;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "ticket")
	private List<Comments> commentList;
	public Ticket(int category_id, int subCategory_id,String subject,String description, int priority_id) {
		super();
		this.category_id = category_id;
		this.subCategory_id = subCategory_id;
		this.subject = subject;
		this.description = description;
		this.priority_id = priority_id;
	}
	public Ticket() {
	super();
	}
	public int getCategory_id() {
	return category_id;
	}
	public void setCategory_id(int category_id) {
	this.category_id = category_id;
	}
	public int getSubCategory_id() {
	return subCategory_id;
	}
	public void setSubCategory_id(int subCategory_id) {
	this.subCategory_id = subCategory_id;
	}
	public int getReport_id() {
	return report_id;
	}
	public void setReport_id(int report_id) {
	this.report_id = report_id;
	}
	public String getSubject() {
	return subject;
	}
	public void setSubject(String subject) {
	this.subject = subject;
	}
	public String getDescription() {
	return description;
	}
	public void setDescription(String description) {
	this.description = description;
	}
	public String getStatus_id() {
	return status_id;
	}
	public void setStatus_id(String status_id) {
	this.status_id = status_id;
	}
	public int getPriority_id() {
	return priority_id;
	}
	public void setPriority_id(int priority_id) {
	this.priority_id = priority_id;
	}
	public String getCreate_datetime() {
	return create_datetime;
	}
	public void setCreate_datetime(String create_datetime) {
	this.create_datetime = create_datetime;
	}
	public String getLast_modified_datetime() {
	return last_modified_datetime;
	}
	public void setLast_modified_datetime(String last_modified_datetime) {
	this.last_modified_datetime = last_modified_datetime;
	}
	public Admin getAssignee() {
	return assignee;
	}
	public void setAssignee(Admin assignee) {
	this.assignee = assignee;
	}
	public User getUser() {
	return user;
	}
	public void setUser(User user) {
	this.user = user;
	}
	public List<Comments> getCommentList() {
	return commentList;
	}
	public void setCommentList(List<Comments> commentList) {
	this.commentList = commentList;
	}
	public int getTicket_id() {
	return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
	this.ticket_id = ticket_id;
	}
}
