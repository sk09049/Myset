myapp.controller("ChatForumController" , function($scope, ChatForumService,$rootScope,$location,friendService) {
	$scope.messages = [];
    $scope.message = "";
    $scope.max = 140;
    $scope.oldermessages=[];

    $scope.addMessage = function() {
    	console.log("addMessage")
    ChatForumService.send($rootScope.currentUser.id+","+$rootScope.friendId+","+$scope.message);
    	$scope.message = "";
    };
    $scope.getMessages=function(){
 	   friendService.getMessage($rootScope.currentUser.id)
 	   .then(function(d){
 		   $scope.oldermessages=d;
 	   },null)
    }
    $scope.setFriendId=function(x){
    	$rootScope.friendId=x;
    	$location.path("/chatforum");
    }
    ChatForumService.recieve().then(null , null, function(message) {
         console.log("recieve") 
         
       $scope.messages.push(message); 
         console.log($scope.messages)
    });
}); 