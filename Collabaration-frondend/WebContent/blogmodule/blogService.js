myapp.factory("blogService",["$http",function($http){
	var url="http://localhost:8081/collabaration/";
return{
	saveBlog:function(blog){
		return $http.post(url+'saveblog',blog)
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})
	},
	getBlogList:function(){
		return $http.get(url+'acceptedblogs')
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})
	},
	saveComment:function(comment){
		return $http.post(url+'saveblogcomment',comment)
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})
	},
	getAllComments:function(){
		return $http.get(url+'blogcommentlist')
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})
	},
	getNewBlogs:function(){
		return $http.get(url+'newblogs')
		.then(function(res){
			return res.data;
		},function(res){
			alert("error ocuured")
		})
	},
	acceptBlog:function(blog){
		return $http.post(url+'approveblog',blog)
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})

	},
	rejectBlog:function(blog){
		return $http.post(url+'rejectblog',blog)
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})

	},
	getMyBlog:function(id){

		return $http.get(url+'getmyblogs/'+id)
		.then(function(res){
			return res.data;
		},function(res){
			alert("error while calling webservice")
		})
	}

}
}]);