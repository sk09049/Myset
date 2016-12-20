package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.model.Supplier;
@Transactional
@Repository("SupplierDao")
public class SupplierDaoImpl implements SupplierDao {
	public static Logger log=LoggerFactory.getLogger(SupplierDaoImpl.class);

	@Autowired
	SessionFactory sessionfactory;

	public SupplierDaoImpl(SessionFactory sessionfactory){
	this.sessionfactory=sessionfactory;
	}
	public String save(Supplier supplier) {
		log.debug("save supplier starts ");
    try {
 	  if(get(supplier.getId())!=null){
 		return "idexists";}
	sessionfactory.getCurrentSession().save(supplier);
	log.debug("save supplier ends ");
	return "added";
} catch (HibernateException e) {
	e.printStackTrace();
	return "exception";
}
	
     
	}

	public String update(Supplier supplier) {
		log.debug("update supplier starts ");

	try {
		if(get(supplier.getId())==null){
		return "idnotexists";
		}
		sessionfactory.getCurrentSession().update(supplier);
		log.debug("update supplier ends ");

		return "updated";
		
	} catch (HibernateException e) {
		e.printStackTrace();
		return "exeption";
	}
		
	}

	public boolean delete(Supplier supplier) {
		log.debug("delete supplier starts ");

		try {
			if(get(supplier.getId())==null){
				return false;
			}
			sessionfactory.getCurrentSession().delete(supplier);
			log.debug("delete supplier ends ");

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
