package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.BlogComment;

public interface BlogCommentsDao {
public boolean save(BlogComment blogComment);
public int getMaxId();
public List<BlogComment> getAllComments();
}
