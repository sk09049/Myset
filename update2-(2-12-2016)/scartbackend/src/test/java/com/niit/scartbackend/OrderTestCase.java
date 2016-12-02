package com.niit.scartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.OrderDao;
import com.niit.scartbackend.model.Order;

public class OrderTestCase {
@Autowired
static AnnotationConfigApplicationContext context;
@Autowired
static Order order;
@Autowired
static OrderDao orderDao;

@BeforeClass
public  static void init(){
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.scartbackend");
	context.refresh();
	order=(Order) context.getBean("order");
	orderDao=(OrderDao) context.getBean("orderdao");
	}
@Test
public void save(){
	order.setId("o02");
	order.setCart_id("c01");
	order.setBillingaddress_id("bi02");
	order.setShippingaddress_id("ship02");
	order.setPayment_mode("cod");
	String check=orderDao.save(order);
	Assert.assertEquals("save test case","success",check);
}
@Test
public void update(){
	order.setId("o01");
	order.setCart_id("c01");
	order.setBillingaddress_id("bi02");
	order.setShippingaddress_id("ship02");
	order.setPayment_mode("netbanking");
	String check=orderDao.update(order);
	Assert.assertEquals("save test case","success",check);
	
}
@Test
public void listall(){
	Assert.assertEquals("row check",2,orderDao.listall().size());
}
@Test
public void get(){
	Assert.assertEquals("gettestcase",null,orderDao.get("imnothere"));
}
@Test
public void delete(){
	order.setId("o02");
	String check=orderDao.delete(order);
	Assert.assertEquals("delete test case","success",check);
}
}
