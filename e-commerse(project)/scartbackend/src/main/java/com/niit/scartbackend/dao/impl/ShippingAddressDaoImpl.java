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

import com.niit.scartbackend.dao.ShippingaddressDao;
import com.niit.scartbackend.model.ShippingAddress;
@Repository("shipaddrsdao")
@Transactional
public class ShippingAddressDaoImpl implements ShippingaddressDao{
	public static Logger log=LoggerFactory.getLogger(ShippingAddressDaoImpl.class);
	@Autowired
	SessionFactory factory;
	public ShippingAddressDaoImpl(SessionFactory factory){
		this.factory=factory;
	}

	public boolean saveshipaddrs(ShippingAddress address) {
		log.debug("save shippaddress starts");
		try {
			if(get(address.getId())!=null){
				return false;
			}
			factory.getCurrentSession().save(address);
			log.debug("save shippaddress ends");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean Updateshipaddrs(ShippingAddress address) {
		log.debug("update shippaddress starts");

		try {
			if(get(address.getId())==null){
				return false;
			}	factory.getCurrentSession().update(address);
			log.debug("update shippaddress ends");

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteshipaddrs(ShippingAddress address) {
		log.debug("delete shippaddress starts");

		try {
			if(get(address.getId())==null){
				return false;
			}	
			factory.getCurrentSession().delete(address);
			log.debug("delete shippaddress ends");

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ShippingAddress get(String id) {
		return (ShippingAddress) factory.openSession().get(ShippingAddress.class,id);

	}

	public List<ShippingAddress> listofAddresses() {
		String hql="from ShippingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public String getshippingaddressid() {
		if(get("ship01")==null){
			return "ship00";
		}
		String hql="select max(id) from ShippingAddress";
		Query query=factory.getCurrentSession().createQuery(hql);
	String a=query.uniqueResult().toString();
	return a;
	}
	}


