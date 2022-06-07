package com.ITOITTracker.ITTracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {
	@Id
	private int status_id;
	private String status_msg;
	
	public Status(int status_id, String status_msg) {
	super();
	this.status_id = status_id;
	this.status_msg = status_msg;
	}
	public Status() {
	super();
	}
	public int getStatus_id() {
	return status_id;
	}
	public void setStatus_id(int status_id) {
	this.status_id = status_id;
	}
	public String getStatus_msg() {
	return status_msg;
	}
	public void setStatus_msg(String status_msg) {
	this.status_msg = status_msg;
	}
}
