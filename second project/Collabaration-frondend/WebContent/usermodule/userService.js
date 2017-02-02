myapp.factory('userService',['$http',"$rootScope",function($http,$rootScope){
	var url="http://localhost:8081/collabaration/";
	return {
		fileUpload:function(file){
			alert("service")
	        var fd = new FormData();
	        fd.append('file', file);
	        return $http.post(url+'upload',fd)
	        .then(function(d){
	        	alert(d);
	        	console.log(d);
	        },function(d){
	        	alert("error");
	        })
	       
		},
		upload:function(up){
			return $http.post(url+'upload',up+"?"+$rootScope.currentUser.id)
			alert("service");
		},
		validate:function(user){
			return $http.post(url+'login',user)
			.then(function(response){
				return response.data;
			},function(errorresponse){
				alert("error");
				return errorresponse.data;
			})
		},
	logout:function(){
		return $http.get(url+'logout')
		.then(function(response){
			return response.data;
		},function(err){
			alert("error while logout");
			return err.data;
		})
	},
	saveNewUser:function(user){
		return $http.post(url+'register',user)
		.then(function(response){
			return response.data;
		},function(err){
			return err.data;
		})

	},
	getNewUser:function(){
		return $http.get(url+'newuser')
		.then(function(response){

			return response.data;
		},function(error){
			alert("service error");

			return error.data;
		})

	},
	approve:function(id){
		return $http.post(url+'autenticate/'+id)
		.then(function(response){
			return response.data;
		},function(err){
			return err.data;
		})
	},
	listuser:function(){
		return $http.get(url+'list')
		.then(function(response){
			return response.data;
		},function(err){
			return err.data;
		})
	},
	completeuserlist:function(){
		return $http.get(url+'completeuserlist')
		.then(function(response){
			return response.data;
		},function(err){
			return err.data;
		})
	},
	rejectNewUser:function(id,reason){
		return $http.post(url+'reject/'+id+'/'+reason)
		.then(function(response){
			return response.data;
		},function(err){
			return err.data;
		})	
	},
	get:function(id){
		return $http.post(url+'get/'+id)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})
	},
	getOtp:function(id){
		return $http.post(url+'mailcheck/'+id)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})
	},
	getOtpfromdb:function(otp,id){
		return $http.post(url+'matchotp/'+otp+'/'+id)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})

	},
	editProfile:function(user){
		return $http.post(url+'/editprofile',user)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})
	}
		
	}
}]);