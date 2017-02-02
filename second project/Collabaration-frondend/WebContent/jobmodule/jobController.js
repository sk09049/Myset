myapp.controller("jobControl",["jobService","$location","$rootScope","$cookieStore","$scope",function(jobService,$location,$rootScope,$cookieStore,$scope){
	
	var jobtemp=this;
	jobtemp.job={
			id:'',
			jobTitle:'',
			description:'',
			errorCode:'',
			errorMessage:'',
			status:'',
			qualification:'',
			date_time:''
	}
	jobtemp.jobapplied={
			id:'',
			job_id:'',
			status:'',
			remarks:'',
			user_id:'',
			date_applied:'',
				errorCode:'',
				errorMessage:''
	}
	jobtemp.callForInterview=function(id,uid){
		jobtemp.jobapplied.job_id=id;
		jobtemp.jobapplied.user_id=uid;
		jobService.callForInterview(jobtemp.jobapplied)
		.then(function(d){
			alert(d.errorMessage);
			if(d.errorCode=="200"){
				jobtemp.getAppliedUser(id);
				jobtemp.jobapplied.remarks='';

			}
		},null)
		
	}
	jobtemp.rejectApplication=function(id,uid){
		jobtemp.jobapplied.job_id=id;
		jobtemp.jobapplied.user_id=uid;
jobService.rejectApplication(jobtemp.jobapplied)
.then(function(d){
			alert(d.errorMessage);
			if(d.errorCode=="200"){
				jobtemp.getAppliedUser(id);
				jobtemp.jobapplied.remarks='';

			}
		},null)
	}
	jobtemp.jobs=[];
	jobtemp.appliedjobs=[];
	jobtemp.viewNewJobs=function(){
		jobService.getNewJobs()
		.then(function(d){
			jobtemp.jobs=d;
			console.log(d);
		},function(d){
			alert("error occured");
		})
	}
	jobtemp.fetchAllJobs=function(){
		jobService.getNewJobs()
		.then(function(d){
			jobtemp.jobs=d;
			console.log(d);
		},function(d){
			alert("error occured");
		})
	}
	jobtemp.fetchAllJobs();

	jobtemp.selectedJobDetails=function(id){
		jobService.getSelectedJobDetail(id).
		then(function(d){
			
			$rootScope.selectedJobDetail=d;
			$location.path("/selectedjob");
		},null)
		
	}
	jobtemp.applyForJob=function(id){
		if(id==undefined){
			return;
		}
		 jobtemp.currentuser="temp";
		 if($cookieStore.get('currentUser')){
			 if($rootScope.currentUser.role=='EMPLOYEE'){
				 alert("you are already employee so you can't apply");
				 return;
			 }
		jobtemp.currentuser=$cookieStore.get('currentUser');
		jobService.applyForJob(id)
		.then(function(response){
			alert(response.errorMessage);
		})
		
		 }
		if(jobtemp.currentuser=="temp"){
			$location.path("/login")
		}
	}
	//applied jobs
	jobtemp.appliedJobs=function(id){
		jobService.appliedJobList(id)
		.then(function(d){
			jobtemp.appliedjobs=d;
			console.log(jobtemp.appliedjobs);
			if(d.errorCode=="404"){
				alert("no job applied");
			}
		},null)
	}
	jobtemp.getAppliedUser=function(id){
		jobService.getAppliedUser(id)
		.then(function(res){
			$scope.appliedusers=res;
			console.log(res);
		},null)
	}
	//post a job
	jobtemp.postJob=function(){
		jobService.postJob(jobtemp.job)
		.then(function(res){
			jobtemp.job=res;
			if(res.errorCode=="200"){
				alert("job posted successfully");
				jobtemp.job.id='';
				jobtemp.job.jobTitle='';
				jobtemp.job.description='';
				jobtemp.job.qualification='';
			}else{
				alert(res.errorMessage);
			}
		},null)
	}
	
}]);