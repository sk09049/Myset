package com.niit.scartbackend;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.CartDao;
import com.niit.scartbackend.model.Cart;

public class CartTestCase {
@Autowired
 static AnnotationConfigApplicationContext context;
@Autowired
static Cart cart;
@Autowired
static CartDao cartDao;
@BeforeClass
public  static  void  init(){
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.scartbackend");
	context.refresh();
	cart=(Cart) context.getBean("cart");
	cartDao=(CartDao) context.getBean("cartdao");
}
/*@Test
public void save(){
	cart.setId("c01");
	cart.setProduct_id("p01");
	cart.setQuantity("2");
	cart.setPrice("7500");
	Boolean status=cartDao.save(cart);
	Assert.assertEquals("save test case",true,status);
}
@Test
public void update(){
	cart.setId("c01");
	cart.setProduct_id("p01");
    cart.setQuantity("1");
	cart.setPrice("7500");
	Boolean status=cartDao.update(cart);
	Assert.assertEquals(" updated test case",true,status);

}
@Test
public void delete(){
	cart.setId("c01");
	Boolean status=cartDao.delete(cart);
	Assert.assertEquals(" updated test case",true,status);
	}
@Test
public void get(){
	Assert.assertEquals("get test case",null,cartDao.get("lo"));	

}
@Test
public void list(){
	Assert.assertEquals("get row count",1,cartDao.listofrows().size());	

}*/

}
