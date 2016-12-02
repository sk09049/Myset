package com.niit.scartbackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ordertable")
@Component
public class Order implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
private String id;
private String payment_mode;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPayment_mode() {
	return payment_mode;
}
public void setPayment_mode(String payment_mode) {
	this.payment_mode = payment_mode;
}
public String getCart_id() {
	return cart_id;
}
public void setCart_id(String cart_id) {
	this.cart_id = cart_id;
}
public String getBillingaddress_id() {
	return billingaddress_id;
}
public void setBillingaddress_id(String billingaddress_id) {
	this.billingaddress_id = billingaddress_id;
}
public String getShippingaddress_id() {
	return shippingaddress_id;
}
public void setShippingaddress_id(String shippingaddress_id) {
	this.shippingaddress_id = shippingaddress_id;
}

private String cart_id;
private String billingaddress_id;
private String shippingaddress_id;

	
}
