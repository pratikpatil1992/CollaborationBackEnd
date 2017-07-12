package com.letzchat.collaboration;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.dao.UserDAO;
import com.letzchat.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDAO userDAO;
	
	@BeforeClass
	public static void init()
	{
	context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.letzchat");
		context.refresh();
		
		user= (User) context.getBean("user");
		userDAO= (UserDAO) context.getBean("userDAO");
	}
	
	//@Test
	public void validateCredentialTestCase()
	{
		User user= userDAO.validate("U001", "Akku");
		Assert.assertEquals("validateCredentialTestCase", true,user);
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("001");
		user.setName("Pratik");
		user.setPassword("123456");
		user.setRole("admin");
		user.setAddress("Panvel");
		user.setEmail("pmpatil92@gmail.com");
		user.setMobile("9221778360");
		user.setIsOnline('O');
		boolean flag= userDAO.save(user);
		assertEquals("createUserTestCase", true, flag);
	}
	
	//@Test
	public void updateTestCase()
	{
		user.setId("002");
		user.setName("Akash");
		user.setPassword("123456");
		user.setRole("Student");
		user.setAddress("Old-Panvel");
		user.setEmail("Akash@yahoo.com");
		user.setMobile("9955126546");
		user.setIsOnline('O');
		
		boolean flag= userDAO.update(user);
		assertEquals("createUserTestCase", true, flag);
	}
	
    //@Test
	public void getUserTestCase()
	{
		user= userDAO.get("9");
		assertEquals("getUserTestCase", null,user);
	}
	
	//@Test
	public void getAllUserTestCase()
	{
		int size=userDAO.list().size();
		assertEquals("getAllUserTestCase",3,size);
	}
	
	
}