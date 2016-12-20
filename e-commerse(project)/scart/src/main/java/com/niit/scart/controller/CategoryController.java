package com.niit.scart.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.model.Category;

@Controller
public class CategoryController {
	public static Logger log=LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	CategoryDao categorydao;
	@Autowired
	Category category;
	@RequestMapping("/adminaddcategory")
	public ModelAndView addCategory(@ModelAttribute("add") Category category,Model mod,HttpSession session){
		log.debug(" new category added starts");
	String categoryexists=	categorydao.save(category);
	if(categoryexists.equals("idexist")){
		mod.addAttribute("idexist","true");
		}
	if(categoryexists.equals("added")){
		mod.addAttribute("added","true");
		}
	if(categoryexists.equals("exception")){
		mod.addAttribute("exception","true");
		}
	
		List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		mod.addAttribute("showcat","true");
		log.debug(" new category added ends");

		return new ModelAndView ("index","cat",new Category());
		
	}
	@RequestMapping("adminupdatecategory")
	public String updateCategory(@ModelAttribute("updatecat") Category category,Model mod,HttpSession session){
  log.debug("update category in categorycontroller method starts");
String status=categorydao.update(category);
	if(status.equals("idNotExists")){
		mod.addAttribute("updatecategoryresult","Sorry ,You are Not Allowed To Change the Id values ");
	}else if(status.equals("updated")){
		mod.addAttribute("updatecategoryresult","Successfully Updated Category");
	}else if(status.equals("exception")){
		mod.addAttribute("updatecategoryresult","Sorry,some Exception happens report us ");
	}
	mod.addAttribute("cat",new Category() );
	List<Category> list=categorydao.list();
	session.setAttribute("list",list);
		mod.addAttribute("showcat",true);
		  log.debug("update category in categorycontroller method ends");
	    return "index";
	}
	@RequestMapping("/adminupdatecategories")
	public String viewallCategryupdate(Model mod){
		mod.addAttribute("showpage_showallCategories","true");
		mod.addAttribute("categoryupdate","true");
		
		return"index";
	}
	@RequestMapping("/admindeletecategory")
	public String viewallCategryforDelete(Model mod,HttpSession session){
		mod.addAttribute("categorydelete","true");
		mod.addAttribute("showpage_showallCategories","true");
		return"index";
	}
	@RequestMapping("/admineditcategory{id}")
	public String edit(@PathVariable("id") String id,Model mod){
		category=categorydao.get(id);
		mod.addAttribute("editcat","true");
		mod.addAttribute("selectedcategoryrow",category);
		return"index";
	}
@RequestMapping("/admindeletecategory{id}")
public String deleteCategory(@PathVariable("id") String id,Model mod,HttpSession session){
	log.info("deletecategory started");
	category.setId(id);
	boolean status=categorydao.delete(category);
	if(status==true){
		List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		return "redirect:/admindeleteredirect";
		}else{
			mod.addAttribute("deletesupplierexecption","while deleting supplier some exception happens");
			return"index";
		}
}

@RequestMapping("/admindeleteredirect")
public String showsupplierafterdelete(Model mod){
	mod.addAttribute("showcat","true");
	mod.addAttribute("deltetcategory","true");
	mod.addAttribute("cat",new Category());
	return "index";	
}
}
