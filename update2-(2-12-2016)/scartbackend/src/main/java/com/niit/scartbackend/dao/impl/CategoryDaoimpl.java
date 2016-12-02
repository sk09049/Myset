package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.model.Category;
@Repository("CategoryDao")
@Transactional
public class CategoryDaoimpl implements CategoryDao {
@Autowired
SessionFactory sessionFactory;
public CategoryDaoimpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
	public String save(Category category) {
		try {
			if(get(category.getId())!=null){
				return "idexist";
			}
			sessionFactory.getCurrentSession().save(category);
			return "added";
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception";
		}
		
	
	}

	public String update(Category category) {
		try {
			if(get(category.getId())==null){
	     			return "idNotExists";
	     	}
			sessionFactory.getCurrentSession().update(category);
			return "updated";
		} catch (Exception e) {
			e.printStackTrace();
			return "exception";
		}

		
		
	}

	public Category get(String id) {
		return (Category) sessionFactory.openSession().get(Category.class,id);
		
		
	}

	public boolean delete(Category category) {
		try {
			if(get(category.getId())==null){
     			return false;
     	}
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
		

	}
@Transactional //open the connection commit roll back close connection all
	public List<Category> list() {
		String hql="from Category";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
