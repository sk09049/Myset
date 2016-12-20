package com.niit.scartbackend.dao;

import java.io.Serializable;
import java.util.List;

import com.niit.scartbackend.model.Product;

public interface ProductDao extends Serializable{
	public String save(Product product);
	public String update(Product product);
	public String delete(Product product);
	public Product get(String id);
public List<Product> listofproducts();
public List<Product> search(String id);
public String getdate(String id);
public String getcount(String id);
public String setdate(String date,String id);
public String setcount(int count,String id);
public List<Product> gettop3searches(String date);
}
