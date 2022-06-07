package com.ITOITTracker.ITTracker.Response;

import com.ITOITTracker.ITTracker.Entity.Ticket;

public class TicketResponse {
	private int ticket_id;
	private String category;
	private String subCategory;
	private String subject;
	private String priority;
	private String status;
	private String assignee;
	private String url;
	
	public TicketResponse(Ticket ticket) {
	super();
	this.ticket_id = ticket.getTicket_id();
	this.category = ticket.getCategory_id();
	this.subCategory = ticket.getSubCategory_id();
	this.subject = ticket.getSubject();
	this.priority = ticket.getPriority_id();
	this.status = ticket.getStatus_id();
	if (ticket.getAssignee() != null)
	this.assignee = ticket.getAssignee().getName();
	this.url = "http://localhost:8080/api/tickets/" + ticket.getTicket_id();
	}
	public TicketResponse() {
	super();
	}
	public int getTicket_id() {
	return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
	this.ticket_id = ticket_id;
	}
	public String getCategory() {
	return category;
	}
	public void setCategory(String category) {
	this.category = category;
	}
	public String getSubCategory() {
	return subCategory;
	}
	public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
	}
	public String getSubject() {
	return subject;
	}
	public void setSubject(String subject) {
	this.subject = subject;
	}
	public String getPriority() {
	return priority;
	}
	public void setPriority(String priority) {
	this.priority = priority;
	}
	public String getStatus() {
	return status;
	}
	public void setStatus(String status) {
	this.status = status;
	}
	public String getAssignee() {
	return assignee;
	}
	public void setAssignee(String assignee) {
	this.assignee = assignee;
	}
	public String getUrl() {
	return url;
	}
	public void setUrl(String url) {
	this.url = url;
	}
}
