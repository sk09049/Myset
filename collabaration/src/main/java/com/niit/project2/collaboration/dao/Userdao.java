package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.User;

public interface Userdao {
public String save(User user);
public String  update(User user);
public List<User> getlistofuser();
public User get(String id);
public String validate(String id,String password);
public String reasonforrejection(String id);
public List<User> listOfNewUser();
public List<User> list();
}
