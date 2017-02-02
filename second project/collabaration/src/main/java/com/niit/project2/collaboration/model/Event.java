package com.niit.project2.collaboration.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="co_event")
@Component
public class Event extends BaseDomain {
@Id
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String eventTitle;

public String getEventTitle() {
	return eventTitle;
}
public void setEventTitle(String eventTitle) {
	this.eventTitle = eventTitle;
}
public String getEventDescription() {
	return eventDescription;
}
public void setEventDescription(String eventDescription) {
	this.eventDescription = eventDescription;
}
public Date getDate_time() {
	return date_time;
}
public void setDate_time(Date date_time) {
	this.date_time = date_time;
}
private Date date_time;
private String eventDescription;

}
