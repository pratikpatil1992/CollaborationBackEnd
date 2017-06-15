package com.letzchat.Collaboration.daoimpl;

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

import com.letzchat.Collaboration.dao.BlogDAO;
import com.letzchat.Collaboration.model.Blog;
import com.letzchat.Collaboration.model.User;


@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	
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
		
		return sessionFactory.openSession().createQuery("from Blog where status!='R'").list();
	}

	public boolean save(Blog blog) {
		
		try {
			Session session=sessionFactory.openSession();
			int newidno1 =session.createQuery("from Blog").list().size() +1;
			String id1 ="B"+newidno1;
			blog.setId(id1);
		
			//blog.setUser_id(user.getId());
			System.out.println("UserID:"+userdetails.getId());
			blog.setDate_time(new Date(System.currentTimeMillis()));
			blog.setStatus('A');
			session.save(blog);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

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

	
	public boolean delete(String id) 
	{
		log.debug("Starting of the method delete");
		log.debug("Trying to delete the record : " + id);
		try {
			Session session=sessionFactory.openSession();
			session.delete(get(id));
			session.flush();
			session.close();
			log.debug("successfully delted the record :" + id);
		} catch (HibernateException e) {
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete");
		return true;
	}

}