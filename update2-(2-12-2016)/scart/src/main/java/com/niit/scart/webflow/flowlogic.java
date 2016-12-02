package com.niit.scart.webflow;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.scartbackend.dao.ShippingaddressDao;
import com.niit.scartbackend.model.Order;
import com.niit.scartbackend.model.ShippingAddress;
@Component("flowlo")
public class flowlogic implements Serializable{
/**
	 * 
	 */
	@Autowired
	ShippingaddressDao dao;
	private static final long serialVersionUID = 1L;
@Autowired
Order order;	
public Order initwebflow(){
	System.out.println("ok ok");
	order=new Order();
	return order;
}
public String addShippinAddress(Order order,ShippingAddress shippingAddress){
	String id=dao.getshippingaddressid();
	String[] part = id.split("(?<=\\D)(?=\\d)");
int b=Integer.parseInt(part[1])+1;
String b1;
if(b>9){
	 b1="ship"+b;
	}else {
	b1="ship0"+b;
}
	order.setShippingaddress_id(b1);
	shippingAddress.setId(b1);
	
	dao.saveshipaddrs(shippingAddress);
	System.out.println("start");
	return "success";
}
}
