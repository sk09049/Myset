package com.niit.scartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.model.Supplier;

public class SupplierTestCase {
@Autowired
static AnnotationConfigApplicationContext context;
@Autowired
static Supplier supplier;
@Autowired
static SupplierDao supplierdao;
@BeforeClass
public static void initial(){
	context= new AnnotationConfigApplicationContext();
	context.scan("com.niit.scartbackend");
	context.refresh();
	supplierdao= (SupplierDao)context.getBean("SupplierDao");
	supplier=(Supplier) context.getBean("supplier");
	
}
/*@Test
public void createtestcase (){
	supplier.setId("sup01");
	supplier.setName("ltc");
	supplier.setAddress("tambaram,chennai");
	boolean status=supplierdao.save(supplier);
	Assert.assertEquals("create test",true,status);
}
@Test
public void deletetest(){
	supplier.setId("ph5");
	boolean status=supplierdao.delete(supplier);
	Assert.assertEquals("delete test",true,status);
}
@Test
public void updatetest(){
	supplier.setId("sup01");
	supplier.setName("itc");
	supplier.setAddress("anyarea,mumbai");
	boolean status=supplierdao.update(supplier);
	Assert.assertEquals("update test",true,status);
}
@Test
public void checkIfThisIdExists(){
	Assert.assertEquals("check for exist",null,supplierdao.get("g"));
}
@Test
public void noofrowcheck(){
	Assert.assertEquals("row check",1,supplierdao.list().size());
}*/
}

