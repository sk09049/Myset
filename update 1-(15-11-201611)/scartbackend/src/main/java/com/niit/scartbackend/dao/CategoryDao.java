package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Category;
public interface CategoryDao {

	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category get(String id);
	public List<Category> list();
}
