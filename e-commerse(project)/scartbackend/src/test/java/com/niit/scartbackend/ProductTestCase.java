package com.niit.scartbackend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.ProductDao;
import com.niit.scartbackend.model.Product;

public class ProductTestCase {
@Autowired
static AnnotationConfigApplicationContext context;
@Autowired
static Product product;
@Autowired
static ProductDao productdao;
@BeforeClass
public static void initial(){
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.scartbackend");
	context.refresh();
	productdao=(ProductDao)context.getBean("productDao");
	product=(Product) context.getBean("product");
}
/*@Test
public void createtestcase(){
	product.setId("ph04");
	product.setName("j");
	product.setDescription("it has some series");
	product.setPrice("7000");
	product.setCategory_id("CAT_37");
	product.setSupplier_id("sup01");
	String check=productdao.save(product);
	Assert.assertEquals("create test case","success",check);
}
@Test
public void updateTestCase(){
	product.setId("ph04");
	product.setName("j");
	product.setDescription("it has mp series");
	product.setPrice("7000");
	product.setCategory_id("CAT_37");
	product.setSupplier_id("sup01");
	String check=productdao.update(product);
	Assert.assertEquals("update test case","success",check);
	
}
@Test
public void testdelete(){
	product.setId("ph04");
	String check=productdao.delete(product);
	Assert.assertEquals("delete test","success",check);
}
@Test
public void checkIfThisIdExists(){
	Assert.assertEquals("check for exist",null,productdao.get("g"));

}/*/
//@Test
public void getcountofrows(){
	List <Product> product=productdao.listofproducts();
for(Product a:product){
	System.out.println(a);
}
	Assert.assertEquals("count check for rows",1,product.size());
}
@Test
public void top3search(){
	DateFormat date=new SimpleDateFormat("yyyy/MM/dd");
	Date currentdate=new Date();
	String todaydate=date.format(currentdate);
	List <Product> product=productdao.gettop3searches(todaydate);
	for(Product a:product){
		System.out.println(a.getId());
	}
	
}

}
