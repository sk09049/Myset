package com.niit.project2.colloboration.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.project2.collaboration.dao.ChatDao;
import com.niit.project2.collaboration.dao.FriendDao;
import com.niit.project2.collaboration.model.Chat;
import com.niit.project2.collaboration.model.Friend;

@RestController
public class FriendController {

@Autowired
Friend friend;
@Autowired
FriendDao friendao;

@Autowired
ChatDao chatdao;
@Autowired
Chat chat;
@RequestMapping("getoldmessages/{id}")
public ResponseEntity<List<Chat>> getOldMessages(@PathVariable("id") String id){
	List<Chat> list=chatdao.list(id);
	if(list.isEmpty()){
		chat.setErrorCode("404");
		chat.setErrorMessage("you dont have any older messages");
		list.add(chat);
	}
	return new ResponseEntity<List<Chat>>(list,HttpStatus.OK);
}
	@RequestMapping(value="savefriendrequest/{friendid}/{userid}",method=RequestMethod.POST)
	public ResponseEntity<Friend> savefriend(@PathVariable("friendid") String friendid,@PathVariable("userid") String userid){
		System.out.println("sbhbfhbf"+friendid+" "+userid);
	int maxid=friendao.getMaxId();
	int id=maxid+1;
	System.out.println("maxid:"+id);
	friend.setFriend_id(friendid);
	friend.setUser_id(userid);
	friend.setId(id);
	friend.setStatus("N");
	if(friendao.get(userid, friendid)!=null){
		friend=friendao.get(userid, friendid);
		if(friend.getStatus().equals("A")){
			friend.setErrorCode("404");
			friend.setErrorMessage(friendid+",and You already friends");
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		}
		else if(friend.getStatus().equals("R")){
			friend.setErrorCode("404");
			friend.setErrorMessage(friendid+",is already rejected your friend request");
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);

		}else{
		friend.setErrorCode("404");
		friend.setErrorMessage("You already send a request");
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);

		}
}
	if(friendao.get(friendid, userid)!=null){
		friend=friendao.get(friendid, userid);
		if(friend.getStatus().equals("A")){
			friend.setErrorCode("404");
			friend.setErrorMessage(friendid+" and you are already friends");
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);

		}else if(friend.getStatus().equals("R")){
			if(friendao.delete(friend)){
				friend.setStatus("N");
				friend.setUser_id(userid);
				friend.setFriend_id(friendid);
				boolean status=friendao.save(friend);
if(status==true){
	friend.setErrorCode("200");
	friend.setErrorMessage("successfully friend request send");
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);

}else{
	friend.setErrorCode("404");
	friend.setErrorMessage("error while sending request try after some time");
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);

}

			}else{
			friend.setErrorCode("404");
			friend.setErrorMessage("error while sending request try after some time");
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);

			}
		}else{
		friend.setErrorCode("404");
		friend.setErrorMessage(friendid+" ,already send you a request accept it");
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);

		}

	}
	boolean status=friendao.save(friend);
	if(status==true){
		friend.setErrorCode("200");
		friend.setErrorMessage("successfully friend request send");
	}else{
		friend.setErrorCode("404");
		friend.setErrorMessage("error while sending request try after some time");
	}
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping("getrequests/{id}")
	public ResponseEntity<List<Friend>> getFriendReuests(@PathVariable("id") String id){
		List<Friend> list=friendao.getFriendRequest(id);
		if(list.isEmpty()){
			friend.setErrorCode("404");
			friend.setErrorMessage("you dont have any friends");
			list.add(friend);
			return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);

		}
		for(Friend a:list){
			a.setErrorCode("200");
		}
		return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);
	}
	@RequestMapping("accept/{userid}/{friendid}")
	public ResponseEntity<Friend> accept(@PathVariable("userid") String userid,@PathVariable("friendid") String requesterid){
		friend=friendao.accept(userid, requesterid);
		if(friend==null){
			friend.setErrorCode("404");
			friend.setErrorMessage("sorry error occured");
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		}
		friend.setErrorCode("200");
		friend.setErrorMessage("request accepted");
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping("getmyrequest/{id}")
	public ResponseEntity<List<Friend>> getMyrequest(@PathVariable("id") String id){
		List<Friend> list=friendao.getMyRequest(id);
		if(list.isEmpty()){
			friend.setErrorCode("404");
			friend.setErrorMessage("you are not send any request to anyone");
			list.add(friend);
			return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);
	
		}
		return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);
	}
	@RequestMapping("getmyfriends/{id}")
	public ResponseEntity<List<Friend>> getMyFriends(@PathVariable("id") String id){
		List<Friend> list=friendao.getMyFriends(id);
		if(list.isEmpty()){
			friend.setErrorCode("404");
			friend.setErrorMessage("you dont have any friends");
			list.add(friend);
			return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);
	
		}
		return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);
	}
	@RequestMapping("rejectrequest/{uid}/{fid}")
	public ResponseEntity<Friend> rejectRequest(@PathVariable("uid") String uid,@PathVariable("fid") String fid){
		friend=friendao.rejectRequest(uid, fid);
		if(friend.getErrorCode().equals("404")){
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);
			}
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
}
