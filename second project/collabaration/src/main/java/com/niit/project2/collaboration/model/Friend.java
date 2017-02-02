package com.niit.project2.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="co_Friend")
@Component
public class Friend extends BaseDomain {
@Id
private int id;
private String friend_id;
private String user_id;
public String getFriend_id() {
	return friend_id;
}
public void setFriend_id(String friend_id) {
	this.friend_id = friend_id;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
private String status;//n-new request,r-rejected request,a-friends now
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
