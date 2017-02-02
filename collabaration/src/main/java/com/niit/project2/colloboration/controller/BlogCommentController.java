package com.niit.project2.colloboration.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.project2.collaboration.dao.BlogCommentsDao;
import com.niit.project2.collaboration.model.BlogComment;
@RestController
public class BlogCommentController {
	@Autowired
	BlogComment blogcomment;
	@Autowired
	BlogCommentsDao commentdao;
	@RequestMapping(value="saveblogcomment",method=RequestMethod.POST)
	public ResponseEntity<BlogComment> saveComment(@RequestBody BlogComment comment){
		comment.setId(commentdao.getMaxId()+1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		comment.setComment_time(dateFormat.format(date));
		boolean status=commentdao.save(comment);
		if(status==true){
			comment.setErrorCode("200");
			comment.setErrorMessage("successfully saved");
		}else{
			comment.setErrorCode("404");
			comment.setErrorMessage("error while saving");
		}
		return new ResponseEntity<BlogComment>(comment,HttpStatus.OK);
	}

	@RequestMapping("blogcommentlist")
	public ResponseEntity<List<BlogComment>> getAllComments(){
		List<BlogComment> list=commentdao.getAllComments();
		return new ResponseEntity<List<BlogComment>>(list,HttpStatus.OK);
	}
}
