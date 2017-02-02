package com.niit.project2.collaboration.mailcheck;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;

import org.springframework.stereotype.Component;  
 @Component 
public class EmailCheck { 
	 private String to;
 public boolean mailcheck(String id,String otp) {  
to=id;  
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("yourmailid","yourpassword");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress("yourmailid"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject("Hello");  
   message.setText("your otp is :"+otp+" enter this no to complete registration");  
     
   //send message  
   Transport.send(message);  
   System.out.println("message sent successfully");  
   return true;

   
  } catch (MessagingException e) {
	  return false;
	  } catch(Exception e){
		  
		  return false;
 
	  }
   
 }  
}  
