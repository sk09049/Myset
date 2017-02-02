package com.niit.project2.collaboration.daoimpl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project2.collaboration.dao.Userdao;
import com.niit.project2.collaboration.model.User;
@Repository("userdao")
@Transactional
public class Userdaoimpl  implements Userdao{
	@Autowired
	SessionFactory sessionFactory;
	public Userdaoimpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	public String save(User user) {
		try {
		if(get(user.getId())!=null){
				return "idexists";
			}
			sessionFactory.getCurrentSession().save(user);
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception";
		}
			
	}

	public List<User> getlistofuser() {
String hql="from User where status='A'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
	}

	public User get(String id) {
		return (User) sessionFactory.openSession().get(User.class,id);
	}

public String update(User user) {
try {
	if(get(user.getId())==null){
		return "idnotexists";
	}
	sessionFactory.getCurrentSession().update(user);
	return "success";
} catch (HibernateException e) {
	e.printStackTrace();
	return "exception";
}
	}


public String validate(String id, String password) {
	
	String hql="from User where id='"+id+"' and password='"+password+"'";
	try {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		User user=(User) query.uniqueResult();
		if(user==null){
			return "invalid";
		}
		else if(user.getIs_verified()!='Y'){
			return "not";
		}
		else {
			String hql1="select status from User where id='"+id+"' and password='"+password+"'";
			try {
				Query query1=sessionFactory.getCurrentSession().createQuery(hql1);
				return query1.uniqueResult().toString();
			} catch (HibernateException e) {
				e.printStackTrace();
				return "validateexception";
			}
		}

	}catch (HibernateException e1) {
		e1.printStackTrace();
		return "connectexception";
	}
	
}

public String reasonforrejection(String id) {
String hql="select reason from User where id='"+id+"'";
Query query1;
try {
	query1 = sessionFactory.getCurrentSession().createQuery(hql);
} catch (HibernateException e) {
e.printStackTrace();
return "rejctionexception";
}
return query1.uniqueResult().toString();
}

public List<User> listOfNewUser() {
String hql="from User where status='W'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
}

public List<User> list() {

	String hql="from User";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}

	

}
