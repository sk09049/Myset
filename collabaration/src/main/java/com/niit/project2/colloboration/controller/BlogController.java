package com.niit.project2.colloboration.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.project2.collaboration.dao.BlogDao;
import com.niit.project2.collaboration.model.Blog;

@RestController
public class BlogController {

	@Autowired
	Blog blog;
	@Autowired
	BlogDao blogdao;
	
	@RequestMapping("getmyblogs/{id}")
	public ResponseEntity<List<Blog>> getMyBlogs(@PathVariable("id") String id){
		List<Blog> list=blogdao.getMyBlog(id);
		if(list.isEmpty()){
			blog.setErrorCode("404");
			blog.setErrorMessage("you are not written any blog so far");
			list.add(blog);
		}
		return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
	}
	@RequestMapping(value="approveblog",method=RequestMethod.POST)
	public ResponseEntity<Blog> approveBlog(@RequestBody Blog blog){
		blog=blogdao.get(blog.getId());
		if(blog==null){
			blog=new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("this record is not exist in database");

		}
		blog.setStatus('A');
		boolean status=blogdao.update(blog);
		if(status==true){
			blog.setErrorCode("200");
			blog.setErrorMessage("successfully blog approved");
		}else {
			blog.setErrorCode("404");
			blog.setErrorMessage("error while approving try after sometime");

		}
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	@RequestMapping(value="rejectblog",method=RequestMethod.POST)
	public ResponseEntity<Blog> rejectBlog(@RequestBody Blog blog){
		blog=blogdao.get(blog.getId());
		if(blog==null){
			blog=new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("this record is not exist in database");

		}
		blog.setStatus('R');
		boolean status=blogdao.update(blog);
		if(status==true){
			blog.setErrorCode("200");
			blog.setErrorMessage(" blog rejected successfully");
		}else {
			blog.setErrorCode("404");
			blog.setErrorMessage("error while rejecting try after sometime");

		}
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	@RequestMapping("newblogs")
	public ResponseEntity<List<Blog>> getNewBlogs(){
		List<Blog>list=blogdao.getNewBlogs();
		if(list.isEmpty()){
			blog.setErrorCode("404");
			blog.setErrorMessage("there is no new blogs available");
			list.add(blog);
		}
		return new ResponseEntity<List<Blog>> (list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveblog",method=RequestMethod.POST)
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
		int id=blogdao.getMaxId();
		blog.setId(id+1);
		if(	blogdao.get(id+1)!=null){
			blog.setErrorCode("404");
			blog.setErrorMessage("Error due to Id mismatch contact admin");
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
			}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		blog.setDate_time(dateFormat.format(date));
		blog.setStatus('W');
		blog.setReject_reason("NotApplicable");
		boolean status=blogdao.save(blog);
		if(status==true){
			blog.setErrorCode("200");
			blog.setErrorMessage("successfully blog saved your blog will be visible after admin approval");

		}else{
			blog.setErrorCode("404");
			blog.setErrorMessage("Error while saving contact admin or try after sometime");

		}
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	@RequestMapping("acceptedblogs")
	public ResponseEntity<List<Blog>> getAcceptedBlogs(){
		List<Blog> list=blogdao.getAcceptedBlogs();
		if(list.isEmpty()){
			blog.setErrorCode("404");
			blog.setErrorMessage("No Approved Blogs are available");
			list.add(blog);
			return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
		}
		for(Blog a:list){
			a.setErrorCode("200");
			a.setErrorCode("details from db");
		}
		return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);

	}
}
