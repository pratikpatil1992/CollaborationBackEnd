package com.letzchat.Collaboration;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.letzchat.Collaboration.dao.ChatDAO;
import com.letzchat.Collaboration.model.Chat;

public class ChatDAOTestCase 
{
	@Autowired
	static AnnotationConfigApplicationContext  context;
	
	@Autowired
	private static Chat chat;
	
	@Autowired
	private static ChatDAO chatDAO;
	
	@BeforeClass
	public static void init()
	{
	context	=new  AnnotationConfigApplicationContext ();
		context.scan("com.letzchat");
		context.refresh();
		
		chat= (Chat) context.getBean("chat");
		chatDAO= (ChatDAO) context.getBean("chatDAO");
		
		
	}
	
	@Test
	public void createChatTestCase()
	{
		chat.setId("C001");
		chat.setUser_id("U001");
		chat.setMessage("Hi");
		chat.setFriend_id("F001");
		chat.setDateTime(null);
		chat.setComment_date(null);
		
		boolean flag=chatDAO.save(chat);
		assertEquals("createChatTestCase",true,flag);
	}
	
	//@Test
	public void updateChatTestCase()
	{
		chat.setId("C001");
		chat.setUser_id("U001");
		chat.setMessage("Hiiiii");
		chat.setFriend_id("F001");
		chat.setDateTime(null);
		chat.setComment_date(null);
		boolean flag=chatDAO.update(chat);
		assertEquals("updateChatTestCase",true,flag);
	}
	
	//@Test
	public void getChatTestCase()
	{
		chat= chatDAO.get("U009");
		assertEquals("getChatTestCase", null,chat);
	}
	
	//@Test
	public void getAllChatTestCase()
	{
		int size=chatDAO.list().size();
		assertEquals("getAllUserTestCase",2,size);
	}
	
}