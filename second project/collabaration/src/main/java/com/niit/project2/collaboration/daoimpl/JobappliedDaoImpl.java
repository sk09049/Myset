package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.JobAppliedDao;
import com.niit.project2.collaboration.model.JobApplied;

@Repository
@Transactional
public class JobappliedDaoImpl implements JobAppliedDao{
@Autowired
	SessionFactory sessionFactory;
	public JobappliedDaoImpl(SessionFactory sessionFactory) {
this.sessionFactory=sessionFactory;
	}
	
	public boolean save(JobApplied jobApplied) {
try {
	if(get(jobApplied.getId())!=null){
		System.out.println("id existsbbbbbbbbbb");
		return false;
	}
	sessionFactory.getCurrentSession().save(jobApplied);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;

}
	}

	public JobApplied get(String id) {
		return (JobApplied) sessionFactory.openSession().get(JobApplied.class,id);
	}

	public JobApplied isJobApplied(String jobid, String userid) {
String hql="from JobApplied where job_id='"+jobid+"' and user_id='"+userid+"'";
try {
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return (JobApplied) query.uniqueResult();
} catch (HibernateException e) {
	e.printStackTrace();
}

		return null;
	}

	public String maxId() {
		if(get("jobapply01")==null){
			return "jobapply00";
		}
String hql="select max(id) from JobApplied";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.uniqueResult().toString();
	}

	public List<JobApplied> list(String id) {
String hql="from JobApplied where user_id='"+id+"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
	}

	public List<JobApplied> getapplieduser(String id) {
String hql="select user_id from JobApplied where job_id='"+id+"' and status='N'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
	}

	public boolean update(JobApplied jobApplied) {
try {
	sessionFactory.getCurrentSession().update(jobApplied);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;

}
	}

}
