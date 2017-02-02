package com.niit.project2.colloboration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LandingController {
	public static Logger log=LoggerFactory.getLogger(LandingController.class);
	@RequestMapping("/")
	public String showlandingpage(){
		log.debug("landing page started");
		System.out.println("hi");
		return "index";
	}
}
