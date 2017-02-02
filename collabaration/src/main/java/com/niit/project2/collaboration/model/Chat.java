package com.niit.project2.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="co_chat")
@Component
public class Chat extends BaseDomain {
@Id
private int id;
private String msg_senderId;
private String msg_recieverId;
private Date time;
private String message;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMsg_senderId() {
	return msg_senderId;
}
public void setMsg_senderId(String msg_senderId) {
	this.msg_senderId = msg_senderId;
}
public String getMsg_recieverId() {
	return msg_recieverId;
}
public void setMsg_recieverId(String msg_recieverId) {
	this.msg_recieverId = msg_recieverId;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
