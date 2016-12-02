package com.niit.scart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.scartbackend.dao.SupplierDao;
import com.niit.scartbackend.model.Supplier;

@Controller
public class SupplierController {
@Autowired
SupplierDao supplierDao;
@Autowired
Supplier supplier;

@RequestMapping("/addsupplier")
public String addSupplier(@ModelAttribute("addsupplier") Supplier supplier,Model mod ){
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
	return("index");
}
@RequestMapping("/deletesupplier")
public String viewallsupplier(Model mod){
	List<Supplier> listofsupplier=supplierDao.list();
	mod.addAttribute("supplierlist",listofsupplier);
	mod.addAttribute("deletesupplier","true");
	mod.addAttribute("showallsupplier","true");
	return "index";
}
@RequestMapping("/updatesupplier")
public String updatesupplier(Model mod){
	List<Supplier> listofsupplier=supplierDao.list();
	mod.addAttribute("supplierlist",listofsupplier);
	mod.addAttribute("showallsupplier","true");
	mod.addAttribute("updatesupplier","true");
	return "index";
}
@RequestMapping("/submitupdatesupplier")
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
	mod.addAttribute("supplierupdated","updated successfully");
	return "index";
}
@RequestMapping("/deletesupplierfromdb/{id}")
public String deletesupplierfromdb(Model mod,@PathVariable("id") String id){
	supplier.setId(id);
	boolean status=supplierDao.delete(supplier);
	if(status==true){
	return "redirect:/dleteredirect";
	}else{
		mod.addAttribute("deletesupplierexecption","while deleting supplier some exception happens");
		return"index";
	}
}
@RequestMapping("/dleteredirect")
public String showsupplierafterdelete(Model mod){
	mod.addAttribute("supply","true");
	mod.addAttribute("supplier",new Supplier());
	mod.addAttribute("supplierdeleted","true");
	return "index";	
}
@RequestMapping("/editsupplier/{id}")
public String editsupplier(@PathVariable("id") String id,Model mod){
	Supplier supplierrow=supplierDao.get(id);
	mod.addAttribute("supplierrow",supplierrow);
	mod.addAttribute("editsupplier","true");
	return "index";
}
}
