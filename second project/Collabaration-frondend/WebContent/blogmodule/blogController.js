myapp.controller("blogControl",["blogService","$rootScope","$cookieStore","$location",function(blogService,$rootScope,$cookieStore,$location){
	
	var temp=this;
	temp.blog={
			id:'',
			title:'',
			description:'',
			errorCode:'',
			errorMessage:'',
			status:'',
			date_time:'',
			reject_reason:'',
			user_id:''
	}
	temp.newblogs=[];
	temp.myblogs=[];
	temp.blogcomments=[];
	temp.comment={
			id:'',
			blog_id:'',
			comments:'',
			user_id:'',
			comment_time:''
				}
	temp.getNewBlogs=function(){
		blogService.getNewBlogs()
		.then(function(d){
			temp.newblogs=d;
		},function(){
			alert("error while calling  service");
		})
	}
	temp.getMyBlog=function(){
		blogService.getMyBlog($rootScope.currentUser.id)
		.then(function(d){
			temp.myblogs=d;
			console.log("ss"+d);
		},function(){
			alert("error ocurred")
		})
	}
		temp.saveComment=function(id){
		if($cookieStore.get('currentUser')){
			alert($rootScope.currentUser)
			console.log($rootScope.currentUser)
			alert("hi"+id);
			temp.comment.blog_id=id;
			temp.comment.user_id=$rootScope.currentUser.id;	
			
			blogService.saveComment(temp.comment)
			.then(function(d){
				alert(d.errorMessage);
				temp.getBlogComments();
				temp.comment=d;
				temp.comment.comments='';
			},function(e){
				alert("error")
			})
		}else{
$location.path("/login");
return;
		}
		
	}
	temp.blogs=[];
	temp.saveBlog=function(){
		temp.blog.user_id=$rootScope.currentUser.id;
		blogService.saveBlog(temp.blog)
		.then(function(d){
temp.blog=d;
temp.blog.description='';
	temp.blog.title='';
		},function(d){
			alert("error while saving try after sometime");
		})
	}
	temp.getBlogDetail=function(){
		blogService.getBlogList()
		.then(function(d){
			
			temp.blogs=d;
			console.log(d)
		},function(d){
			alert("error happened try after sometime");
		})
	}
	temp.getBlogComments=function(){
		blogService.getAllComments()
		.then(function(d){
			temp.blogcomments=d;
		},function(e){
			alert("error occurred")
		})
	}
	temp.init=function(){
		temp.getBlogDetail();
		temp.getBlogComments();
	}
	temp.rejectBlog=function(id){
		temp.blog.id=id;
		blogService.rejectBlog(temp.blog)
		.then(function(d){
			alert(d.errorMessage)
		if(d.errorCode=="200"){
			temp.getNewBlogs();
		}	
		},function(){
			alert("error ocurred");
		})
		
	}
	temp.acceptBlog=function(id){
		temp.blog.id=id;
blogService.acceptBlog(temp.blog)
.then(function(d){
	alert(d.errorMessage);
	if(d.errorCode=="200"){
		temp.getNewBlogs();
	}
},function(){
	alert("error occured")
})
	}

}]);