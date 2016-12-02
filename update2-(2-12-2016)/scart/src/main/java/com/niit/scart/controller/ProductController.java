package com.niit.scart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.scart.util.FileUtil;
import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.dao.ProductDao;
import com.niit.scartbackend.model.Category;
import com.niit.scartbackend.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productdao;
	@Autowired
	CategoryDao categorydao;
	private String path="/home/saravana/workspace2/scart/src/main/webapp/WEB-INF/images";
@RequestMapping("/addproduct")
public String addcategory(@ModelAttribute ("addproduct") Product product,@RequestParam("image") MultipartFile file,Model mod,HttpSession session){
	productdao.save(product);
	String status=FileUtil.upload(path, file,product.getId()+".jpg");
	System.out.println(status);
	mod.addAttribute("showpro","true");
	List<Category> list=categorydao.list();
	session.setAttribute("list",list);
mod.addAttribute("pro",new Product());
	return"index";
}
@RequestMapping("product/{id}")
public String showproduct(@PathVariable("id") String id,Model mod,RedirectAttributes redir){
Product product =productdao.get(id);
redir.addFlashAttribute("productdescription",product);
return "redirect:/showsingleproduct1";
}
@RequestMapping("/showsingleproduct1")
public String showsingleproduct(Model mod){
	mod.addAttribute("showsingleproduct","true");
	return "index";
}
}
