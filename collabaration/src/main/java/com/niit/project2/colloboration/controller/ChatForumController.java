package com.niit.project2.colloboration.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.niit.project2.collaboration.dao.ChatDao;
import com.niit.project2.collaboration.model.Chat;
import com.niit.project2.collaboration.model.Message;
import com.niit.project2.collaboration.model.OutputMessage;
@Controller
public class ChatForumController {
	
	@Autowired 
	Chat chat;
	@Autowired
	ChatDao chatdao;
	
	@MessageMapping("/chat_forum")
	@SendTo("/queue/message")
	public OutputMessage sendMessage(Message message)
	{
		String msg=message.getMessage();
		String[] array=msg.split(",");
	chat.setId(chatdao.getMaxid()+1);
		chat.setMsg_senderId(array[0]);
		chat.setMsg_recieverId(array[1]);
		chat.setMessage(array[2]);
		chat.setTime(new Date());
		chatdao.save(chat);
		System.out.println("Message is : "+message.getMessage());
		System.out.println(" Message ID is : "+message.getId());
		
		return new OutputMessage(message, new Date());
	}
}


