package com.niit.scartbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.niit.scartbackend.dao.UserDao;
import com.niit.scartbackend.model.User;
@Transactional
@Repository("userdao")
public  class UserDaoImpl implements UserDao {
	public static Logger log=LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}

	public String saveuserdetails(User user) {
	
	log.debug("save user starts");
		try {

           if(get(user.getUser())!=null){
				return "1";
			}else {
			user.setRole("ROLE_USER");
			sessionFactory.getCurrentSession().save(user);
			log.debug("save user ends");

			return "4";}
		} catch (HibernateException e) {
			e.printStackTrace();
			return "3";

		}
	}

	public boolean updateuserdetails(User user) {
		log.debug("update user starts");

	try {
		if(get(user.getUser())==null){
			return false;
		}
		sessionFactory.getCurrentSession().update(user);
		log.debug("update user ends");

		return true;
	} catch (HibernateException e) {
		e.printStackTrace();
		return false;

	}
	}

	public boolean deleteUserdtails(User user) {
		log.debug("delete user starts");

		try {
			if(get(user.getUser())==null){
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
			log.debug("delete user ends");

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
		String hql2="from User where user='"+id+"'"+"and pass ='"+password+"'"+"and role='ROLE_ADMIN'";
		Query query1=sessionFactory.getCurrentSession().createQuery(hql2);
		 return query1.list();

	}

}
