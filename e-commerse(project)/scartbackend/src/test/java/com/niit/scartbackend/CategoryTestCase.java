package com.niit.scartbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.model.Category;

public class CategoryTestCase {

	@Autowired
	 static AnnotationConfigApplicationContext context;
	@Autowired
	 static Category category;
	@Autowired
	static CategoryDao categoryDAO;
	@BeforeClass
	public  static void initial(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();
		categoryDAO= (CategoryDao)context.getBean("CategoryDao");
		category=(Category) context.getBean("category");
	}
	//@Test
	public void createtestcase (){
		category.setId("7kl");
		category.setName("uy");
		category.setDescription("its  category");
		String status=categoryDAO.save(category);
		Assert.assertEquals("create test","added",status);
		
	}
//@Test
public void deletetest(){
	category.setId("ph2");
	
	boolean status=categoryDAO.delete(category);
	Assert.assertEquals("delete test",true,status);
}
@Test
public void updatetest(){
category.setId("cat09");
category.setName("hello1l");
category.setDescription("its boss category");
String status =categoryDAO.update(category);
Assert.assertEquals("update test","updated",status);
}
//@Test
public void getcategorytest(){
	Assert.assertEquals("get category test",null,categoryDAO.get("h"));
}
//@Test 
public void getAllcategoriestest(){
	Assert.assertEquals("getAll category test",9,categoryDAO.list().size());
	}

}
