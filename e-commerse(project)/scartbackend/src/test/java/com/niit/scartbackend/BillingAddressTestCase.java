package com.niit.scartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.BillingAddressDao;
import com.niit.scartbackend.model.BillingAddress;


public class BillingAddressTestCase {
@Autowired
static AnnotationConfigApplicationContext context;
@Autowired
static BillingAddress billaddrs;
@Autowired
static BillingAddressDao billaddrsdao;
@BeforeClass
public static void initial(){
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.scartbackend");
	context.refresh();
	billaddrs=(BillingAddress) context.getBean("billingAddress");
	billaddrsdao=(BillingAddressDao) context.getBean("billaddrsdao");
}
/*@Test
public void savetest(){
	billaddrs.setId("bi01");
	billaddrs.setDoorno("1/5A");
	billaddrs.setStreet("north");
	billaddrs.setCity("tambaram");
	billaddrs.setPincode("896547");
	billaddrs.setCountry("india");
	boolean status=billaddrsdao.savebilladdrs(billaddrs);
	Assert.assertEquals("save test",true,status);
}
@Test
public void updatetest(){
	billaddrs.setId("bi01");
	billaddrs.setDoorno("1/5A");
	billaddrs.setStreet("south");
	billaddrs.setCity("tambaram");
	billaddrs.setPincode("896547");
	billaddrs.setCountry("india");
	boolean status=billaddrsdao.Updatebilladdrs(billaddrs);
	Assert.assertEquals("save test",true,status);
}
@Test
public void deletetest(){
	billaddrs.setId("bi01");
boolean status=billaddrsdao.deletebilladdrs(billaddrs);
Assert.assertEquals("delete status",true,status);
	}
@Test 
public void checkrowexists(){
Assert.assertEquals(null,billaddrsdao.get("lo"));	
}
@Test
public void getlist(){
	Assert.assertEquals(3,billaddrsdao.listofAddresses().size());
}*/
@Test
public void test(){
String as=billaddrsdao.getmaxbillingaddressid();
System.out.println(as);
}

}
