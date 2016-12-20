package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Supplier;

public interface SupplierDao {

	public String save(Supplier supplier);
	public String update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
	public List<Supplier> list();
}
