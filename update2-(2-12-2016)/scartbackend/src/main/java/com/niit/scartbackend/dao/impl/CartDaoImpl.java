package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.CartDao;
import com.niit.scartbackend.model.Cart;
@Transactional
@Repository("cartdao")
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public boolean save(Cart cart) {
		try {
			if(get(cart.getId())!=null){
				return false;
			}
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		try {
			if(get(cart.getId())==null){
	     			return false;
	     	}
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Cart cart) {
		try {
			if(get(cart.getId())==null){
     			return false;
     	}
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public Cart get(String id) {
		return (Cart) sessionFactory.openSession().get(Cart.class,id);

	}

	public List<Cart> listofrows() {
		String hql="from Cart";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
