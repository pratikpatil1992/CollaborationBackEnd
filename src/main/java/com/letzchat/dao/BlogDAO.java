package com.letzchat.dao;

import java.util.List;

import com.letzchat.model.Blog;
import com.letzchat.model.User;

public interface BlogDAO {

	public Blog get(String id);
	
	public List<Blog> list();
	
	public List<Blog> searchlist(String title);
	
	public boolean save(Blog blog);
	public boolean update(Blog blog);
	public boolean delete(String id);
}
