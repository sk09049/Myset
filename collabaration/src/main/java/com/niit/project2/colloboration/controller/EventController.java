package com.niit.project2.colloboration.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.project2.collaboration.dao.EventDao;
import com.niit.project2.collaboration.model.Event;

@RestController
public class EventController {
	
	@Autowired
	Event event;
	@Autowired
	EventDao eventdao;
	
@RequestMapping("/saveevent")
public ResponseEntity<Event> saveEvent(@RequestBody Event event){
	System.out.println(event.getDate_time());
	event.setId(eventdao.getMaxId()+1);
	boolean status=eventdao.saveEvent(event);
	if(status==true){
	event.setErrorMessage("successfully saved");
		event.setErrorCode("200");
	}else{
		event.setErrorMessage("error while saving");
		event.setErrorCode("404");
	}
	
	return new ResponseEntity<Event>(event,HttpStatus.OK);
}
@RequestMapping("/eventlist")
public ResponseEntity<List<Event>> getEventList(){
	List<Event> list=eventdao.list();
	System.out.println(list);
	if(list.isEmpty()){
		event.setErrorCode("404");
		event.setErrorMessage("no events are there");
		list.add(event);
	}
	return new ResponseEntity<List<Event>>(list,HttpStatus.OK);
}

}
