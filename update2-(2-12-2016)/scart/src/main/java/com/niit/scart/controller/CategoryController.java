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
	@RequestMapping("/addcategory")
	public ModelAndView addCategory(@ModelAttribute("add") Category category,Model mod,HttpSession session){
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
		return new ModelAndView ("index","cat",new Category());
		
	}
	@RequestMapping("updatecategory")
	public String updateCategory(@ModelAttribute("updatecat") Category cat,Model mod,HttpSession session){
		System.out.println("started");

	String status=categorydao.update(cat);
	if(status.equals("idNotExists")){
		mod.addAttribute("idNotExists","true");
	}else if(status.equals("updated")){
		mod.addAttribute("updated","true");
	}else if(status.equals("exception")){
		mod.addAttribute("exception","true");
	}
        List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		mod.addAttribute("showpage_showallCategories",true);
	    return "index";
	}
	@RequestMapping("/viewall")
	public String viewallCategry(Model mod,HttpSession session){
		mod.addAttribute("showpage_showallCategories",true);
		List<Category> list=categorydao.list();
		session.setAttribute("list",list);
		return"index";
	}
	@RequestMapping("/editcategory/{id}")
	public String edit(@PathVariable("id") String id,Model mod){
		category=categorydao.get(id);
		mod.addAttribute("editcat","true");
		mod.addAttribute("selectedcategoryrow",category);
		return"index";
	}
@RequestMapping("/deletecategory/{id}")
public String deleteCategory(@PathVariable("id") String id,Model mod,HttpSession session){
	log.info("deletecategory started");
	category.setId(id);
	boolean status=categorydao.delete(category);
	if(status==true){
		mod.addAttribute("deleted","true");
	}else {
		mod.addAttribute("deleteexception","true");
	}
	log.info("deletecategory ended");
return"redirect:/viewall";
}
	
}
