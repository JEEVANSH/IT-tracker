package com.ITOITTracker.ITTracker.ServiceConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITOITTracker.ITTracker.Entity.User;
import com.ITOITTracker.ITTracker.JPARepository.UsersRepository;
import com.ITOITTracker.ITTracker.Services.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UsersRepository usersRepository;
	@Override
	public List<User> userList() {
	List<User> list = new ArrayList<User>();
	list = usersRepository.findAll();
	return list;
	}
	@Override
	public User createUser(User user) {
	return usersRepository.save(user);	
	}
	@Override
	public User getUser(int id) {
	User user = null;
	try {
	if (usersRepository.findById(id).isPresent())
	user = usersRepository.findById(id).get();
	} catch (Exception e) {
	e.printStackTrace();
	}
	return user;
	}
	@Override
	public List<User> getUser(String value) {
	List<User> userList =null;
	userList = usersRepository.findAll().stream().filter(u -> u.getName().contains(value)|| u.getEmail().contains(value)
	|| (u.getUser_id() + "").contains(value)).collect(Collectors.toList());
	return userList;		
	}
	@Override
	public String updateUser(int id, User user) {
	User newUser = null;
	try {
	newUser = getUser(id);
	if (newUser == null)
	return "User Not Found";
	if (user.getName().length() != 0&& user.getEmail().length() != 0) {
	newUser.setEmail(user.getEmail());
	newUser.setName(user.getName());
	} else if (user.getEmail().length() != 0)
	newUser.setEmail(user.getEmail());
	else if (user.getName() != null && user.getName().length() != 0)
	newUser.setName(user.getName());
	usersRepository.save(newUser);
	} catch (Exception e){
	e.printStackTrace();
	}
	return "User Updated Successfully";
	}
	@Override
	public boolean deleteUser(int id) {
	boolean found = true;
	if (getUser(id) != null){
	usersRepository.deleteById(id);
	found = false;
	}
	return found;
	}
}
