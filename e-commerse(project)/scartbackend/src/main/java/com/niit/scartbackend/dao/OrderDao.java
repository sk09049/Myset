package com.niit.scartbackend.dao;

import java.io.Serializable;
import java.util.List;

import com.niit.scartbackend.model.Order;

public interface OrderDao extends Serializable{
	public String save(Order order);
	public String update(Order order);
	public String delete(Order order);
    public Order get(String id);
    public List<Order> listall();

}
