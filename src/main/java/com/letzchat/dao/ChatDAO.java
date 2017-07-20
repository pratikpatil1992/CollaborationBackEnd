package com.letzchat.dao;

import java.util.List;

import com.letzchat.model.Chat;

public interface ChatDAO {

	public List<Chat> list();
	public Chat get(String id);
	public boolean save(Chat chat);
	public boolean update(Chat chat);
	public boolean delete(String id);
}