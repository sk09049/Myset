package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.BillingAddressDao;
import com.niit.scartbackend.model.BillingAddress;
@Repository("billaddrsdao")
@Transactional
public class BillingAddressDaoImpl implements  BillingAddressDao{
@Autowired
SessionFactory factory;
public BillingAddressDaoImpl(SessionFactory factory){
	this.factory=factory;
}
	
	public boolean savebilladdrs(BillingAddress address) {
		try {
			if(get(address.getId())!=null){
				return false;
			}
			factory.getCurrentSession().save(address);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Updatebilladdrs(BillingAddress address) {
		
try {
	if(get(address.getId())==null){
		return false;
	}	factory.getCurrentSession().update(address);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;
}
	}

	public boolean deletebilladdrs(BillingAddress address) {
		try {
			if(get(address.getId())==null){
				return false;
			}
			factory.getCurrentSession().delete(address);
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public BillingAddress get(String id) {
		return (BillingAddress) factory.openSession().get(BillingAddress.class,id);
	}

	public List<BillingAddress> listofAddresses() {
		String hql="from BillingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
