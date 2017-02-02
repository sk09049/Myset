package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.JobDao;
import com.niit.project2.collaboration.model.Job;

@Repository
@Transactional
public class JobDaoimpl implements JobDao{
@Autowired
SessionFactory sessionFactory;
	public JobDaoimpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}
	public String save(Job job) {
		try {
			if(get(job.getId())!=null){
				return "idexists";
			}
			sessionFactory.getCurrentSession().save(job);
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception";
		}
		return "success";
	}

	public String update(Job job) {
		try {
			if(get(job.getId())==null){
				return "idnotexists";
			}
			sessionFactory.getCurrentSession().update(job);
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception";
		}
		return "success";	
		}

	public String delete(Job job) {
		try {
			if(get(job.getId())==null){
				return "idnotexists";
			}
			sessionFactory.getCurrentSession().delete(job);
		} catch (HibernateException e) {
			e.printStackTrace();
			return "exception";
		}
		return "success";
	}

	public Job get(String id) {
		return (Job) sessionFactory.openSession().get(Job.class,id);
	}

	public List<Job> list() {
String hql="from Job";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
	}

	
}
