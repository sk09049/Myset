package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.UserDao;
import com.niit.scartbackend.model.User;
@Transactional
@Repository("userdao")
public  class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}

	public String saveuserdetails(User user) {
	
	
		try {

           if(get(user.getUser())!=null){
				return "1";
			}else {
			user.setRole("role_user");
			sessionFactory.getCurrentSession().save(user);
			return "4";}
		} catch (HibernateException e) {
			e.printStackTrace();
			return "3";

		}
	}

	public boolean updateuserdetails(User user) {
	try {
		if(get(user.getUser())==null){
			return false;
		}
		sessionFactory.getCurrentSession().update(user);
		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;

	}
	}

	public boolean deleteUserdtails(User user) {
		
		try {
			if(get(user.getUser())==null){
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;

		}
	}

	public User get(String user) {
        return (User) sessionFactory.openSession().get(User.class,user);
	}

	public List<User> list() {
		String hql="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<User> userValidation(String id, String password) {
		String hql="from User where user='"+id+"'"+"and pass ='"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		

	
	}

	public List<User> adminValidation(String id, String password) {
		String hql2="from User where user='"+id+"'"+"and pass ='"+password+"'"+"and role='role_admin'";
		Query query1=sessionFactory.getCurrentSession().createQuery(hql2);
		 return query1.list();

	}

}
