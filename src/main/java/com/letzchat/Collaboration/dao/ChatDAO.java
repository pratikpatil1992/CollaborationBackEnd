package com.letzchat.Collaboration.dao;

import java.util.List;

import com.letzchat.Collaboration.model.Chat;

public interface ChatDAO {

	public Chat get(String id);
	
	public List<Chat> list();
	
	public boolean save(Chat chat);
	public boolean update(Chat chat);
	public boolean delete(String id);
}