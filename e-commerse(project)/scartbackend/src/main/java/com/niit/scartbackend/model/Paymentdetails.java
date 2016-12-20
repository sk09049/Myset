package com.niit.scartbackend.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Paymentdetails implements Serializable{

	private static final long serialVersionUID = 1L;
private String paymentmethod;
public String getPaymentmethod() {
	return paymentmethod;
}
public void setPaymentmethod(String paymentmethod) {
	this.paymentmethod = paymentmethod;
}


}
