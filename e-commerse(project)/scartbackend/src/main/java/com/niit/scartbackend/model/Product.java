package com.niit.scartbackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
@Component
public class Product implements Serializable{
	@Id
	@NotEmpty
	@Size(min=1,max=20)
	private String id;
	private String date1;
	private int todayscount;
	@NotEmpty
	@Size(min=1,max=20)
	private String name;
	@NotEmpty
	@Size(min=1,max=17)
	private String price;

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@NotEmpty
	@Size(min=1,max=50)
	private String Description;
	@Size(min=1,max=20)
	private String category_id;
	@Size(min=1,max=20)
	private String supplier_id;
	@Transient
	private MultipartFile image;
public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
@ManyToOne
	@JoinColumn(name="category_id",updatable=false,insertable=false,nullable=false)
	private Category category;
	@ManyToOne
	@JoinColumn(name="supplier_id",updatable=false,insertable=false,nullable=false)
	private Supplier supplier;
	public String getCategory_id() {
		return category_id;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
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

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public int getTodayscount() {
		return todayscount;
	}
	public void setTodayscount(int todayscount) {
		this.todayscount = todayscount;
	}

}
