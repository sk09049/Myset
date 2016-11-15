package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.model.Supplier;
@Transactional
@Repository("SupplierDao")
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionfactory;

	public SupplierDaoImpl(SessionFactory sessionfactory){
	this.sessionfactory=sessionfactory;
	}
	public boolean save(Supplier supplier) {
    try {
 	  if(get(supplier.getId())!=null){
 		return false;}
	sessionfactory.getCurrentSession().save(supplier);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;
}
	
     
	}

	public boolean update(Supplier supplier) {
	try {
		if(get(supplier.getId())==null){
		return false;
		}
		sessionfactory.getCurrentSession().update(supplier);
		return true;
		
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;
	}
		
	}

	public boolean delete(Supplier supplier) {
		try {
			if(get(supplier.getId())==null){
				return false;
			}
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier get(String id) {
		return (Supplier)sessionfactory.openSession().get(Supplier.class,id);
	}

	public List<Supplier> list() {
		String hql="from Supplier";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
