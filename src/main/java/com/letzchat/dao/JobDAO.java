package com.letzchat.dao;

import java.util.List;

import com.letzchat.model.Job;
import com.letzchat.model.JobApplication;

public interface JobDAO {

	public Job get(String id);
	
	public List<Job> list();
	public List<Job> appliedlist(String jobid);
	 
	public List <Job> getAllOpenedJobs();
	
	public boolean save(Job job);
	public boolean update(Job job);
	public boolean delete(String id);
	
	public boolean updateJob(JobApplication jobApplication);
	
	public List<Job> searchlist(String title);
	
	public JobApplication getJobApplication(String id);
	public List<Job>  getMyAppliedJobs(String userID);
	//select * from JobApplication where userID = ? and jobId=?
		public JobApplication getJobApplication(String userID, String jobID);
		

}