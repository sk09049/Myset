package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Supplier;

public interface SupplierDao {

	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
	public List<Supplier> list();
}
