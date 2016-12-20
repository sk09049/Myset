package com.niit.scart.webflow;

import java.io.Serializable;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.scartbackend.dao.BillingAddressDao;
import com.niit.scartbackend.dao.CartDao;
import com.niit.scartbackend.dao.OrderDao;
import com.niit.scartbackend.dao.ProductDao;
import com.niit.scartbackend.dao.ShippingaddressDao;
import com.niit.scartbackend.model.BillingAddress;
import com.niit.scartbackend.model.Cart;
import com.niit.scartbackend.model.Order;
import com.niit.scartbackend.model.Paymentdetails;
import com.niit.scartbackend.model.Product;
import com.niit.scartbackend.model.ShippingAddress;
@Component("flowlo")
public class flowlogic implements Serializable{
	Principal p;
@Autowired
BillingAddressDao billingaddressdao;
	@Autowired
	Paymentdetails paymentdetails;
	@Autowired
	ShippingaddressDao dao;
	@Autowired
	CartDao cartDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	Cart cart;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	private static final long serialVersionUID = 1L;
@Autowired
Order order;	
public Order initwebflow(){
	order=new Order();
	return order;
}
public String generatecod(Order order,ShippingAddress shippingAddress,
		BillingAddress billingAddress,Product obj,String quantity,String c){
	String[] d=c.split(",");
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	String id=dao.getshippingaddressid();
	String[] part = id.split("(?<=\\D)(?=\\d)");
int b=Integer.parseInt(part[1])+1;
String b1;
if(b>9){
	 b1="ship"+b;
	}else {
	b1="ship0"+b;
}
	shippingAddress.setId(b1);
	
	dao.saveshipaddrs(shippingAddress);
	System.out.println("start");
	String billid=billingaddressdao.getmaxbillingaddressid();
	String split[]=billid.split("(?<=\\D)(?=\\d)");
	int billidnopart=Integer.parseInt(split[1])+1;
	String finalbillid;
	if(billidnopart>9){
		finalbillid="bill"+billidnopart;
	}else{
		finalbillid="bill0"+billidnopart;
}
	billingAddress.setId(finalbillid);
	billingaddressdao.savebilladdrs(billingAddress);
	order.setShippingaddress_id(b1);
	order.setBillingaddress_id(finalbillid);
	order.setPayment_mode("cod");
if(quantity.equals("allnew")){
	List<Cart> cartdetails=cartDao.getlistofneworders(currentPrincipalName);
	String[] temp=new String[cartdetails.size()];
int i=0;
	for(Cart a:cartdetails){
	while(i<4){
	temp[i]=a.getId();
	break;
	}
	i++;
	}
	String cartid=Arrays.toString(temp);
	order.setCart_id(cartid);
	cartDao.updaten_as_p_inCarttable(currentPrincipalName);
	}else if(d[0].equals("cart")){
		cartDao.updatesinglecartid(cartidsingle);
		order.setCart_id(cartidsingle);
	}
else {
cart.setUser(currentPrincipalName);
String [] temp2=obj.getPrice().split("\\.");
cart.setPrice(Integer.parseInt(temp2[0]));
cart.setProduct_id(obj.getId());
cart.setProduct_name(obj.getName());
cart.setQuantity(quantity);
cart.setStatus("P");
String cartid=cartDao.maxId();
String[] splitcartid=cartid.split("(?<=\\D)(?=\\d)");
int cartidpart2=Integer.parseInt(splitcartid[1])+1;
String cardnewid;
if(cartidpart2>9){
	cardnewid="cart"+cartidpart2;
}else{
	cardnewid="cart0"+cartidpart2;	
}
cart.setId(cardnewid);
cartDao.save(cart);
order.setCart_id(cardnewid);
}
	
	
	String orderid=b1+finalbillid+"cod";
	order.setId(orderid);
orderDao.save(order);
	return"success";
}

//get price method
public Product getprice(String id){
	String [] array=id.split(",");
	if(array[0].equals("allnew")){
		return product;
	}else if(array[0].equals("cart")){
		Cart cart=cartDao.get(array[1]);
		product=productDao.get(cart.getProduct_id());
		return product;
	}
	else{
	product=productDao.get(array[0]);
	
	System.out.println(product.getName());
	return product;
	}
}
String cartidsingle;
//get quantity method
public String getquantity(String id){
	System.out.println("hi");

	String [] array=id.split(",");
	if(array[0].equals("allnew")){
		return "allnew";
	}else if(array[0].equals("cart")){
		cartidsingle=array[1];
		Cart cart=cartDao.get(array[1]);
		
		return cart.getQuantity();
	}
	else{
	return array[1];}
}
public String generatenet(Order order,
		ShippingAddress shippingAddress,BillingAddress billingAddress,Product obj,
		String quantity,String ca){
	String [] d=ca.split(",");
	
	String id=dao.getshippingaddressid();
	String[] part = id.split("(?<=\\D)(?=\\d)");
int b=Integer.parseInt(part[1])+1;
String b1;
if(b>9){
	 b1="ship"+b;
	}else {
	b1="ship0"+b;
}
	shippingAddress.setId(b1);
	
	dao.saveshipaddrs(shippingAddress);
	System.out.println("start");
	String billid=billingaddressdao.getmaxbillingaddressid();
	String split[]=billid.split("(?<=\\D)(?=\\d)");
	int billidnopart=Integer.parseInt(split[1])+1;
	String finalbillid;
	if(billidnopart>9){
		finalbillid="bill"+billidnopart;
	}else{
		finalbillid="bill0"+billidnopart;
}
	billingAddress.setId(finalbillid);
	billingaddressdao.savebilladdrs(billingAddress);
	order.setShippingaddress_id(b1);
	order.setBillingaddress_id(finalbillid);
	order.setPayment_mode("netbanking");	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	if(quantity.equals("allnew")){
		List<Cart> cartdetails=cartDao.getlistofneworders(currentPrincipalName);
		String[] temp=new String[cartdetails.size()];
	int i=0;
		for(Cart a:cartdetails){
		while(i<4){
		temp[i]=a.getId();
		break;
		}
		i++;
		}
		String cartid=Arrays.toString(temp);
		order.setCart_id(cartid);
		cartDao.updaten_as_p_inCarttable(currentPrincipalName);	
	}else if(d[0].equals("cart")){
		cartDao.updatesinglecartid(cartidsingle);
		order.setCart_id(cartidsingle);
	}
	else{
	
cart.setUser(currentPrincipalName);
System.out.println(obj.getPrice());
String [] temp2=obj.getPrice().split("\\.");
cart.setPrice(Integer.parseInt(temp2[0]));
cart.setProduct_id(obj.getId());
cart.setProduct_name(obj.getName());
cart.setQuantity(quantity);
cart.setStatus("P");
String cartid=cartDao.maxId();
String[] splitcartid=cartid.split("(?<=\\D)(?=\\d)");
int cartidpart2=Integer.parseInt(splitcartid[1])+1;
String cardnewid;
if(cartidpart2>9){
	cardnewid="cart"+cartidpart2;
}else{
	cardnewid="cart0"+cartidpart2;	
}
cart.setId(cardnewid);
cartDao.save(cart);
order.setCart_id(cardnewid);
	}
	String orderid=b1+finalbillid+"nb";
	order.setId(orderid);
orderDao.save(order);
	return "success";
}
}