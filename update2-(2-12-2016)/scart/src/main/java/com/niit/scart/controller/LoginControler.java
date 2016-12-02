package com.niit.scart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.scartbackend.dao.UserDao;
import com.niit.scartbackend.model.User;

@Controller
public class LoginControler {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm(Model mod) {
		mod.addAttribute("check3","true");
        return new ModelAndView("index");
    }

	@RequestMapping("/logout")
	public String logout(Model mod){
		mod.addAttribute("msg","successfully loged out");
		 mod.addAttribute("ch1","true");
       return "index";
	}
	@Autowired
	UserDao userdao1;
	@RequestMapping("/logincheck")
	public String logincheck(Model mod,@RequestParam ("user") String id,@RequestParam ("pass") String pwd){
   List <User> admin=userdao1.adminValidation(id, pwd);
   int b=admin.size();
   if(b==1){
		mod.addAttribute("adminlogcheck","true");
		mod.addAttribute("as"," admin you logged in successfully");

	   return "index";
	   
   }else{
   		List<User> user=userdao1.userValidation(id, pwd);
		int a=user.size();
		if(a==1){
			mod.addAttribute("userlogcheck","true");

			
			mod.addAttribute("ha","you logged in successfully");
			return "index";
		}else {
			mod.addAttribute("ha","username or password not coorect");
			return"login";
			}
       
   }
	}
	
	

	 @RequestMapping(value = "/welcome", method = RequestMethod.POST)
	    public String submit( @ModelAttribute("employee")User user, 
	      BindingResult result,Model model) {
		 
	        if (result.hasErrors()) {
	            return "register";
	        }
	        
	       
	      String gh=userdao1.saveuserdetails(user);
		    model.addAttribute("error",gh);
		    model.addAttribute("error1",true);
		   return "index";
	 }	
}
