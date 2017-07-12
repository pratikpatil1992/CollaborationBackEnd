package com.letzchat.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.letzchat.dao.FriendDAO;
import com.letzchat.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(FriendDAOImpl.class);
	
	public Friend get(String friendID, String userID) {
		String hql = "from Friend where user_id=" + "'" + userID + "' and friend_id= '" + friendID + "'";
		log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		log.debug(friendID);
		return (Friend) query.uniqueResult();
	}
	
	public List<Friend> getAllFriends(String userID) {
		String hql = "from Friend where (user_id=" + "'" + userID + "' and status='Y') or (friend_id=" + "'" + userID + "' and status='Y')";
		log.debug("hql:" + hql);
		return (List<Friend>)sessionFactory.openSession().createQuery(hql).list();
	}

	public Friend getFriendById(String id) {
		return (Friend) sessionFactory.openSession().get(Friend.class, id);
	}

	public boolean save(Friend friend) {
		try {
			
			Session session=sessionFactory.openSession();
			int newidno =session.createQuery("from Friend").list().size() +1;
			String id ="F"+newidno;
			friend.setId(id);
			session.save(friend);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	}

	public boolean update(Friend friend) {
		try {
			Session session=sessionFactory.openSession();
			session.update(friend);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		log.debug("Starting of the method delete of Friend");
		log.debug("Trying to delete the record : " + id);
		try
		{
		
		sessionFactory.openSession().delete(getFriendById(id));
		log.debug("successfully deleted the record :" + id);
		}catch(Exception e)
		{
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete of Friend");
		return true;
	}

	
	public void delete(String userID, String friendID) {
		Friend friend = new Friend();
		friend.setFriend_id(friendID);
		friend.setUser_id(userID);
		sessionFactory.openSession().delete(friend);
	}

	public List<Friend> getNewFriendRequests(String userID) {
		String hql = "from Friend where friend_id=" + "'" + userID + "' and status ='" + "N'";

		log.debug(hql);
		 return  sessionFactory.openSession().createQuery(hql).list();

	}

	public List<Friend> getAllRequests(String userID) {
		String hql="from Friend where friend_id='"+userID+"'"+" and status='N'";
		return sessionFactory.openSession().createQuery(hql).list();
	}
	
	public List<Friend> getSentRequests(String userID) {
		String hql="from Friend where user_id='"+userID+"'"+" and status='N'";
		return sessionFactory.openSession().createQuery(hql).list();
	}

}