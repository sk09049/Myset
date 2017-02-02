package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.BlogDao;
import com.niit.project2.collaboration.model.Blog;

@Transactional
@Repository
public class BlogDaoImpl implements BlogDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
	}

	public boolean save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;

		}
	}

	public Blog get(int id) {
		return (Blog) sessionFactory.openSession().get(Blog.class,id);
	}

	public int getMaxId() {
if(get(1)==null){
	return 0;
}
String hql="select max(id) from Blog";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return (Integer) query.uniqueResult();
	
	}

	public List<Blog> getAcceptedBlogs() {
String hql="from Blog where status='A'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
	}

	public List<Blog> getNewBlogs() {
		String hql="from Blog where status='W'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	public boolean update(Blog blog) {

try {
	if(get(blog.getId())==null){
		return false;
	}
	sessionFactory.getCurrentSession().update(blog);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;

}
	}

	public List<Blog> getMyBlog(String id) {
		String hql="from Blog where user_id='"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
