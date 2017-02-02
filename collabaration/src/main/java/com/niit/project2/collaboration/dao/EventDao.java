package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.Event;

public interface EventDao {
public boolean saveEvent(Event event);
public List<Event> list();
public Event get(int id);
public int getMaxId();
}
