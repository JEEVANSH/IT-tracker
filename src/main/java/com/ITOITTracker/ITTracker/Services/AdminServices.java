package com.ITOITTracker.ITTracker.Services;

import java.util.List;

import com.ITOITTracker.ITTracker.Entity.Admin;

public interface AdminServices {
	public List<Admin> adminList();
	public	Admin createAdmin(Admin admin);
	public Admin getAdmin(int id);
	public String updateAdmin(int id, Admin admin);
	public boolean deleteAdmin(int id);
	public List<Admin> getAdmin(String value);
}
