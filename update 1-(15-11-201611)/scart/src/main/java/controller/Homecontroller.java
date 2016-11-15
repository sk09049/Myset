package controller;

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
public class Homecontroller {
	@Autowired
	UserDao userdao;
	@RequestMapping("/register")
	public ModelAndView register(Model mod){
		mod.addAttribute("check4","true");
		return new ModelAndView ("index","reg",new User());
	}
	 @RequestMapping(value = "/welcome", method = RequestMethod.POST)
	    public String submit( @ModelAttribute("employee")User user, 
	      BindingResult result,Model model) {
		 
	        if (result.hasErrors()) {
	            return "register";
	        }
	        
	       
	      String gh=userdao.saveuserdetails(user);
		    model.addAttribute("error",gh);
		    model.addAttribute("error1",true);
		   return "index";
	 }	
		@RequestMapping("/logincheck")
		public String logincheck(Model mod,@RequestParam ("user") String id,@RequestParam ("pass") String pwd){
	   List <User> admin=userdao.adminValidation(id, pwd);
	   int b=admin.size();
	   if(b==1){
			mod.addAttribute("adminlogcheck","true");
			mod.addAttribute("as"," admin you logged in successfully");

		   return "index";
		   
	   }else{
	   		List<User> user=userdao.userValidation(id, pwd);
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
@RequestMapping("/product")
public ModelAndView product(Model mod){
	mod.addAttribute("product","true");
	return new ModelAndView("index","pro",new Products());
}
@RequestMapping("/supply")
public ModelAndView supply(Model mod){
	mod.addAttribute("supply","true");
	return new ModelAndView("index","supplier",new Supplier());
}
	
	@RequestMapping("/")
public String home(Model mod){
		mod.addAttribute("ch","true");
		System.out.println("hi");
		return "index";
		
	}

	@RequestMapping("/category")
	public ModelAndView category(Model mod){
		mod.addAttribute("check5","true");
		return new ModelAndView ("index","cat",new Category());
	}
	
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

