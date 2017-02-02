
package com.niit.project2.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="co_blog_comment")
@Component
public class BlogComment extends BaseDomain{
@Id
private int id;
private int blog_id;
private String comments;
private String user_id;
private String comment_time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBlog_id() {
	return blog_id;
}
public void setBlog_id(int blog_id) {
	this.blog_id = blog_id;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getComment_time() {
	return comment_time;
}
public void setComment_time(String comment_time) {
	this.comment_time = comment_time;
}

}
