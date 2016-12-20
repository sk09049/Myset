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

import com.niit.scartbackend.dao.BillingAddressDao;
import com.niit.scartbackend.model.BillingAddress;
@Repository("billaddrsdao")
@Transactional
public class BillingAddressDaoImpl implements  BillingAddressDao{
	public static Logger log=LoggerFactory.getLogger(BillingAddressDaoImpl.class);
@Autowired
SessionFactory factory;
public BillingAddressDaoImpl(SessionFactory factory){
	this.factory=factory;
}
	
	public boolean savebilladdrs(BillingAddress address) {
		log.debug("save billing address started");
		try {
			if(get(address.getId())!=null){
				return false;
			}
			factory.getCurrentSession().save(address);
			log.debug("save billing address deleted");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Updatebilladdrs(BillingAddress address) {
		log.debug("update billing address started");
try {
	if(get(address.getId())==null){
		return false;
	}	factory.getCurrentSession().update(address);
	log.debug("update billing address ended");
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;
}
	}

	public boolean deletebilladdrs(BillingAddress address) {
		log.debug("delete billing address started");
		try {
			if(get(address.getId())==null){
				return false;
			}
			factory.getCurrentSession().delete(address);
			log.debug("delete billing address ended");
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public BillingAddress get(String id) {
		log.debug("getting billing address started");
		return (BillingAddress) factory.openSession().get(BillingAddress.class,id);
	}

	public List<BillingAddress> listofAddresses() {
		log.debug("getting all the deatis from billing address started");
		String hql="from BillingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
		log.debug("getting all the deatis from billing address ended");
		return query.list();
	}

	public String getmaxbillingaddressid() {
	if(get("bill01")==null){
		return "bill00";
	}
		String hql="select max(id) from BillingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
		log.debug("getting of maxid from billingaddress table done");
		return query.uniqueResult().toString();
	}

}
