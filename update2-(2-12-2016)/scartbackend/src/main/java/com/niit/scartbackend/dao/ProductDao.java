package com.niit.scartbackend.dao;

import java.util.List;

import com.niit.scartbackend.model.Product;

public interface ProductDao {
	public String save(Product product);
	public String update(Product product);
	public String delete(Product product);
	public Product get(String id);
public List<Product> listofproducts();

}
