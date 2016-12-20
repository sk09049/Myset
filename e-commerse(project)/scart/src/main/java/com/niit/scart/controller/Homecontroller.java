package com.niit.scart.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.scartbackend.dao.CartDao;
import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.dao.ProductDao;
import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.dao.UserDao;
import com.niit.scartbackend.model.Category;
import com.niit.scartbackend.model.Product;
import com.niit.scartbackend.model.Supplier;
import com.niit.scartbackend.model.User;
@Controller
public class Homecontroller {
	public static Logger log=LoggerFactory.getLogger(Homecontroller.class);
	@Autowired
	CategoryDao categorydao;
	@Autowired
	ProductDao productdao;
	@Autowired
	Category category;
	@Autowired
	SupplierDao suppplierdao;
	@Autowired
	CartDao cartdao;
	@Autowired
	UserDao userdao;
	@RequestMapping("/register")
	public ModelAndView register(Model mod){
		mod.addAttribute("check4","true");
		return new ModelAndView ("index","reg",new User());
	}


@RequestMapping("/adminproduct")
public ModelAndView product(Model mod,HttpSession session){
	log.debug("opening of product jsp page");
	mod.addAttribute("product1","true");
	List<Supplier> supplierlist=suppplierdao.list();
	session.setAttribute("supplierlist",supplierlist);
	
	return new ModelAndView("index","pro",new Product());
}

	
	@RequestMapping("/")
public String home(Model mod,HttpSession session){
		log.debug("landing page opening");
		DateFormat date=new SimpleDateFormat("yyyy/MM/dd");
		Date currentdate=new Date();
		String todaydate=date.format(currentdate);
		List<Product> top3=productdao.gettop3searches(todaydate);
		mod.addAttribute("top3",top3);
		mod.addAttribute("ch","true");
		List<Category> list=categorydao.list();
		List<User> userlist=userdao.list();
		session.setAttribute("userlist",userlist);
		session.setAttribute("list",list);
		log.debug("landing page opened successfully");
		return "index";
		
	}
	@RequestMapping("/index")
public String index(Model mod,HttpSession session,Principal p){
		mod.addAttribute("userlogcheck","true");
		List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		int count=cartdao.getcartcount(p.getName());
		session.setAttribute("cartcount",count);
		log.debug("return to landing page after purchase");
		return "index";
		
	}
	@RequestMapping("/adminsupply")
	public ModelAndView supply(Model mod){
		mod.addAttribute("supply","true");
		log.debug("opening of supplier jsp page");	
		return new ModelAndView("index","supplier",new Supplier());
	}

	@RequestMapping("/admincategory")
	public ModelAndView category(Model mod,HttpSession session){
		log.debug("opening of category jsp page");
		mod.addAttribute("showcat","true");
		return new ModelAndView ("index","cat",new Category());
	}
	@RequestMapping("/aboutus")
	public String aboutus(Model mod){
		mod.addAttribute("aboutus","true");
		
	
       return "index";
	}
	@RequestMapping("/home")
	public String Home(Model mod){
		DateFormat date=new SimpleDateFormat("yyyy/MM/dd");
		Date currentdate=new Date();
		String todaydate=date.format(currentdate);
		List<Product> top3=productdao.gettop3searches(todaydate);
		mod.addAttribute("top3",top3);
		mod.addAttribute("home","true");
		return "index";
	}
	
	@RequestMapping("/submitsearch")
	public String search(Model mod,@RequestParam("searchvalue") String searchvalue){
		if(searchvalue.equals("")){
			mod.addAttribute("searchvalue",searchvalue);
			mod.addAttribute("message", "enter some keyword");
			return "index";
		}
		List<Product> product=productdao.search(searchvalue);
		if(product.size()==0){
			mod.addAttribute("searchvalue",searchvalue);
			mod.addAttribute("message","try with some other key word");
			return "index";
		}else {	
			mod.addAttribute("searchvalue",searchvalue);
		mod.addAttribute("serachlist",product);
		return "index";

		}
	}
	@RequestMapping("/adimage")
	public String adimage(){
		return "add";
	}
	@RequestMapping("/acessdenied")
	public String accessdenied(RedirectAttributes redir){
		redir.addFlashAttribute("denied", "true");
		return "redirect:/returntoacessdenied";
	}
	@RequestMapping("/returntoacessdenied")
	public String indexagain(){
		return "index";
	}
	}

