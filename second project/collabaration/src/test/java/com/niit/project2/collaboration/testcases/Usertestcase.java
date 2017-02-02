package com.niit.project2.collaboration.testcases;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project2.collaboration.dao.Userdao;
import com.niit.project2.collaboration.model.User;

public class Usertestcase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static User user;
	@Autowired
	static Userdao userdao;
	
	@BeforeClass
	public static void initial(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.project2.collaboration");
		context.refresh();
		user=(User) context.getBean("user");
		userdao=(Userdao) context.getBean("userdao");
		
	}
	@Test
	public void savetest(){
		user.setId("02");
		user.setName("ram");
		user.setEmail("saravan@gmail.com");
		user.setAddress("north street,elandaikudam");
		user.setIs_online('N');
		user.setMobile("98765432120");
		user.setPassword("123456");
		user.setRole("student");
		user.setStatus('W');
		user.setErrorCode("200");
		user.setErrorMessage("saved ");
		userdao.save(user);
	}

}
