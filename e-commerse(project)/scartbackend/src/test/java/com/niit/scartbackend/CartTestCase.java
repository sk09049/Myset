package com.niit.scartbackend;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
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
//@Test
public void getmaxid(){
	System.out.println(cartDao.maxId());
}
//@Test
public void getcount(){
	System.out.println(cartDao.getcartcount("sk09049@gmail.com"));
}
//@Test
public void getnewlist(){
	List<Cart> cartdetails=cartDao.getlistofneworders("sk09049@gmail.com");
	String[] temp=new String[cartdetails.size()];
int i=0;
	for(Cart a:cartdetails){
	while(i<4){
	temp[i]=a.getId();
	break;
	}
	System.out.println(temp[i]);
	i++;
	
}
	String cartid=Arrays.toString(temp);
	System.out.println(cartid);

}
//@Test
public void simpletest(){
	cartDao.updaten_as_p_inCarttable("sk09049@gmail.com");
}
@Test
public void totaltest(){
	DateFormat date=new SimpleDateFormat("yyyy/MM/dd");
	Date currentdate=new Date();
	String a=date.format(currentdate);
	System.out.println(a);

	String total=cartDao.gettotalofneworders("sk09049@gmail.com");
	System.out.println(total);
}
}