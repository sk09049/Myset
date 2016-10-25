package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Homecontroller {
	
	@RequestMapping("/")
public String home(Model mod){
		mod.addAttribute("ch","true");
		return "index";
		
	}
	@RequestMapping("/login")
	public String login(Model mod){
		mod.addAttribute("check1","true");
		return "index";
	}
	/*@RequestMapping("/welcome")
	public ModelAndView welcome(@ModelAttribute("student") Student ob){
	    ModelAndView mod =new ModelAndView("index");
	    mod.addObject("check2","true");
			return mod;
		}
			*/
	
	@RequestMapping("/welcome")
	public String welcome(@RequestParam("user") String usr,@RequestParam ("pass") String pwd,Model mod){
		if(usr.equals("12345")&&pwd.equals("12345")){

         mod.addAttribute("check2","true");
         mod.addAttribute("successmsg","successfully logged");
		return "index";
		}else{
			mod.addAttribute("check3","true");
			mod.addAttribute("error","sorry username or password is invalid");
			return "index";
		}
	}
	@RequestMapping("/logout")
	public String logout(Model mod){
		mod.addAttribute("msg","successfully loged out");
		 mod.addAttribute("ch1","true");
       return "index";
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
	}

