package com.letzchat.dao;

import java.util.List;

import com.letzchat.model.Comment;

public interface CommentDAO {

	public Comment get(String id) ;
	

	public List<Comment> getComments(String blogId) ;


	public void add(Comment comment) ;

	public boolean save(Comment comment);
	public void remove(Comment comment);
}
