myapp.controller("eventControl",["eventService",function(eventService){
	var self=this;
	self.date=Date.parse(new Date());
	self.parsing=function(id){
		return (Date.parse(id))
	}
self.event={
		id:'',
		eventTitle:'',
		date_time:'',
		eventDescription:'',
		errorCode:'',
		errorMessage:''
}	
self.events=[];
	self.eventList=function(){
console.log("event list method in controller started");
eventService.list()
	.then(function(d){
		console.log(d);
		self.events=d;
	},function(e){
		alert("error occured");
	})
}
	self.saveEvent=function(){
		alert(self.event.date_time)
		eventService.saveEvent(self.event)
		.then(function(d){
			self.event=d;
			self.event.date_time='';
			self.event.eventTitle="";
			self.event.eventDescription="";
		},function(d){
			alert("error occurred")
		})
			
		
	}
}])