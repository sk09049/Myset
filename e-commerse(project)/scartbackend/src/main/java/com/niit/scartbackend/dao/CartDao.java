package com.niit.scartbackend.dao;

import java.io.Serializable;
import java.util.List;

import com.niit.scartbackend.model.Cart;

public interface CartDao extends Serializable {
public boolean save (Cart cart);
public boolean update (Cart cart);
public boolean delete (Cart cart);
public Cart get(String id);
public List<Cart> listofrows();
public String maxId();
public int getcartcount(String id);
public List<Cart> getallcartforcurrentuser(String id);
public String gettotalofneworders(String id);
public List<Cart> getlistofneworders(String id);
public void updaten_as_p_inCarttable(String id);
public void updatesinglecartid(String id);
}