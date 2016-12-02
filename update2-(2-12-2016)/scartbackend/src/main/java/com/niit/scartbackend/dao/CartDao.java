package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Cart;

public interface CartDao {
public boolean save (Cart cart);
public boolean update (Cart cart);
public boolean delete (Cart cart);
public Cart get(String id);
public List<Cart> listofrows();

}