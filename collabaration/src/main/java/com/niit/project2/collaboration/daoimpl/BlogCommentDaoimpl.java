package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.BlogCommentsDao;
import com.niit.project2.collaboration.model.BlogComment;

@Transactional
@Repository
public class BlogCommentDaoimpl implements BlogCommentsDao{
	
	public static Logger log=LoggerFactory.getLogger(BlogCommentsDao.class);

@Autowired
SessionFactory sessionFactory;
	public BlogCommentDaoimpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
	
	public boolean save(BlogComment blogComment) {
try {
	sessionFactory.getCurrentSession().save(blogComment);
	return true;

} catch (HibernateException e) {
	e.printStackTrace();
	return false;

}
	}

	public int getMaxId() {
String hql="select max(id) from BlogComment";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return (Integer) query.uniqueResult();
	}

	public List<BlogComment> getAllComments() {

		String hql="from BlogComment";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
