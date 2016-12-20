package com.niit.scartbackend.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.model.Product;
@Transactional
@Repository("productDao")
public class ProductDaoImpl implements com.niit.scartbackend.dao.ProductDao{
	public static Logger log=LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	SessionFactory sessionfactory;
	
	public ProductDaoImpl (SessionFactory sessionfactory){
		this.sessionfactory=sessionfactory;
	}
	
	public String save(Product product) {
		log.debug(" save product starts");
	try {
	if(get(product.getId())!=null){
			return "primary key already exists";
		}
	product.setDate1("1");
		sessionfactory.getCurrentSession().save(product);
		log.debug(" save product ends");
		return "success";
	} catch (HibernateException e) {
		e.printStackTrace();
		return "exception";
	}
	
	}

	public String update(Product product) {
		log.debug(" update product starts");

		try {
			if(get(product.getId())==null){
				return "no such records";
			}
			product.setId("temp");
			sessionfactory.getCurrentSession().update(product);
			log.debug(" update product ends");

			return"success";
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return "exception";
		}
		
	}
	
	public String delete(Product product) {
		log.debug("delete product starts");
	try {
		if(get(product.getId())==null){
			return "no such id exists";
		}
		sessionfactory.getCurrentSession().delete(product);
		log.debug("delete product ends");
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

	public List<Product> search( String id) {
String hql="from Product where name like '%"+id+"%'";
Query query=sessionfactory.getCurrentSession().createQuery(hql);
return query.list();
	}

	public String getdate(String id) {
String hql="select date1 from Product where id='"+id+"'";
Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.uniqueResult().toString();
	}

	public String getcount(String id) {
		String hql="select todayscount from Product where id='"+id+"'";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.uniqueResult().toString();
	}

	public String setdate(String date,String id) {
		
String hql="update Product set date1='"+date+"' where id='"+id+"'";
Query query=sessionfactory.getCurrentSession().createQuery(hql);
query.executeUpdate();
return "success";
	}

	public String setcount(int count,String id) {
		String hql="update Product set todayscount="+count+" where id='"+id+"'";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		return "success";	}

	public List<Product> gettop3searches(String date) {
String hql="from Product  where date1='"+date+"'order by todayscount desc";
Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.setMaxResults(3).list();
	}



}
