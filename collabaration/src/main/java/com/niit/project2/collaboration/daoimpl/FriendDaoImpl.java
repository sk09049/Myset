package com.niit.project2.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.project2.collaboration.dao.FriendDao;
import com.niit.project2.collaboration.model.Friend;
@Transactional
@Repository
public class FriendDaoImpl implements FriendDao{

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Friend friend;
	
	public FriendDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public boolean save(Friend friend) {
try {
	sessionFactory.getCurrentSession().save(friend);
	return true;
} catch (HibernateException e) {
	e.printStackTrace();
	return false;

}
	}
	public Friend get(String userid, String friendid) {
		
String hql="from Friend where user_id='"+userid+"' and friend_id='"+friendid+"'";
Query query=sessionFactory.openSession().createQuery(hql);
return (Friend) query.uniqueResult();
	}
	
	
	public int getMaxId() {
		System.out.println("get maxid");
		if(getsinglerow(1)==null){
			System.out.println("fnjjjjjjjjjjjj");
			return 0;
		}
String hql="select max(id) from Friend ";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
System.out.println("end of max id");
return (Integer) query.uniqueResult();
	}
	public Friend getsinglerow(int id) {
		System.out.println("get single row");
		return (Friend) sessionFactory.getCurrentSession().get(Friend.class,id);
	}
	public List<Friend> getFriendRequest(String id) {
String hql="from Friend where friend_id='"+id+"' and status='N'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return query.list();
}
	
	public Friend accept(String userid, String requesterid) {
		friend=get(requesterid,userid);
		System.out.println("dsfsf"+userid+" "+requesterid);
		if(friend==null){
			friend=new Friend();
			return friend;
		}
		friend.setStatus("A");
		System.out.println("update before");
	sessionFactory.getCurrentSession().update(friend);
	System.out.println("update after");

	friend=get(requesterid,userid);
	return friend;
	}
	public List<Friend> getMyRequest(String id) {
String hql="from Friend where user_id='"+id+"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public List<Friend> getMyFriends(String id) {
		String hql1="select friend_id from Friend where user_id='"+id+"' and status='A'";
		String hql2="select user_id from Friend where friend_id='"+id+"' and status='A'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql1);
		Query query1=sessionFactory.getCurrentSession().createQuery(hql2);
		List<Friend>  list=query.list();
		List<Friend>  list1=query1.list();
		list.addAll(list1);
		return list;
	}
	public Friend rejectRequest(String uid, String fid) {
		if(get(fid,uid)==null){
			friend=new Friend();
			friend.setErrorCode("404");
			friend.setErrorMessage("do not use cache url");
			return friend;
		}
friend=get(fid,uid);
friend.setStatus("R");
sessionFactory.getCurrentSession().update(friend);
friend=get(fid,uid);
friend.setErrorCode("200");
friend.setErrorMessage("friend request rejected");
return friend;
	}
	public boolean delete(Friend friend) {
try {
	sessionFactory.getCurrentSession().delete(friend);
	return true;
} catch (HibernateException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;

}
	}
	

}
