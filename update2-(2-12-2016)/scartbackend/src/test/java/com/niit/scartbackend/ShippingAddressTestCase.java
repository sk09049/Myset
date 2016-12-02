package com.niit.scartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.ShippingaddressDao;
import com.niit.scartbackend.model.ShippingAddress;

public class ShippingAddressTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static ShippingAddress shipaddrs;
	@Autowired
	static ShippingaddressDao shipaddrsdao;
	@BeforeClass
	public static void initial(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();
		shipaddrs=(ShippingAddress) context.getBean("shippingAddress");
		shipaddrsdao=(ShippingaddressDao) context.getBean("shipaddrsdao");
	}
	/*@Test
	public void savetest(){
		shipaddrs.setId("ship01");
		shipaddrs.setDoorno("1/5A");
		shipaddrs.setStreet("north");
		shipaddrs.setCity("tambaram");
		shipaddrs.setPincode("896547");
		shipaddrs.setCountry("india");
		boolean status=shipaddrsdao.saveshipaddrs(shipaddrs);
		Assert.assertEquals("save test",true,status);
	}
	@Test
	public void updatetest(){
		shipaddrs.setId("ship02");
		shipaddrs.setDoorno("1/5A");
		shipaddrs.setStreet("west");
		shipaddrs.setCity("tambaram");
		shipaddrs.setPincode("896547");
		shipaddrs.setCountry("india");
		boolean status=shipaddrsdao.Updateshipaddrs(shipaddrs);
		Assert.assertEquals("save test",true,status);
	}
	@Test
	public void deletetest(){
		shipaddrs.setId("ship01");
	boolean status=shipaddrsdao.deleteshipaddrs(shipaddrs);
	Assert.assertEquals("delete status",true,status);
		}
	@Test 
	public void checkrowexists(){
	Assert.assertEquals(null,shipaddrsdao.get("lo"));	
	}
	@Test
	public void getlist(){
		Assert.assertEquals(2,shipaddrsdao.listofAddresses().size());
	}*/

	@Test
	public void check(){
	String a=shipaddrsdao.getshippingaddressid();
	String[] part = a.split("(?<=\\D)(?=\\d)");
String b=part[1];
System.out.println(b);
	}
}
