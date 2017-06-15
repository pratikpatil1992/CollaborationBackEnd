package com.letzchat.Collaboration.dao;

import java.util.List;

import com.letzchat.Collaboration.model.Blog;

public interface BlogDAO {

public Blog get(String id);
	
	public List<Blog> list();
	
	public boolean save(Blog blog);
	public boolean update(Blog blog);
	public boolean delete(String id);
}
