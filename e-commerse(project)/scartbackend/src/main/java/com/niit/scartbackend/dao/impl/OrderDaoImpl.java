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

import com.niit.scartbackend.dao.OrderDao;
import com.niit.scartbackend.model.Order;
@Repository("orderdao")
@Transactional
public class OrderDaoImpl implements OrderDao {
	public static Logger log=LoggerFactory.getLogger(OrderDaoImpl.class);

	@Autowired
	SessionFactory sessionfactory;
	public OrderDaoImpl (SessionFactory sessionFactory){
		this.sessionfactory=sessionFactory;
	}

	public String save(Order order) {
		log.debug("save order starts");
		try {
			if(get(order.getId())!=null){
			
				return "Already exists";
			}
			sessionfactory.getCurrentSession().save(order);
			log.debug("save order ends");

			return"success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return"exception";
		}
	}

	public String update(Order order) {
		log.debug("update order starts");

		try {
			if(get(order.getId())==null){
				return"no such record exists";
			}
			sessionfactory.getCurrentSession().update(order);
			log.debug("update order ends");

			return"success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return"eception";
		}
	}

	public String delete(Order order) {
		log.debug("delete order starts");

		try {
			if(get(order.getId())==null){
				return"no such record exists";
			}
			sessionfactory.getCurrentSession().delete(order);
			log.debug("delete order ends");
			return"success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return"eception";
		}
	}

	public Order get(String id) {
 return (Order) sessionfactory.openSession().get(Order.class,id);
	}

	public List<Order> listall() {
String hql="from Order";
Query query=sessionfactory.getCurrentSession().createQuery(hql);
return query.list() ;
	}

}
