package com.letzchat.daoimpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.letzchat.dao.UserDAO;
import com.letzchat.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	public void storeFile(MultipartFile file,HttpServletRequest request)
	{
		try {
			byte[] bytes=file.getBytes();
			String path=request.getRealPath("/")+"images\\userimages\\"+file.getName();
			System.out.println(path);
			path=path.substring(0,96);
			path=path.concat("CollaborationFrontEnd\\images\\userimages\\");
			path=path.concat(file.getOriginalFilename());
			System.out.println(path);
			File serverFile=new File(path);
			serverFile.createNewFile();
			BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	
	public User get(String id) {
		User userdetails= (User)sessionFactory.openSession().get(User.class, id);
		return userdetails;
	}
	
	public User getUser(String id){
		log.debug("->->Starting of the method getUser");
		String hql = "from User where id="+"'"+id+"'";
		
		log.debug("Query is : "+hql);
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			User u=(User) list.get(0);
			log.debug("Got:"+u.getName());
			System.out.println(u);
			return u;
		}
		
		return null;
	}

	public List<User> list() {
		return sessionFactory.openSession().createQuery("from User").list();
	}

	public List<User> searchlist(String name) {
		return sessionFactory.openSession().createQuery("from User where name='"+name+"'").list();
	}
	
	public User validate(String email, String password) {
		log.debug("->->Starting of the method validate");
		String hql = "from User where email= '" + email + "' and " + " password ='" + password+"'";
		
		log.debug("Query is : "+hql);
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			User u=(User) list.get(0);
			u.setIsOnline('Y');
			log.debug("Got:"+u.getName());
			return u;
		}
		
		return null;
	}

	public boolean save(User user) {
		try
		{
			
			Session session =sessionFactory.openSession();
			int newidno =session.createQuery("from User").list().size() +1;
			String id ="U"+newidno;
			user.setId(id);
			user.setIsOnline('Y');
			user.setLastSeenTime(new Date());
			user.setRole("user");
			session.save(user);
			session.flush();
			session.close();
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		
		try {
			Session session =sessionFactory.openSession();
			session.update(user);
			session.flush();
			session.close();
	
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		log.debug("Starting of the method delete");
		log.debug("Trying to delte the record : " + id);
		
		try
		{
		
		sessionFactory.openSession().delete(get(id));
		log.debug("successfully deleted the record :" + id);
		}catch(Exception e)
		{
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete");
		return true;
	}

}