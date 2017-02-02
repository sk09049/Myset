myapp.controller("friendControl",["friendService","$rootScope","$location","$cookieStore","userService",function(friendService,$rootScope,$location,$cookieStore,userService){

	
	var temp=this;
	temp.requests=[];
	temp.myrequest=[];
	temp.myfriends=[];
	temp.friend={
			id:'',
			FriendId:'',
			UserId:'',
			status:'',
			errorCode:'',
			errorMessage:''
	}
	temp.users=[];
	temp.sendFriendRequest=function(id){
		friendService.sendRequest(id,$rootScope.currentUser.id)
		.then(function(d){
			alert(d.errorMessage);
		},null)
		
	}
	temp.listofusers=function(){
		userService.listuser()
		.then(function(d){
			temp.users=d;
			console.log(temp.users);
		},null)
	}
	temp.listofusers();
	//reject request
	
	temp.rejectrequst=function(id){
		friendService.reject(id,$rootScope.currentUser.id)
		.then(function(d){
			temp.friend=d;
			temp.getFriendRequests();
			friendService.getRequest($rootScope.currentUser.id)
			.then(function(d){
				if(d[0].errorCode=="200"){
				$rootScope.reqcount=d.length;
				}else if(d[0].errorCode=="404"){
					$rootScope.reqcount=0;
				}
			},null)
		},null)
			
		
	}
	temp.listofusers();
	temp.getFriendRequests=function(){
		friendService.getRequest($rootScope.currentUser.id)
		.then(function(d){
			temp.requests=d;

			console.log(temp.requests);
		},null)
			}
	if($rootScope.currentUser){
		temp.getFriendRequests();
	}
	temp.acceptRequest=function(id){
		friendService.accept($rootScope.currentUser.id,id)
		.then(function(res){
			if(res.errorCode=="200"){
				temp.friend=res;
				temp.getFriendRequests();
				friendService.getRequest($rootScope.currentUser.id)
				.then(function(d){
					if(d[0].errorCode=="200"){
					$rootScope.reqcount=d.length;
					}else if(d[0].errorCode=="404"){
						$rootScope.reqcount=0;
					}
				},null)
				
			}
			
		},null)
	}
	temp.getRequest=function(){
		friendService.getsendrequest($rootScope.currentUser.id)
		.then(function(d){
			temp.myrequest=d;
		},null)
	}
	temp.myfriendsid=function(){
		friendService.myfriends($rootScope.currentUser.id)
		.then(function(d){
			temp.myfriends=d;
		},null)
		
	}
}])
