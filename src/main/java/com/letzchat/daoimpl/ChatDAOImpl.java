package com.letzchat.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.letzchat.dao.ChatDAO;
import com.letzchat.model.Chat;

@Repository("chatDAO")
@Transactional
public class ChatDAOImpl implements ChatDAO {

private static Logger log = LoggerFactory.getLogger(ChatDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public Chat get(String id) {
		return (Chat) sessionFactory.openSession().get(Chat.class, id);
		
	}

	public List<Chat> list() {
		return sessionFactory.openSession().createQuery("from Chat").list();
	}

	public boolean save(Chat chat) {
		try {
			Session session=sessionFactory.openSession();
			session.save(chat);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Chat chat) {
		try {
			Session session=sessionFactory.openSession();
			session.update(chat);
			session.flush();
			session.close();
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		log.debug("Starting of the method delete");
		log.debug("Trying to delte the record : " + id);
		try {
			sessionFactory.openSession().delete(get(id));
			log.debug("successfully delted the record :" + id);
		} catch (HibernateException e) {
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete");
		return true;
	}
}