myapp.directive("fileread", [function () {
    return {
        scope: {
            fileread: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileread = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}]);
myapp.controller("userController",['$http','userService','$rootScope','$location','$scope','$cookieStore','friendService',function($http,userService,$rootScope,$location,$scope,$cookieStore,friendService){
	var temp=this;
	temp.user={
			id:'',
			name:'',
			password:'',
			mobile:'',
			email:'',
			address:'',
			reason:'',
			role:'',
			is_online:'',
			status:'',
			errorMessage:'',
			errorCode:'',
			otp:''
			
}
	temp.otp="";
	temp.getOtp=function(){
		userService.getOtp(temp.user.id)
		.then(function(d){
			console.log(d);
			alert(d);
		},null)
	}
	temp.uploadImage=function(){
		alert(typeof($scope.uploadme));
		userService.upload($scope.uploadme);

	}
	temp.otpCheck=function(){
		userService.getOtpfromdb(temp.otp,temp.user.id)
		.then(function(d){
			if(d.errorCode=="200"){
			temp.user=d;
			temp.user.id='';
			temp.user.password='';
			}
			alert(d.errorMessage)
		},function(e){
			alert("error ocuured")
		})
		alert(temp.otp+""+temp.user.otp)
		if(temp.otp==temp.user.otp){
			alert("otp matched");
		}
	}
	temp.reason="";
	temp.users=[];
//logout	
	temp.logout=function(){
		$cookieStore.remove('currentUser');
		console.log($rootScope.currentUser);
		userService.logout()
		.then(function(d){
			if(d.errorCode=="200"){	
				$rootScope.reqcount=0;
				temp.user=d;
				$rootScope.currentUser=null;
				$location.path("/login")
			}
			else{
				$scope.logoutmsg=d.errorMessage;
				$location.path("/login")

			}
		})
	}
	//login
temp.myclick=function(){
console.log(temp.user);
	userService.validate(temp.user)
	.then(function(d){
		console.log(d.data);
		temp.user=d;
		if(d.errorCode=="200"){
			$rootScope.currentUser=temp.user;
			console.log($rootScope.currentUser);
			$http.defaults.headers.common['Authorization'] = 'Basic'+$rootScope.currentUser;
			$cookieStore.put('currentUser',$rootScope.currentUser);
			friendService.getRequest($rootScope.currentUser.id)
			.then(function(d){
				if(d[0].errorCode=="200"){
				$rootScope.reqcount=d.length;
				}
			},null)
			$location.path("/")
		}else if(d.errorCode=="405"){
			temp.user=d;
			alert(d.errorMessage);
			alert(d.errorCode)
		}
		else {
			temp.user.id="";
			temp.user.password="";
			alert(d.errorMessage);

		}
		console.log("done");
	})
}
//register
temp.register=function(){
	console.log("register started in controller");
	console.log(temp.user);
	userService.saveNewUser(temp.user)
	.then(function(d){
		if(d.errorCode=="200"){
			console.log(d)
		$rootScope.savedetails=d;
		alert("sucessfully saved");
		}
		else {
			alert("could not save");
		}
		$location.path("/");
	},function(err){
		alert("error while saving");
		$rootScope.savedetails=err;
	})
}
//new users not approved yet
temp.newUserDeails=function(){
	console.log("new user in controller started");
	userService.getNewUser()
	.then(function(da){
		$rootScope.newusers=da;
		console.log(da);
		$location.path("/newusers");

	},function(e){
		alert("error when getting datas");
		
	})
}
temp.editProfile=function(){
var pass=$rootScope.currentUser.password;

	var user=$rootScope.currentUser;
	alert("root1"+$rootScope.currentUser.password);

	user.name=document.getElementById('ea1').value;
	user.password=document.getElementById('ea2').value;
	user.mobile=document.getElementById('ea3').value;
	user.address=document.getElementById('ea4').value;
	user.email=document.getElementById('ea5').value;
	if(user.password==''){
		alert("rootch"+$rootScope.currentUser.password);

		user.password=pass;
	}
	alert("root2"+$rootScope.currentUser.password);


	userService.editProfile(user)
	.then(function(d){
		alert(d.errorMessage)
		if(d.errorCode=="200"){
			alert("new pass:"+user.password);
			alert("rootscope :"+$rootScope.currentUser.password);
			if(user.password==pass){
				user.password='';
			}
			$rootScope.currentUser=d;
			$cookieStore.put('currentUser',$rootScope.currentUser);
if(user.password!=''){
temp.logout();
alert("login with new password");
}else{
	$location.path("/");

}
		}
	},null)
}
//id availability check before register
temp.check=function(){
	userService.completeuserlist()
	.then(function(d){
		var count=0;
		d.forEach(function(x){
if(x.id==temp.user.id){
	count=1;
	temp.user.id='';
	document.getElementById('a1').innerHTML="Id Exists try new";
}
})
if(count==0){
	document.getElementById('a1').innerHTML="";

}
		console.log(d);
	},null)
}

//email availability check
temp.emailcheck=function(){
	
	
	userService.completeuserlist()
	.then(function(d){
		var count=0;
		d.forEach(function(x){
			if(x.email==temp.user.email){
				count=1;
				temp.user.email='';
				document.getElementById('a2').innerHTML="EmailId  Already Exists try new";
			}
			})
			if(count==0){
				document.getElementById('a2').innerHTML="";

			}
					console.log(d);

		
	},null)
}


	

temp.newUserApproval=function(userid){
	userService.approve(userid)
	.then(function(d){
		console.log(d);
		if(d.errorCode=="200"){
			$rootScope.newusers=d;
			$scope.approvalstatus=d.errorMessage;
		}else{
		alert("cannot authenticate now try later");	
		}
	},null)
}

//reject new user
temp.setMyvalue=function(id){
	$scope.myvalue=id;
}
temp.newUserReject=function(){
	alert($scope.myvalue+","+temp.reason);
	userService.rejectNewUser($scope.myvalue,temp.reason)
	.then(function(d){
		if(d.errorCode=="200"){
	    $scope.myvalue='';
        $scope.rejectmsg=d.errorMessage;
		}
		else {
			alert(d.errorMessage);
		}
	},function(){
		alert("error while reject user contact admin")
	})
}
temp.onFileSelect = function($files) {
	  Upload.upload({
		    url: 'my/upload/url',
		    file: $files,            
		  }).progress(function(e) {
		  }).then(function(data, status, headers, config) {
		    // file is uploaded successfully
		    console.log(data);
		  }); 
}
}]);