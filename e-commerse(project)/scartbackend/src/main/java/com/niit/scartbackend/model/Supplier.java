package com.niit.scartbackend.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity//is used to map the table 
@Table(name="supplier")//name is not mandatory if class name equals table name also this annotation not need 
@Component//is used to create bean in the name supplier
public class Supplier implements Serializable{
	@Id
	@Size(min=1,max=20)
	@NotEmpty
	private String id;
	@Size(min=1,max=20)
	@NotEmpty
	private String name;
	@Size(min=1,max=100)
	@NotEmpty
	private String address;
	@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
	private Set<Product> product;
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
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



