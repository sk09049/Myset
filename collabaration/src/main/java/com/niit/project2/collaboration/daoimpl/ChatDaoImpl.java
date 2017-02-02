package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.ChatDao;
import com.niit.project2.collaboration.model.Chat;

@Transactional
@Repository
public class ChatDaoImpl implements ChatDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public ChatDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public boolean save(Chat chat) {
		try {
			sessionFactory.getCurrentSession().save(chat);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Chat> list(String id) {

		String hql1="from Chat where msg_senderId='"+id+"'";
		String hql2="from Chat where msg_recieverId='"+id+"'";
		Query query1=sessionFactory.getCurrentSession().createQuery(hql1);
		Query query2=sessionFactory.getCurrentSession().createQuery(hql2);
		List<Chat> list1=query1.list();
		List<Chat> list2=query2.list();
		list1.addAll(list2);
		return list1;
	}

	public int getMaxid() {
		if(get(1)==null){
			return 0;
		}
		String hql="select max(id) from Chat";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return (Integer) query.uniqueResult();
	}

	public Chat get(int id) {
		return (Chat) sessionFactory.openSession().get(Chat.class,id);
	}

}
