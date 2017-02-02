package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.EventDao;
import com.niit.project2.collaboration.model.Event;
@Transactional
@Repository
public class EventDaoImpl implements EventDao{
	@Autowired
	SessionFactory sessionFactory;
	public EventDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	public boolean saveEvent(Event event) {
try {
	sessionFactory.getCurrentSession().save(event);
	return true;

} catch (HibernateException e) {
	e.printStackTrace();
	return false;

}
	}

	public List<Event> list() {
		String hql="from Event";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public Event get(int id) {
		return (Event) sessionFactory.openSession().get(Event.class,id);
	}

	public int getMaxId() {
		if(get(1)==null){
			return 0;
		}
String hql="select max(id) from Event";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return (Integer) query.uniqueResult();
	}

}
