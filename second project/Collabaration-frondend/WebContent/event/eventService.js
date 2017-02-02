myapp.factory("eventService",["$http",function($http){
	var url="http://localhost:8081/collabaration/";

	return{
		list:function(){
			return $http.get(url+'eventlist').
			then(function(res){
				return res.data;
			},function(err){
			return err.data;
			})
		},
		saveEvent:function(event){
			return $http.post(url+'saveevent',event)
			.then(function(res){
				return res.data;
			},function(err){
				return err.data;
			})
		}
	}
	
}])