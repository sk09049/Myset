package com.niit.scartbackend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity//is used to map the table 
@Table(name="supplier")//name is not mandatory if class name equals table name also this annotation not need 
@Component//is used to create bean in the name supplier
public class Supplier {
	@Id
	private String id;
	private String name;
	private String address;
	/*@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
	private Set<Product> product;
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}*/
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}



