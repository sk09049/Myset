package com.niit.project2.colloboration.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.project2.collaboration.dao.JobAppliedDao;
import com.niit.project2.collaboration.dao.JobDao;
import com.niit.project2.collaboration.model.Job;
import com.niit.project2.collaboration.model.JobApplied;

@RestController
public class JobController {
	private static Logger log=LoggerFactory.getLogger(JobController.class);
	@Autowired
	Job job;
	@Autowired
	JobDao jobdao;
	@Autowired
	JobApplied jobApplied;
	@Autowired
	JobAppliedDao jobapplieddao;
@RequestMapping("/listofjobs")
	public ResponseEntity<List<Job>> list(){
	log.debug("starting of method list of jobs");
	List<Job> list=jobdao.list();
	
	if(list.isEmpty()){
		job.setErrorCode("404");
		job.setErrorMessage("no record found");
		list.add(job);
	}else{
		for(Job a:list){
			a.setErrorCode("200");
			a.setErrorMessage("successfully job details retrived");
		}
	}
	log.debug("ending of method list of jobs");

	return new ResponseEntity<List<Job>>(list,HttpStatus.OK);
}

@RequestMapping(value="/savejob",method=RequestMethod.POST)
public ResponseEntity<Job> savejob(@RequestBody Job job){
	log.debug("starting of method save  jobs");

	System.out.println("entering");
	job.setStatus('N');
	job.setDate_time(new Date(System.currentTimeMillis()));
	String status=jobdao.save(job);
	if(status.equals("idexists")){
		job.setErrorCode("404");
		job.setErrorMessage("id already exists with this id:"+job.getId());
		
	}else if(status.equals("exception")){
		job.setErrorCode("404");
		job.setErrorMessage("error occured contact admin"); 
		
	}else if(status.equals("success")){
		job.setErrorCode("200");
		job.setErrorMessage("Job is successfully posted"); 
}
	log.debug("ending of method save  jobs");

	return new ResponseEntity<Job>(job,HttpStatus.OK);
}

@RequestMapping("/getjob/{id}")
public ResponseEntity<Job> getJob(@PathVariable("id") String id){
	log.debug("starting of method getjob by id  jobs");

	Job job=jobdao.get(id);
	if(job==null){
		job=new Job();
		job.setErrorCode("404");
		job.setErrorMessage("no record found");
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	job.setErrorCode("200");
	job.setErrorMessage("job details for the job id:"+job.getId());
	log.debug("ending of method getjob by id  jobs");

	return new ResponseEntity<Job>(job,HttpStatus.OK);
	
}

@RequestMapping(value="/applyjob/{id}",method=RequestMethod.POST)
public ResponseEntity<JobApplied> applyForJob(@PathVariable("id") String jobid,HttpSession session){
	
	String userid=(String) session.getAttribute("LoggedInUserId");
	System.out.println(userid);
	jobApplied=jobapplieddao.isJobApplied(jobid, userid);
	System.out.println("bzvjhzbjzbzvjb"+jobApplied);
	if(jobApplied!=null){
		System.out.println("entering");
		jobApplied.setErrorCode("404");
		jobApplied.setErrorMessage("you already applied for the job");
		return new ResponseEntity<JobApplied>(jobApplied,HttpStatus.OK);
	}
	jobApplied=new JobApplied();
	jobApplied.setDate_applied(new Date(System.currentTimeMillis()));
	String maxid=jobapplieddao.maxId();
	String []split=maxid.split("(?<=\\D)(?=\\d)");
	int temp=Integer.parseInt(split[1])+1;
	String tempid="";
	if(temp>9){
		tempid="jobapply"+temp;
	}else{
		tempid="jobapply0"+temp;
	}
	
	jobApplied.setId(tempid);
	jobApplied.setStatus("New");
	jobApplied.setRemarks("your application is waiting for approval");
	jobApplied.setJob_id(jobid);
	jobApplied.setUser_id(userid);
	boolean status=jobapplieddao.save(jobApplied);
	System.out.println(status+"fffffffffffffffff");
	if(status==false){
		jobApplied.setErrorCode("404");
		jobApplied.setErrorMessage("error while applying");
	}
	if(status==true){
		jobApplied.setErrorCode("200");
		jobApplied.setErrorMessage("successfully applied");

	}
	return new ResponseEntity<JobApplied>(jobApplied,HttpStatus.OK);
}
@RequestMapping("/appliedjobs/{id}")
public ResponseEntity<List<JobApplied>> appliedjobs(@PathVariable("id") String id){
	List<JobApplied> list=jobapplieddao.list(id);
	if(list.isEmpty()){
		jobApplied.setErrorCode("404");
		jobApplied.setErrorMessage("you are not applied for any job");
		list.add(jobApplied);
		return new ResponseEntity<List<JobApplied>>(list,HttpStatus.OK);
}
	for(JobApplied a:list){
		a.setErrorCode("200");
		a.setErrorMessage("details of your applied jobs");
	}
	return new ResponseEntity<List<JobApplied>>(list,HttpStatus.OK);
	
}
@RequestMapping("/appliedusers/{id}")
public ResponseEntity<List<JobApplied>> appliedusers(@PathVariable("id") String id){
	List<JobApplied> list=jobapplieddao.getapplieduser(id);
	if(list.isEmpty()){
		jobApplied.setErrorCode("404");
		jobApplied.setErrorMessage("No new users applied");
		list.add(jobApplied);
	}
	return new ResponseEntity<List<JobApplied>>(list,HttpStatus.OK);
}

@RequestMapping(value="callforinterview",method=RequestMethod.POST)
public ResponseEntity<JobApplied> callforinterview(@RequestBody JobApplied jobApplied){
	jobApplied=updateJobApllicationStatus(jobApplied, "A");
	return new ResponseEntity<JobApplied>(jobApplied,HttpStatus.OK);
}
@RequestMapping(value="rejectapplication",method=RequestMethod.POST)
public ResponseEntity<JobApplied> rejectjobApplication(@RequestBody JobApplied jobApplied){

	jobApplied=updateJobApllicationStatus(jobApplied, "R");

	return new ResponseEntity<JobApplied>(jobApplied,HttpStatus.OK);
}
private JobApplied updateJobApllicationStatus(JobApplied jobApplied,String status1){
	String remarks=jobApplied.getRemarks();
	jobApplied=jobapplieddao.isJobApplied(jobApplied.getJob_id(),jobApplied.getUser_id());
	if(jobApplied==null){
		jobApplied=new JobApplied();
		jobApplied.setErrorCode("404");
		jobApplied.setErrorMessage("No Record found some error ocurred ");
		return jobApplied;
}
	jobApplied.setRemarks(remarks);
	jobApplied.setStatus(status1);
	boolean status=jobapplieddao.update(jobApplied);
	if(status==true){
		jobApplied.setErrorCode("200");
		jobApplied.setErrorMessage("successfully send");
}else{
	jobApplied.setErrorCode("404");
	jobApplied.setErrorMessage("error while updating try after sometime");
	
}
	
	
	return jobApplied;
}

}


