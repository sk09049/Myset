package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.BillingAddress;

public interface BillingAddressDao {
	public boolean savebilladdrs(BillingAddress address);
	public boolean Updatebilladdrs(BillingAddress address);
	public boolean deletebilladdrs(BillingAddress address);
	public BillingAddress get(String id);
	public List<BillingAddress> listofAddresses();

}
