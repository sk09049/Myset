package com.niit.scart.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
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
	public static Logger log=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductDao productdao;
	@Autowired
	CategoryDao categorydao;
	private String path="/home/saravana/workspace2/scart/src/main/webapp/WEB-INF/images";
@RequestMapping("/adminaddproduct")
public String addproduct(@ModelAttribute ("addproduct") Product product,@RequestParam("image") MultipartFile file,Model mod,HttpSession session){
	log.debug("added to products started");
	String addstatus=productdao.save(product);
	if(addstatus.equals("success")){
		mod.addAttribute("savestatus","Successfully new Product Added");
	
	}if(addstatus.equals("primary key already exists")){
		mod.addAttribute("savestatus","Sorry you are not allowed to change the product Id");
		
	}if(addstatus.equals("exception")){
		mod.addAttribute("savestatusimage","Sorry some exception happens while adding neww product report us");
		
	}
	String status;
	try {
		status = FileUtil.upload(path, file,product.getId()+".jpg");
	} catch (Exception e) {
		mod.addAttribute("savestatus","Sorry Some Exeception happens Saving the Image Report Us");
		e.printStackTrace();
	}
	mod.addAttribute("showpro","true");
	List<Category> list=categorydao.list();
	session.setAttribute("list",list);
mod.addAttribute("pro",new Product());
log.debug("added to products ended");
	return"index";
}
@RequestMapping("product{id}")
public String showproduct(@PathVariable("id") String id,Model mod,RedirectAttributes redir){
Product product =productdao.get(id);
String tabledate=productdao.getdate(id);
DateFormat date=new SimpleDateFormat("yyyy/MM/dd");
Date currentdate=new Date();
String todaydate=date.format(currentdate);
if(tabledate.equals(todaydate)){
	String temp=productdao.getcount(id);
	int count=Integer.parseInt(temp)+1;
	productdao.setcount(count, id);
}else{
	productdao.setdate(todaydate, id);
	productdao.setcount(1, id);
}
mod.addAttribute("productdescription",product);

mod.addAttribute("showsingleproduct","true");

return "index";
}
@RequestMapping("/adminupdateproduct")
public String Updateproduct(Model mod){
	List<Product> productlist=productdao.listofproducts();
	mod.addAttribute("productlist",productlist );
	mod.addAttribute("showallproducts","true");
	return "index";
}
@RequestMapping("adminupdateproducts{id}")
public String productupdateindb(@PathVariable("id") String id,Model mod){
	Product product=productdao.get(id);
	mod.addAttribute("singlerowdetailofproduct",product);
	mod.addAttribute("showeditproductpage","true");
	return "index";
}
@RequestMapping("/adminsubmitupdatedetails")
public String submittheproductdetails(@ModelAttribute("product") Product product,Model mod,HttpSession session){
String status=productdao.update(product);
if(status.equals("no such records")){
	mod.addAttribute("productupdatestatus","Sorry changing product id is not allowed");
}
if(status.equals("success")){
	mod.addAttribute("productupdatestatus","Successfully Product Details Updated");
}
if(status.equals("exception")){
	mod.addAttribute("productupdatestatus","Sorry some exception happened while updating product,Contact us");

}
List<Category> list=categorydao.list();
session.setAttribute("list",list);
mod.addAttribute("pro",new Product());
mod.addAttribute("showpro","true");
	return "index";
}
@RequestMapping("/adminupdateimaage{id}")
public String updateimage(@PathVariable("id") String id,Model mod){
mod.addAttribute("updateimage",id);
mod.addAttribute("showeditproductpage","true");
	return "index";
}
@RequestMapping("adminupdateselectedimage{id}")
public String updateimage(@PathVariable("id") String id,@RequestParam("image") MultipartFile file,Model mod){
	String status=FileUtil.upload(path,file,id+".jpg");
	if(status.equals("true")){
		mod.addAttribute("imageupdate","Successfully image Updated,if image not Changing Refresh ");	
	
	}if(status.equals("true")){
		mod.addAttribute("imageupdate","Sorry some exception happens while updating image Contact us");	
	
	}if(status.equals("true")){
		mod.addAttribute("imageupdate","Sorry some problem occurs Updating the image Contact us");	
		
	}
	System.out.println(status);
	List<Product> productlist=productdao.listofproducts();
	mod.addAttribute("productlist",productlist );
	mod.addAttribute("showallproducts","true");	
	return "index";
}
@RequestMapping("/admindeleteproduct{id}")
public String deleteproduct(Model mod,@PathVariable("id") String id,HttpSession session){
	log.debug("product deleteing started");
	String statusdelete=productdao.delete(productdao.get(id));
	if(statusdelete.equals("success")){
		mod.addAttribute("deletestatus","Successfully the Product Details deleted" );
	
	}if(statusdelete.equals("exception")){
		mod.addAttribute("deletestatus","Sorry some exception happened while deleting product,Contact us" );		
	}
	try {
		String pathvalue=path+"/"+id+".jpg";
		System.out.println(pathvalue);
		File file = new File(pathvalue);
		boolean status=file.delete();
		System.out.println(status);
	} catch (Exception e) {
		mod.addAttribute("deletestatusimage","Sorry some exception happened while deleting Image,Contact us" );		
		e.printStackTrace();
	}
	List<Category> list=categorydao.list();
	session.setAttribute("list",list);
	List<Product> productlist=productdao.listofproducts();
	mod.addAttribute("productlist",productlist );
	mod.addAttribute("showallproducts","true");
	log.debug("added to products ends");
	return "index";
}
}
