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

import com.letzchat.dao.JobApplicationDAO;
import com.letzchat.model.JobApplication;

@Repository("jobApplicationDAO")
@Transactional
public class JobApplicationDAOImpl implements JobApplicationDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(JobApplicationDAOImpl.class);
	
	
	public JobApplication get(String id) {
		return (JobApplication) sessionFactory.openSession().get(JobApplication.class, id);
	}

	public List<JobApplication> list() {
		
		return sessionFactory.openSession().createQuery("from JobApplication").list();
	}
	
	public List<JobApplication> appliedlist(String userid) {
		return sessionFactory.openSession().createQuery("from JobApplication where user_id='"+ userid+"'").list();
	}
	
	public boolean save(JobApplication jobApplication) {
		try {
			Session session= sessionFactory.openSession();
			int newidno =session.createQuery("from JobApplication").list().size() +1;
			jobApplication.setId("JA"+newidno);
			jobApplication.setStatus('W');
			jobApplication.setDateApplied(new Date());
			session.save(jobApplication);
			session.flush();
			session.close();
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(JobApplication jobApplication) {
		try {
			Session session= sessionFactory.openSession();
			session.update(jobApplication);
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
		log.debug("Starting of the method delete of jobApplication");
		log.debug("Trying to delte the record : " + id);
		try
		{
		
		sessionFactory.openSession().delete(get(id));
		log.debug("successfully delted the record of jobApplication :" + id);
		}catch(Exception e)
		{
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete  record of jobApplication");
		return true;
	}

	
}
