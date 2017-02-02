package com.niit.project2.colloboration.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.niit.project2.collaboration.model.Message;
import com.niit.project2.collaboration.model.OutputMessage;

@Controller
public class ChatController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message) {
		System.out.println(" Message : "+ message.getMessage());
		
		System.out.println(" Message ID : "+ message.getId());
		
		return new OutputMessage(message , new Date());
	}

}
