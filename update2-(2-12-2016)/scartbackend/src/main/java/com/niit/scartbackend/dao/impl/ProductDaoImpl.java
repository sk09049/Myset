package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.model.Product;
@Transactional
@Repository("productDao")
public class ProductDaoImpl implements com.niit.scartbackend.dao.ProductDao{
	@Autowired
	SessionFactory sessionfactory;
	
	public ProductDaoImpl (SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}
	
	public String save(Product product) {
	try {
	if(get(product.getId())!=null){
			return "primary key already exists";
		}
		sessionfactory.getCurrentSession().save(product);
		return "success";
	} catch (HibernateException e) {
		e.printStackTrace();
		return "exception";
	}
	
	}

	public String update(Product product) {
		try {
			if(get(product.getId())==null){
				return "no such records";
			}
			sessionfactory.getCurrentSession().update(product);
			return"success";
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return "exception";
		}
		
	}
	
	public String delete(Product product) {
	try {
		if(get(product.getId())==null){
			return "no such id exists";
		}
		sessionfactory.getCurrentSession().delete(product);
		return "success";
	} catch (HibernateException e) {
		e.printStackTrace();
		return "exception";
	}
	}

	public Product get(String id) {
	return (Product) sessionfactory.openSession().get(Product.class,id);
	}

	public List<Product> listofproducts() {
		String hql="from Product";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
	}



}
