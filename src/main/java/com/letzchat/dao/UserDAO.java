package com.letzchat.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.letzchat.model.User;

public interface UserDAO {

	public User get(String id);
	public User getUser(String id);
	
	public List<User> list();
	public List<User> searchlist(String name);
	
	public User validate(String email , String password);
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(String id);
	
	public void storeFile(MultipartFile file, HttpServletRequest request);
	
}
