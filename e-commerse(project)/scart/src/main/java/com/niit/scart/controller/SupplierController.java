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

import com.niit.scartbackend.dao.CategoryDao;
import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.model.Category;
import com.niit.scartbackend.model.Supplier;

@Controller
public class SupplierController {
	public static Logger log=LoggerFactory.getLogger(SupplierController.class);	
@Autowired
SupplierDao supplierDao;
@Autowired
Supplier supplier;
@Autowired
CategoryDao categorydao;
@RequestMapping("/adminaddsupplier")
public String addSupplier(@ModelAttribute("addsupplier") Supplier supplier,Model mod ){
	log.debug("add supplier starts");
	String status=supplierDao.save(supplier);
	if(status.equals("idexists")){
		mod.addAttribute("idexists","true");
	}else if(status.equals("added")){
		mod.addAttribute("added","true");
	}else if(status.equals("exception")){
		mod.addAttribute("exception","true");		
	}
	mod.addAttribute("supplier",new Supplier());
	mod.addAttribute("supply","true");
	log.debug("add supplier ends");
	return("index");
}
@RequestMapping("/admindeletesupplier")
public String viewallsupplier(Model mod){

	List<Supplier> listofsupplier=supplierDao.list();
	mod.addAttribute("supplierlist",listofsupplier);
	mod.addAttribute("deletesupplier","true");
	mod.addAttribute("showallsupplier","true");

	return "index";
}
@RequestMapping("/adminupdatesupplier")
public String updatesupplier(Model mod){
	log.debug("update supplier starts");
	List<Supplier> listofsupplier=supplierDao.list();
	mod.addAttribute("supplierlist",listofsupplier);
	mod.addAttribute("showallsupplier","true");
	mod.addAttribute("updatesupplier","true");
	log.debug("update supplier ends");
	return "index";
}
@RequestMapping("/adminsubmitupdatesupplier")
public String submitupdatesupplier(Model mod,@ModelAttribute("submitupdatesupplier") Supplier supplier){
	String status=supplierDao.update(supplier);
	if(status.equals("idnotexists")){
		mod.addAttribute("idnotexists","true");
	}else if(status.equals("updated")){
		mod.addAttribute("updated","true");		
		}else if(status.equals("exeption")){
			mod.addAttribute("updateexeption","true");		
			}
	mod.addAttribute("supply","true");
	mod.addAttribute("supplier",new Supplier());
	return "index";
}
@RequestMapping("/admindeletesupplierfromdb{id}")
public String deletesupplierfromdb(Model mod,@PathVariable("id") String id){
	log.debug("delete supplier starts");
	supplier.setId(id);
	boolean status=supplierDao.delete(supplier);
	if(status==true){
	return "redirect:/admindleteredirect";
	}else{
		mod.addAttribute("deletesupplierexecption","while deleting supplier some exception happens");
		return"index";
	}
}
@RequestMapping("/admindleteredirect")
public String showsupplierafterdelete(Model mod,HttpSession session){
	mod.addAttribute("supply","true");
	mod.addAttribute("supplier",new Supplier());
	mod.addAttribute("supplierdeleted","true");
	List<Category> list=categorydao.list();
	session.setAttribute("list",list);
	log.debug("delete supplier ends");

	return "index";	
}
@RequestMapping("/admineditsupplier{id}")
public String editsupplier(@PathVariable("id") String id,Model mod){
	Supplier supplierrow=supplierDao.get(id);
	mod.addAttribute("supplierrow",supplierrow);
	mod.addAttribute("editsupplier","true");
	return "index";
}
}
