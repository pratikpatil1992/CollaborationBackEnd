package com.letzchat.Collaboration.dao;

import java.util.List;

import com.letzchat.Collaboration.model.JobApplication;

public interface JobApplicationDAO {

public JobApplication get(String id);
	
	public List<JobApplication> list();
	public List<JobApplication> appliedlist(String userid);
	
	
	public boolean save(JobApplication jobapplication);
	public boolean update(JobApplication jobapplication);
	public boolean delete(String id);
}
