package com.letzchat.Collaboration.dao;

import java.util.List;

import com.letzchat.Collaboration.model.Job;
import com.letzchat.Collaboration.model.JobApplication;

public interface JobDAO {

	public Job get(String id);
	
	public List<Job> list();
	public List<Job> appliedlist(String jobid);
	 
	public List <Job> getAllOpendJobs();
	
	public boolean save(Job job);
	public boolean update(Job job);
	public boolean delete(String id);
	
	public boolean save(JobApplication jobApplication);
	public boolean updateJob(JobApplication jobApplication);

	public JobApplication getJobApplication(String id);
	public List<Job>  getMyAppliedJobs(String userID);
	//select * from JobApplication where userID = ? and jobId=?
		public JobApplication getJobApplication(String userID, String jobID);
		

}