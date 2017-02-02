package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.Job;

public interface JobDao {
	public String save(Job job);
	public String update(Job job);
	public String delete(Job job);
	public Job get(String id);
	public List<Job> list();
}
