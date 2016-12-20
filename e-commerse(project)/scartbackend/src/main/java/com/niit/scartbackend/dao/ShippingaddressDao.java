package com.niit.scartbackend.dao;

import java.io.Serializable;
import java.util.List;

import com.niit.scartbackend.model.ShippingAddress;

public interface ShippingaddressDao extends Serializable{
	public boolean saveshipaddrs(ShippingAddress address);
	public boolean Updateshipaddrs(ShippingAddress address);
	public boolean deleteshipaddrs(ShippingAddress address);
	public ShippingAddress get(String id);
	public List<ShippingAddress> listofAddresses();
public String getshippingaddressid();
}
