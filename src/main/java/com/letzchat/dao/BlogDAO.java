package com.letzchat.dao;

import java.util.List;

import com.letzchat.model.Blog;

public interface BlogDAO {

	public Blog get(String id);
	
	public List<Blog> list();
	
	public boolean save(Blog blog);
	public boolean update(Blog blog);
	public boolean delete(String id);
}
