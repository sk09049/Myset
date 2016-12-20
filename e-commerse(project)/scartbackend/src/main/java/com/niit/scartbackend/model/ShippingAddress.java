package com.niit.scartbackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class ShippingAddress implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
private String id;
private String name;
private String doorno;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDoorno() {
	return doorno;
}
public void setDoorno(String doorno) {
	this.doorno = doorno;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private String street;
private String city;
private String pincode;
private String country;

}
