package com.ITOITTracker.ITTracker.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Sub_Category")
public class Sub_Category{
	@Id
	private int sub_category_id;
	private String sub_category_msg;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "category_id", nullable = false, referencedColumnName = "category_id")
	private Category category;
	public Sub_Category(int subCategory_id, String subCategory_msg, Category category) {
	super();
	this.sub_category_id = subCategory_id;
	this.sub_category_msg = subCategory_msg;
	this.category = category;
	}
	public Sub_Category() {
	super();
	}
	public int getSubCategory_id() {
	return sub_category_id;
	}
	public void setSubCategory_id(int subCategory_id) {
	this.sub_category_id = subCategory_id;
	}
	public String getSubCategory_msg() {
	return sub_category_msg;
	}
	public void setSubCategory_msg(String subCategory_msg) {
	this.sub_category_msg = subCategory_msg;
	}
	public Category getCategory() {
	return category;
	}
	public void setCategory(Category category) {
	this.category = category;
	}	
}
