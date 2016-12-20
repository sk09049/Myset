package com.niit.scart.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.scartbackend.dao.CartDao;
import com.niit.scartbackend.dao.ProductDao;
import com.niit.scartbackend.model.Cart;
import com.niit.scartbackend.model.Product;

@Controller
@SessionAttributes({"currentuser"})

public class CartController {
	public static Logger log=LoggerFactory.getLogger(CartController.class);

@Autowired
CartDao cartdao;
@Autowired
ProductDao productdao;
@Autowired
Cart cart;
	@RequestMapping("_cartaddtocart{id}/{currentuser:.+}")
	public String addtocart(@RequestParam("quantity") String quantity,@PathVariable("id") String id,@PathVariable("currentuser") String currentuser,HttpSession session,Model mod,RedirectAttributes redir){
		log.debug("add a single product to mycart strated");
		Product product=productdao.get(id);
		String maxid=cartdao.maxId();
		System.out.println(maxid);
		String []split=maxid.split("(?<=\\D)(?=\\d)");
		int temp=Integer.parseInt(split[1])+1;
		System.out.println(temp);
		String cartid="temp";
		System.out.println(currentuser);
		if(temp<10){
			System.out.println("im here");
			cartid="cart0"+temp;
		}else{
			cartid="cart"+temp;
		}
		System.out.println(cartid);

		cart.setId(cartid);
		String [] temp2=product.getPrice().split("\\.");
		cart.setPrice(Integer.parseInt(temp2[0]));
		cart.setProduct_name(product.getName());
		cart.setProduct_id(id);
		if(quantity==""){
			quantity="1";
		}
		cart.setStatus("N");
		cart.setQuantity(quantity);
		cart.setUser(currentuser);
		cartdao.save(cart);
		int count=cartdao.getcartcount(currentuser);
		session.setAttribute("cartcount",count);
		redir.addFlashAttribute("itemaddedtothecart",cart);
		log.debug("add a single product completed");
		return "redirect:/_cartaddedtomycart";
	}
	@RequestMapping("/_cartaddedtomycart")
		public String showmycart(Model mod){
		mod.addAttribute("showitemaddedtocart","true");
			return"index";
		}
	@RequestMapping("/_cartaddtocarttomycart")
	public String viewmycart(Principal p,Model mod,HttpSession session){
		String mycart=p.getName();
List<Cart>	allcart=cartdao.getallcartforcurrentuser(mycart);
String total=cartdao.gettotalofneworders(mycart);
mod.addAttribute("total",total);
int count=cartdao.getcartcount(mycart);
session.setAttribute("cartcount", count);
mod.addAttribute("showallcart",allcart);
mod.addAttribute("showmycart", "true");
		return "index";
	}
	
	@RequestMapping("/_cartbuyallnewitems")
	public String buyallitems(Principal p,Model mod,HttpSession session){
		log.debug("buy all items in my cart started");
		List<Cart>	allcart=cartdao.getlistofneworders(p.getName());
		session.setAttribute("listofnewcart", allcart);
		String total=cartdao.gettotalofneworders(p.getName());
session.setAttribute("total", total);
log.debug("buy all product details send to webflow");
	mod.addAttribute("showmycartorderpage", "true");
		return "redirect:/cart_checkout?uid=allnew";
	}
	@RequestMapping("/_cartremovefromcart{id}")
	public String removefromcart(@PathVariable("id") String id,RedirectAttributes redir){
		
		Cart cart=cartdao.get(id);
		boolean status=cartdao.delete(cart);
		log.debug("delete a  new cart order from mycart completed");
		if(status==true){
			redir.addFlashAttribute("cartdeletestatus", cart.getProduct_name()+" ,removed from your cart");
		}
		return"redirect:/_cartaddtocarttomycart";
	}
	}

