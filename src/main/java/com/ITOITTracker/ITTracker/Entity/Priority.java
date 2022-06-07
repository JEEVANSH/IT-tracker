package com.ITOITTracker.ITTracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Priority {
	@Id
	private int priority_id;
	private String priority_msg;
	public Priority(int priority_id, String priority_msg) {
	super();
	this.priority_id = priority_id;
	this.priority_msg = priority_msg;
	}
	public Priority() {
	super();
	}
	public int getPriority_id() {
	return priority_id;
	}
	public void setPriority_id(int priority_id) {
	this.priority_id = priority_id;
	}
	public String getPriority_msg() {
	return priority_msg;
	}
	public void setPriority_msg(String priority_msg) {
	this.priority_msg = priority_msg;
	}
}
