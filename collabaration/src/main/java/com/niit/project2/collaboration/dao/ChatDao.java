package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.Chat;

public interface ChatDao {
public boolean save(Chat chat);
public List<Chat> list(String id);
public int getMaxid();
public Chat get(int id);
}
