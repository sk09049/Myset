package com.niit.scart.exceptionhandler;

import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class Globalexceptionhandler {

@ExceptionHandler({CannotCreateTransactionException.class})
public ModelAndView exception(){
	ModelAndView mv=new ModelAndView("index");
	mv.addObject("exceptionhappened", "true");
	mv.addObject("exceptionerror", "contact administrator error to connect to db");
	return mv;
	
}
@ExceptionHandler(NullPointerException.class)
public String nullpointerexception(Model mod){
	mod.addAttribute("exceptionhappened", "true");
	mod.addAttribute("exceptionerror", "contact administrator & make sure you are not using catched url login properly");
	return "index";
}
}
