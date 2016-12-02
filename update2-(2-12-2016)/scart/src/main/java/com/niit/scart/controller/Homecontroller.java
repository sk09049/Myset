package com.niit.scart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.dao.ProductDao;
import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.model.Category;
import com.niit.scartbackend.model.Product;
import com.niit.scartbackend.model.Supplier;
import com.niit.scartbackend.model.User;
@Controller
public class Homecontroller {
	@Autowired
	CategoryDao categorydao;
	@Autowired
	ProductDao productdao;
	@Autowired
	Category category;
	@Autowired
	SupplierDao suppplierdao;
	@RequestMapping("/register")
	public ModelAndView register(Model mod){
		mod.addAttribute("check4","true");
		return new ModelAndView ("index","reg",new User());
	}


@RequestMapping("/product")
public ModelAndView product(Model mod,HttpSession session){
	mod.addAttribute("product","true");
	List<Supplier> supplierlist=suppplierdao.list();
	session.setAttribute("supplierlist",supplierlist);
	return new ModelAndView("index","pro",new Product());
}
@RequestMapping("/supply")
public ModelAndView supply(Model mod){
	mod.addAttribute("supply","true");
	return new ModelAndView("index","supplier",new Supplier());
}
	
	@RequestMapping("/")
public String home(Model mod,HttpSession session){
		mod.addAttribute("ch","true");
		List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		System.out.println("hi");
		return "index";
		
	}

	@RequestMapping("/category")
	public ModelAndView category(Model mod,HttpSession session){
		mod.addAttribute("check5","true");
		List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		return new ModelAndView ("index","cat",new Category());
	}
	

	@RequestMapping("/mycart")
	public String mycart(Model mod){
		mod.addAttribute("msg1","this is your cart");
	
       return "index";
	}
	@RequestMapping("/aboutus")
	public String aboutus(Model mod){
		mod.addAttribute("msg2","about us");
	
       return "index";
	}
	@RequestMapping("/home")
	public String Home(Model mod){
		mod.addAttribute("home","true");
		return "index";
	}
	
	}

