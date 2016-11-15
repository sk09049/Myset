package com.niit.scartbackend.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table (name="category") //if table name is same as class name we dont need give table name
@Component
public class Category {
	@Id
	@Max(20)
	@NotEmpty(message=" Category id must not  be empty & not more than 20 characters")
private String id;
	@Max(20)
	@NotEmpty(message=" Category name must not  be empty & not more than 20 characters")
	@Column(name="name")//optional if column name change we have to give that
private String name;
	@Max(20)
	@NotEmpty(message=" Category description must not  be empty & not more than 50characters")
	@Column(name="description")
private String description;
	/*@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Set<Product> product;
public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}*/
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}



}
