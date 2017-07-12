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

import com.letzchat.dao.JobDAO;
import com.letzchat.model.Job;
import com.letzchat.model.JobApplication;


@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger log = LoggerFactory.getLogger(JobDAOImpl.class);
	
	
	public Job get(String id) {
		return (Job) sessionFactory.openSession().get(Job.class, id);
		
	}

	public List<Job> list() {
		
		return sessionFactory.openSession().createQuery("from Job where status='V'").list();
	}
	
	public List<Job> appliedlist(String jobid)
	{
		return sessionFactory.openSession().createQuery("from Job where id='"+ jobid+"'").list();
	}

	public boolean save(Job job) {
		try {
			Session session=sessionFactory.openSession();
			int newidno3 =session.createQuery("from Job").list().size() +1;
			String id3 ="J"+newidno3;
			job.setId(id3);
			job.setStatus('V');
			job.setDate_Time(new Date());
			session.save(job);
			session.flush();
			session.close();
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Job job) {
		try {
			Session session=sessionFactory.openSession();
			
			session.update(job);
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
		log.debug("Starting of the method delete of job");
		log.debug("Trying to delete the record : " + id);
		try
		{
		Session session=sessionFactory.openSession();
		session.createQuery("delete from Job where id='"+id+"'");
		session.flush();
		session.close();
		log.debug("successfully deleted the record :" + id);
		}
		catch(Exception e)
		{
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete of job");
		return true;
	}

	public boolean updateJob(JobApplication jobApplication) {
		try {
			Session session=sessionFactory.openSession();
			session.update(jobApplication);
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public JobApplication getJobApplication(String id) {
		JobApplication jobApplication= (JobApplication) sessionFactory.openSession().load("JobApplication.class", id);
		return jobApplication;
	}

	@SuppressWarnings("unchecked")
	public List<Job> getMyAppliedJobs(String userID) {
		return	(List<Job>) sessionFactory.openSession().createQuery(" from JobApplication where user_id=?");
	
	}

	public JobApplication getJobApplication(String userID, String jobID) {
		
	List<JobApplication> list=sessionFactory.openSession().createQuery("from JobApplication where user_id = '"+userID+"' and job_id='"+jobID+"'").list();
	if(list.isEmpty())
		return null;
	else
		return list.get(0);
	
	}

	public List<Job> getAllOpenedJobs() {
		
		return sessionFactory.openSession().createQuery("from Job where status='V'").list();
	}
	
}