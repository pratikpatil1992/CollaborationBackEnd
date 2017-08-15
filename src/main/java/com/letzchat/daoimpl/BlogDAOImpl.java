package com.letzchat.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.letzchat.dao.BlogDAO;
import com.letzchat.model.Blog;
import com.letzchat.model.User;

@Repository("blogDAO")

public class BlogDAOImpl implements BlogDAO
{
	
	private static Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private User userdetails;
	
	public Blog get(String id) {
	log.debug("Starting get method");
	
	Blog blog=	(Blog) sessionFactory.openSession().get(Blog.class, id);
	
	log.debug("Ending get method"+blog);
		return blog;
	}

	public List<Blog> list() {
		return sessionFactory.openSession().createQuery("from Blog").list();
	}
	@Transactional
	public boolean save(Blog blog) {
		
		try {
			Session session=sessionFactory.openSession();
			int newidno =session.createQuery("from Blog").list().size()+1;
			String id1 ="B"+newidno;
			blog.setId(id1);
			blog.setDate_time(new Date(System.currentTimeMillis()));
			session.save(blog);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Blog blog) {
		try {
			Session session=sessionFactory.openSession();
			
			session.update(blog);
			session.flush();
			session.close();
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String id) 
	{
		log.debug("Starting of the method delete");
		log.debug("Trying to delete the record : " + id);
		try {
			Session session=sessionFactory.openSession();
			session.delete(get(id));
			session.flush();
			session.close();
			log.debug("successfully deleted the record :" + id);
		} catch (HibernateException e) {
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete");
		return true;
	}
	
	public List<Blog> searchlist(String title) {
		return sessionFactory.openSession().createQuery("from Blog where lower(title) like "+"'"+title+"'").list();
	}

}