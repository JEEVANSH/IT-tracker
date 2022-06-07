package com.ITOITTracker.ITTracker.Services;

import java.util.List;

import com.ITOITTracker.ITTracker.Entity.User;

public interface UserServices {
	
	public List<User> userList();
	public User createUser(User user);
	public User getUser(int id);
	public List<User> getUser(String value);
	public String updateUser(int id, User user);
	public boolean deleteUser(int id);

}
