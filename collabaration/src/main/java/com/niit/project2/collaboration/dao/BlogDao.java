package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.Blog;

public interface BlogDao {
	public boolean save(Blog blog);
public Blog get(int id);
public int getMaxId();
public List<Blog> getAcceptedBlogs();
public List<Blog> getNewBlogs();
public boolean update(Blog blog);
public List<Blog> getMyBlog(String id);
}
