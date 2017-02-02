package com.niit.project2.colloboration.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.project2.collaboration.dao.Userdao;
import com.niit.project2.collaboration.mailcheck.EmailCheck;
import com.niit.project2.collaboration.model.User;
import sun.misc.BASE64Decoder;

@RestController
public class UserController {
	public static Logger log=LoggerFactory.getLogger(UserController.class);
	@Autowired
	Userdao userdao;
	@Autowired
	User user;
	@Autowired
	EmailCheck emailcheck;
	@RequestMapping("editprofile")
	public ResponseEntity<User> editProfile(@RequestBody User user){
		String  status=userdao.update(user);
		if(status.equals("idnotexists")){
			user.setErrorCode("404");
			user.setErrorMessage("Id not in database");
		}else if(status.equals("success")){
			user.setErrorCode("200");
			user.setErrorMessage("successfully updated");
		}else{
			user.setErrorCode("404");
			user.setErrorMessage("error occured try after sometime");
		}
		
		return new ResponseEntity<User>(user,HttpStatus.OK);

	}
	@RequestMapping("completeuserlist")
	public ResponseEntity<List<User>> getcompleteUserDetail(){
		List<User> list=userdao.list();
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ResponseEntity<User> upload(@RequestBody String id){
		String path="/home/ubuntu/workspace/Collabaration-frondend/WebContent/images";
		String parts[] = id.split(",");
		String array[]=id.split("\\?");
		System.out.println(array[1]);

		try {
			String imageString = parts[1];
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] imageByte=decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			BufferedImage image=ImageIO.read(bis);
			bis.close();
			File dir=new File(path);
			File serverFile=new File(dir.getAbsolutePath()+File.separator+array[1]+".png");

			ImageIO.write(image, "png", serverFile);

			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		user.setErrorCode("sucess");
		System.out.println("entering");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="matchotp/{otp}/{id}",method=RequestMethod.POST)
	public ResponseEntity<User> matchotp(@PathVariable("otp") String otp,@PathVariable("id") String id){
		user=userdao.get(id);
		if(user.getOtp().equals(otp)){
			user.setIs_verified('Y');
			String status=userdao.update(user);
			if(status.equals("success")){
				user=userdao.get(id);
				user.setErrorCode("200");
				user.setErrorMessage("email verified successfully after admin approval you can log in");
			}else{
				user.setErrorCode("404");
				user.setErrorMessage("otp matched but some error occured try aftersometime");
			}
		}else{
			user.setErrorCode("404");
			user.setErrorMessage("otp not matching");
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="mailcheck/{id}",method=RequestMethod.POST)
	public ResponseEntity<String> emailcheck(@PathVariable("id") String id){
	    Random r = new Random( System.currentTimeMillis() );
int n=10000 + r.nextInt(20000);
String otp=Integer.toString(n);
System.out.println("................."+id);
user=userdao.get(id);
user.setOtp(otp);
String msg=userdao.update(user);
if(msg.equals("idnotexists")){
	return new ResponseEntity<String>("your detail not in the database",HttpStatus.OK);
}else if(msg.equals("exception")){
	return new ResponseEntity<String>("error happened",HttpStatus.OK);

}
		boolean result=emailcheck.mailcheck(user.getEmail(), otp);
		System.out.println("fjfnjnffn"+result);
		String status="0";
		if(result==true){
			System.out.println("entering");
			 status="200";
			}
		else{
		 status="404";
		 }
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	@RequestMapping(value="/get/{id}",method=RequestMethod.POST)
	public ResponseEntity<User> getUser(@PathVariable("id") String id){
		
		User user=userdao.get(id);
		if(user==null){
			user=new User();
			user.setErrorCode("404");
			user.setErrorCode("no record available");
		}
		else{
			user.setErrorCode("200");
			user.setErrorMessage("successfully details for the selected id retrived");
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@RequestMapping("/list")
public ResponseEntity<List<User>> getlistofuser(){
		log.debug("list method started");
		List<User> users=userdao.getlistofuser();
		if(users.isEmpty()){
			user.setErrorCode("404");
			user.setErrorMessage("no user is registered");
			users.add(user);
		}
		else {
		for( User a:users){
			a.setErrorCode("200");
			a.setErrorMessage("user details from database");
		}
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> saveuser(@RequestBody User user){
		user.setIs_online('W');
		user.setStatus('W');
		user.setIs_verified('N');
		user.setReason("NotApplicable");
		String status=userdao.save(user);
		if(status.equals("success")){
			user.setErrorCode("200");
			user.setErrorMessage("thankyou for Registration");
			log.debug("done");
		}else if(status.equals("exception")){
			user.setErrorCode("404");
			user.setErrorMessage("some error occured contact admin");
			
		}else if(status.equals("idexists")){
			user.setErrorCode("404");
			user.setErrorMessage("user id Already exists try with new one");
		}
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/autenticate/{id}",method=RequestMethod.POST)
	public ResponseEntity<User> authenticate(@PathVariable("id") String id){
	user=updateuserstatus(id,"A");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

private User updateuserstatus(String id,String reason){
	
	user=userdao.get(id);
	if(user==null){
		user=new User();
		user.setErrorCode("404");
		user.setErrorMessage("no record found with particular id");
	}else{
		if(reason.equals("A")){
			user.setIs_online('N');
			user.setStatus('A');
			user.setReason("");
			String status=userdao.update(user);
			if(status.equals("idnotexists")){
				user.setErrorCode("404");
				user.setErrorMessage("no record exists with this id");
			}else if (status.equals("success")){
				user.setErrorCode("200");
				user.setErrorMessage("successfully user updated");
			}else if(status.equals("exception")){
				user.setErrorCode("404");
				user.setErrorMessage("contact admin some exception happened");
				}
		return user;	
		}else{
			user.setIs_online('R');
			user.setStatus('R');
			user.setReason(reason);
			String status=userdao.update(user);
			if(status.equals("idnotexists")){
				user.setErrorCode("404");
				user.setErrorMessage("no record exists with this id");
			}else if (status.equals("success")){
				user.setErrorCode("200");
				user.setErrorMessage("user ,"+user.getId()+" rejected for this reason :"+user.getReason());
			}else if(status.equals("exception")){
				user.setErrorCode("404");
				user.setErrorMessage("contact admin some exception happened");
				}
		return user;	
			
		}
		
	}
	return user;
}
@RequestMapping(value="/reject/{id}/{reason}",method=RequestMethod.POST)
public ResponseEntity<User> rejectUser(@PathVariable("id") String id,@PathVariable("reason") String reason){
	user=updateuserstatus(id, reason);
	return new ResponseEntity<User>(user,HttpStatus.OK);
}


@RequestMapping(value="/login",method=RequestMethod.POST)
public ResponseEntity<User> login(HttpSession httpSession,@RequestBody User user){
	String id=user.getId();
	String password=user.getPassword();
	String status=userdao.validate(id, password);
	if(status.equals("invalid")){
		user.setErrorCode("404");
		user.setErrorMessage("username or password is not correct");
}else if(status.equals("connectexception)")){
		user.setErrorCode("404");
		user.setErrorMessage("could not connect contact admin");
}else if(status.equals("not")){
	user=userdao.get(id);
	user.setErrorCode("405");
	user.setErrorMessage("Your email is not verified");
}
else if(status.equals("validateexception")){
		user.setErrorCode("404");
		user.setErrorMessage("username or password is ok but could not connect contact admin");
}else if(status.equals("A")){
		user=userdao.get(id);
		user.setIs_online('Y');
		httpSession.setAttribute("LoggedInUserId", id);
      String updatestatus = userdao.update(user);
      if(updatestatus.equals("exception")){
    	  user.setErrorCode("404");
  		user.setErrorMessage("Your details correct but probelm with connection contact admin");  
      }else{
    	 
		user.setErrorCode("200");
		user.setErrorMessage("You logged in successfully");}
}else if(status.equals("R")){
		String details=userdao.reasonforrejection(id);
		if(details.equals("rejctionexception")){
			user.setErrorCode("404");
			user.setErrorMessage("Your registration is rejected to know reason contact admin ");
			}else{
				user.setErrorCode("404");
				user.setErrorMessage("Your registration is rejected for the reason :"+details);
			}
}else if(status.equals("W")){
		user.setErrorCode("404");
		user.setErrorMessage("Your registration is waiting for approval from admin try after 24 hours");
	}
	
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

@RequestMapping("/logout")
public ResponseEntity<User> logout(HttpSession session){
	String id=(String)session.getAttribute("LoggedInUserId");
	if(id==null){
		user=new User();
		user.setErrorCode("404");
		user.setErrorMessage("problem with connection login again");	
	}else{
	session.invalidate();
	user=userdao.get(id);
	user.setIs_online('N');
	String status=userdao.update(user);
	if(status.equals("success")){
		user.setErrorCode("200");
		user.setErrorMessage("you successfully logged out");
	}else if(status.equals("exception")){
		user.setErrorCode("404");
		user.setErrorMessage("connection problem contact admin");	
	}
	}
return new ResponseEntity<User>(user,HttpStatus.OK);
}

@RequestMapping("/newuser")
public ResponseEntity<List<User>> newUsers(){
	List<User> users=userdao.listOfNewUser();
	if(users.isEmpty()){
		User user=new User();
		user.setErrorCode("404");
		user.setErrorMessage("no new user is registered");
		users.add(user);
}else{
	for( User a:users){
		a.setErrorCode("200");
		a.setErrorMessage("new user details from database");
	}

}
	return new ResponseEntity<List<User>>(users,HttpStatus.OK);
}
}
