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

	@Override
	public void remove(Comment comment) {
		
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
