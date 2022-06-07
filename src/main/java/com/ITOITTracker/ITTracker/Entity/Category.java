package com.ITOITTracker.ITTracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	private int category_id;
	private String category_msg;
	public Category() {
	super();
	}
	public Category(int category_id, String category_msg) {
	super();
	this.category_id = category_id;
	this.category_msg = category_msg;
	}
	public int getCategory_id() {
	return category_id;
	}
	public void setCategory_id(int category_id) {
	this.category_id = category_id;
	}
	public String getCategory_msg() {
	return category_msg;
	}
	public void setCategory_msg(String category_msg) {
	this.category_msg = category_msg;
	}
}
