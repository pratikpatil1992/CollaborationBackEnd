package com.letzchat.Collaboration;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.Collaboration.dao.FriendDAO;
import com.letzchat.Collaboration.model.Friend;

public class FriendDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static Friend friend;
	
	@Autowired
	private static FriendDAO friendDAO;
	
	@BeforeClass
	public static void init()
	{
		context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.letzchat");
		context.refresh();
		friend= ( Friend) context.getBean("friend");
		friendDAO= ( FriendDAO) context.getBean("friendDAO");
	}
	
	@Test
	public void createFriendTestCase()
	{
		friend.setId("F000");
		friend.setUser_id("U001");
		friend.setStatus('N');
		friend.setFriend_id("F001");
		friend.setIsOnline('O');
		friend.setLastSeenTime(null);
		
		boolean flag=friendDAO.save(friend);
		assertEquals("createFriendTestCase",true,flag);
	}
	
	//@Test
	public void updateFriendTestCase()
	{
		friend.setId("F001");
		friend.setUser_id("U002");
		friend.setStatus('N');
		friend.setFriend_id("F002");
		friend.setIsOnline('D');
		friend.setLastSeenTime(null);
		
		boolean flag=friendDAO.update(friend);
		assertEquals("updateFriendTestCase",true,flag);
	}
	
	//@Test
	public void getFriendTestCase()
	{
		friend= friendDAO.get("F006");
		assertEquals("getFriendTestCase", null,friend);
	}
	
	//@Test
	public void getAllFirendTestCase()
	{
		int size=friendDAO.list().size();
		assertEquals("getAllFriendTestCase",5,size);
	}
	
	
}