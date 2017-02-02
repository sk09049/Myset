var myapp=angular.module("my",["ngRoute","ngCookies"]);
myapp.config(function($routeProvider){
$routeProvider
.when("/",{
    templateUrl : "view/home.html"
	})
.when("/welcome", {
	
    templateUrl : "view/welcome.html"
})
.when("/chat", {
	
    templateUrl : "chatmodule/chat.html",
    controller:'ChatController'
})
.when("/login",{
    templateUrl : "view/login.html",
	controller:"userController"

})
.when("/register",{
    templateUrl : "usermodule/register.html",
    	controller:"userController"
	})
	.when("/chatforum",{
    templateUrl : "onetoonechat/chat_forum.html",
    	controller:"ChatForumController"
	})
.when("/editprofile",{
    templateUrl : "usermodule/editprofile.html",
    	controller:"userController"
	

})
.when("/newusers",{
    templateUrl : "usermodule/newusers.html",
    	controller:"userController"

	
}).when("/showjob",{
    templateUrl : "jobmodule/showjobs.html",
    controller:'jobControl'


}).when("/selectedjob",{
    templateUrl : "jobmodule/selectedjob.html",
    controller:'jobControl'

}).when("/postjob",{
    templateUrl : "jobmodule/postjob.html"

}).when("/applied",{
    templateUrl : "jobmodule/appliedjobs.html"

}).when("/friends",{
    templateUrl : "friendmodule/friends.html"

}).when("/friendrequest",{
    templateUrl : "friendmodule/friendrequests.html"

}).when("/myrequest",{
    templateUrl : "friendmodule/myrequest.html",
    controller:'friendControl'

}).when("/myfriends",{
    templateUrl : "friendmodule/myfriends.html",
    controller:'friendControl'

}).when("/createblog",{
    templateUrl : "blogmodule/blog.html",
    controller:'blogControl'
})
.when("/viewblog",{
    templateUrl : "blogmodule/viewblog.html",
    controller:'blogControl'
})
.when("/upload",{
    templateUrl : "usermodule/uploadimage.html",
    controller:'userController'
})
.when("/event",{
	templateUrl:"event/event.html",
	controller:'eventControl'
})
.when("/postevent",{
	templateUrl:"event/postEvent.html",
	controller:'eventControl'

})
.when("/newblogs",{
	templateUrl:"blogmodule/newblogs.html",
	controller:'blogControl'

})
.when("/myblog",{
	templateUrl:"blogmodule/myblog.html",
	controller:'blogControl'
})
.otherwise({redirectTo: '/'})


});


myapp.run( function ($rootScope, $location,$cookieStore, $http) {
	
	var history = [];

    $rootScope.$on('$routeChangeSuccess', function() {
        history.push($location.$$path);
    });

    $rootScope.back = function () {
        var prevUrl = history.length > 1 ? history.splice(-2)[0] : "/";
        $location.path(prevUrl);
    };
	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
		 var userrestricted=!($.inArray($location.path(),['/postjob','/newusers','/postevent','/newblogs'])===-1);
		var restricted=$.inArray($location.path(),['','/','/login','/register','/showjob','/selectedjob','/viewblog','/event'])===-1;
	     var loggedIn = $rootScope.currentUser.id;
	    var role=$rootScope.currentUser.role;
	     if(!loggedIn){
	    	 if(restricted){
	    		 alert("you have to login")
	    		 $location.path("/login");
	    	 }
	    	 
	     }else{
	    	 if(userrestricted && role!='ADMIN'){
	    		 alert("you have to login as admin");
	    		 $rootScope.back();
	    	 }
	     }
	 
	 
	 });
    $rootScope.currentUser = $cookieStore.get('currentUser') || {};
    if ($rootScope.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser; 
    }

	
});
