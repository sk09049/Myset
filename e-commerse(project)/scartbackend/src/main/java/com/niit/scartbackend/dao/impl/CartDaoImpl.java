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

import com.niit.scartbackend.dao.CartDao;
import com.niit.scartbackend.model.Cart;
@Transactional
@Repository("cartdao")
public class CartDaoImpl implements CartDao {
public static Logger log=LoggerFactory.getLogger(CartDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public boolean save(Cart cart) {
		log.info("starting of saving cart details ");
		try {
			if(get(cart.getId())!=null){
				return false;
			}
			sessionFactory.getCurrentSession().save(cart);
			log.info("ending of saving cart details ");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		log.debug("update cart starts");
		try {
			if(get(cart.getId())==null){
	     			return false;
	     	}
			sessionFactory.getCurrentSession().update(cart);
			log.debug("update cart ends");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Cart cart) {
		log.debug("delete cart starts");
		try {
			if(get(cart.getId())==null){
     			return false;
     	}
			sessionFactory.getCurrentSession().delete(cart);
			log.debug("delete cart ends");
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public Cart get(String id) {
		log.debug("get cart starts");
		return (Cart) sessionFactory.openSession().get(Cart.class,id);

	}

	public List<Cart> listofrows() {
		log.debug("get full  details from cart table starts");
		String hql="from Cart";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("get full  details from cart table ends");
		return query.list();
	}
	public String maxId() {
		log.debug("getting maxid from cart starts");
if(get("cart01")==null){
	log.debug("no id is present in carttable");
	return"cart00";
}
String hql ="select max(id) from Cart";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
log.debug("getting maxid from cart ends");
return query.uniqueResult().toString();
}
	
	
public int getcartcount( String id) {
	log.debug("get no of rows in cart table for specific user starts");
String hql="select count(*) from Cart where user ='"+id+"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
int a=Integer.parseInt(query.uniqueResult().toString());
return a;
	}
	public List<Cart> getallcartforcurrentuser(String id) {
String hql="from Cart where user ='"+id+"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
log.debug("get no of rows in cart table for specific user ends");
return query.list();
	}
	public String gettotalofneworders(String id) {
		
String hql="select sum(price*quantity) from Cart where user='"+id+"'and status='N'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
try {
	return query.uniqueResult().toString();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return "0";
}
	}
	public List<Cart> getlistofneworders(String id) {
		log.debug("get all details from cart starts");
		String hql="from Cart where user='"+id+"'and status='N'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("get all details from cart ends");
		return query.list();
	}
	public void updaten_as_p_inCarttable(String id) {
String hql="UPDATE Cart set status='P' where user='"+id+"' and status='N'";		
Query query=sessionFactory.getCurrentSession().createQuery(hql);
log.debug("updating status n to p in cart table after purchase done for buy all products in cart");
query.executeUpdate();
	}
	public void updatesinglecartid(String id) {
String hql="update Cart set status='P' where id='"+id+"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
log.debug("update status n to p for single cart id done");
query.executeUpdate();
	
	}

	
}
