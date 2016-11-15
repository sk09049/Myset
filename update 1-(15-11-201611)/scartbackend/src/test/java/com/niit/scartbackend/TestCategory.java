package com.niit.scartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCategory {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend.model");
		context.refresh();
		context.getBean("product");
		System.out.println("yes12");

	}

}
