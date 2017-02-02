myapp.factory("jobService",["$http",function($http){
	var url="http://localhost:8081/collabaration/";
return{
	getNewJobs:function(){
		return $http.get(url+'listofjobs')
		.then(function(d){
			return d.data;
		},function(d){
			return d.data;
		})
	},
	getSelectedJobDetail:function(id){
		return $http.get(url+'getjob/'+id)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})
	},
	applyForJob:function(id){
		return $http.post(url+'applyjob/'+id)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})
	},
	postJob:function(job){
		return $http.post(url+'savejob',job)
		.then(function(response){
			return response.data;
		},function(errResponse){
			return errResponse.data;
		})
		},
		appliedJobList:function(id){
			return $http.get(url+'appliedjobs/'+id)
			.then(function(response){
				return response.data;
			},function(errResponse){
				return errResponse.data;
			})
			},
			getAppliedUser:function(id){
				return $http.get(url+'appliedusers/'+id)
				.then(function(response){
					return response.data;
				},function(errResponse){
					return errResponse.data;
				})	
			},
			callForInterview:function(jobapplied){
				return $http.post(url+'callforinterview',jobapplied)
				.then(function(response){
					return response.data;
				},function(errResponse){
					return errResponse.data;
				})
			},
			rejectApplication:function(jobapplied){
				return $http.post(url+'rejectapplication',jobapplied)
				.then(function(response){
					return response.data;
				},function(errResponse){
					return errResponse.data;
				})
			}
	
}

}]);