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

import com.letzchat.dao.CommentDAO;
import com.letzchat.model.Comment;
import com.letzchat.model.Comment;

@Repository("commentDAO")
@Transactional
public class CommentDAOImpl implements CommentDAO 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(FriendDAOImpl.class);
	
	@Override
	public Comment get(String id) {
		return (Comment) sessionFactory.openSession().get(Comment.class, id);
	}

	@Override
	public List<Comment> getComments(String blogId) {
		List<Comment> comments=(List<Comment>)sessionFactory.openSession().createQuery("from Comment where blog_id='"+blogId+"'").list();
		return comments;
	}

	public void add(Comment comment) {
		
	}

	public boolean delete(String id) {
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
	
	public boolean save(Comment comment) {
		try {
			Session session= sessionFactory.openSession();
			int newidno =session.createQuery("from Comment").list().size() +1;
			comment.setId("C"+newidno);
			comment.setcommentDate(new Date());
			session.save(comment);
			session.flush();
			session.close();
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
}
