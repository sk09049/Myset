package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.User;

public interface UserDao {
	
public String saveuserdetails(User user);
public boolean updateuserdetails(User user);
public boolean deleteUserdtails(User user);
public User get(String user);
public List<User> list();
public List<User> userValidation(String id,String password);
public List<User> adminValidation(String id,String password);
}
