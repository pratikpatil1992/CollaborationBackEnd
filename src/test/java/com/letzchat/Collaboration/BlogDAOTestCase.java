package com.letzchat.Collaboration;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.Collaboration.dao.BlogDAO;
import com.letzchat.Collaboration.model.Blog;


public class BlogDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static  Blog blog;
	
	@Autowired
	private static BlogDAO blogDAO;
	
	@BeforeClass
	public static void init()
	{
	context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.letzchat");
		context.refresh();
		
		blog= (Blog) context.getBean("blog");
		blogDAO= (BlogDAO) context.getBean("blogDAO");
	}
	
	@Test
	public void createBlogTestCase()
	{
		blog.setId("B001");
		blog.setTitle("FriendsChat");
		blog.setUser_id("U001");
		blog.setStatus('A');
		blog.setDescription("Stay connected with me");
		blog.setReason("Checking connection");
		blog.setDate_time(null);
		
		boolean flag=blogDAO.save(blog);
		assertEquals("createBlogTestCase",true,flag);
	}
	
	//@Test
	public void updateBlogTestCase()
	{
		blog.setId("B001");
		blog.setTitle("FriendsChat");
		blog.setUser_id("U002");
		blog.setStatus('A');
		blog.setDescription("Stay Connected in Free Time");
		blog.setReason("Connection");
		boolean flag =blogDAO.update(blog);
		assertEquals("updateBlogTestCase", true,flag);

	}
	
	//@Test
	public void getBlogTestCase()
	{
		blog=blogDAO.get("B005");
		assertEquals("getBlogTestCAse",null,blog);
	}
	
	//@Test
	public void getAllBlogTestCase()
	{
		int size=blogDAO.list().size();
		assertEquals("getBlogTestCase",3,size);
	}
}