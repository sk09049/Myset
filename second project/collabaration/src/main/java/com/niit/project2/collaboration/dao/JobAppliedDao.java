package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.JobApplied;

public interface JobAppliedDao {

	public boolean save(JobApplied jobApplied);
	public JobApplied get(String id);
	public JobApplied isJobApplied(String jobid,String userid);
	public String maxId();
	public List<JobApplied> list(String id);
	public List<JobApplied> getapplieduser(String id);
	public boolean update(JobApplied jobApplied);
}
