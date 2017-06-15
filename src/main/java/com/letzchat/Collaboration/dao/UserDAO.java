package com.letzchat.Collaboration.dao;

import java.util.List;

import com.letzchat.Collaboration.model.User;

public interface UserDAO {

	public User get(String id);
	public User getEmail(String email);
	
	public List<User> list();
	
	public User isValidate(String email , String password);
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(String id);

	public List<User> notMyFriendList(String loggedInUserID);
	public void setOnline(String id);
	public void setOffLine(String userID);
	
}