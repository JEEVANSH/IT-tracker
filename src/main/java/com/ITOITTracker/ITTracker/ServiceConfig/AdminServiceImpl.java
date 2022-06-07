package com.ITOITTracker.ITTracker.ServiceConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.Entity.Admin;
import com.ITOITTracker.ITTracker.JPARepository.AdminRepository;
import com.ITOITTracker.ITTracker.Services.AdminServices;

@Service
public class AdminServiceImpl implements AdminServices {
	@Autowired
	private AdminRepository AdminRepository;
	@Override
	public List<Admin> adminList() {
	List<Admin> list = new ArrayList<Admin>();
	list = AdminRepository.findAll();
	return list;
	}
	@Override
	public Admin createAdmin(Admin admin) {
	return  AdminRepository.save(admin);
	}
	@Override
	public Admin getAdmin(int id) {
	Admin admin = null;
	try {
	if (AdminRepository.findById(id).isPresent())
	admin = AdminRepository.findById(id).get();
	} catch (Exception e) {
	e.printStackTrace();
	}
	return admin;
	}
	@Override
	public List<Admin> getAdmin(String value) {
	List<Admin> adminlist = new ArrayList<>();
	adminlist = AdminRepository.findAll().stream().filter(a -> a.getName().contains(value) || a.getEmail().contains(value)
	|| (a.getId() + " ").contains(value)).collect(Collectors.toList());
	return adminlist;
	}
	@Override
	public String updateAdmin(int id, Admin admin) {
	Admin newAdmin = null;
	try {
	newAdmin = AdminRepository.findById(id).get();
	if (newAdmin == null)
	return "Admin Not Found";
	if (admin.getName().length() != 0 && admin.getEmail().length() != 0){
	newAdmin.setName(admin.getName());
	newAdmin.setEmail(admin.getEmail());
	} else if (admin.getName() != null && admin.getName().length() != 0)
	newAdmin.setName(admin.getName());
	else if (admin.getEmail() != null && admin.getEmail().length() != 0)
	newAdmin.setEmail(admin.getEmail());
	AdminRepository.save(newAdmin);
	} catch (Exception e) {
	e.printStackTrace();
	}
	return "Admin updated successfully";
	}
	@Override
	public boolean deleteAdmin(int id) {
	boolean found = true;
	if (getAdmin(id) != null){
	AdminRepository.deleteById(id);
	found = false;
	}
	return found;
	}
}

