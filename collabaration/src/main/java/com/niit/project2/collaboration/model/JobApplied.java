package com.niit.project2.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="co_job_applied")
@Component
public class JobApplied extends BaseDomain{
@Id
private String id;
private String job_id;
private String status;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getJob_id() {
	return job_id;
}
public void setJob_id(String job_id) {
	this.job_id = job_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public Date getDate_applied() {
	return date_applied;
}
public void setDate_applied(Date date_applied) {
	this.date_applied = date_applied;
}
private String remarks;
private String user_id;
private Date date_applied;
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
}
