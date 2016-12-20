<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
input[type="text"]{
border-radius:5px;
border:.05px solid black;
height:25px;}
.blink{
text-decoration:none;
color:white;
margin-left:70px;
background-color: #47d147;
width:70px;
height:35px;padding:5px;
border-radius:5px;}
.alink{
margin-left:75px;
color:white;
text-decoration:none;
border:2px solid blue;
border-radius:3px;
padding:5px;
background-color: #0000ff;}
p{
color:red;
margin-left:150px;
font-style:oblique;
font-size:10px;
}
</style>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<h1 style="color:green;margin-left:300px;">Enter Your Card Details</h1>
<h3 id="top" style="margin-left:300px;color:red;"></h3>
<form style="border:2px solid black;padding:10px;margin-left:300px;width:500px;" onsubmit="return validateform();">
<span>Enter card no:</span>&ensp;&ensp;<input type="text" autocomplete="off" required="true" placeholder=" enter card no" id="card_a1" onblur="nocheck()"/>
<p id="card_b1"></p>
<span>Valid Upto:</span>&ensp;&ensp;&ensp;&ensp;&ensp;
<input type="text"   autocomplete="off" placeholder="month" id="card_a2" onblur="monthcheck()" style="width:50px;"/>&ensp;/
<input type="text"  placeholder="year" id="card_a3" autocomplete="off"  onblur="yearcheck()" style="width:50px";/>
<p id="card_b2" ></p>
<p id="card_b3" ></p>

<span>Customer Name:</span><input type="text" id="card_a4"  autocomplete="off" placeholder="enter customer name" onblur="namecheck()">
<p id="card_b4"></p>
<span>Enter CVV no:</span>&ensp;&ensp;<input type="text"  autocomplete="off" placeholder="enter cvv no" id="card_a5" onblur="cvvcheck()"/>
<p id="card_b5"></p>
<a href="${flowExecutionUrl}&_eventId=back" class="alink">back</a> 
<a href="${flowExecutionUrl}&_eventId=confirm" class="blink" onclick="return validateform()">confirm</a>
<a href="${flowExecutionUrl}&_eventId=cancel" class="alink">cancel</a>
</form>
<script type="text/javascript">
function validateform(){
	var fl=nocheck();
	var fl1= monthcheck();
	var fl3=yearcheck();
	var fl4=namecheck();
	var fl5=cvvcheck();
	if(fl==1){
		document.getElementById("top").innerHTML="fill the necessary fields correctly";
		return false;
	}else if(fl1==1){
		document.getElementById("top").innerHTML="fill the necessary fields correctly";
		return false;
	}else if(fl3==1){
		document.getElementById("top").innerHTML="fill the necessary fields correctly";
		return false;
	}else if(fl4==1){
		document.getElementById("top").innerHTML="fill the necessary fields correctly";
		return false;
	}else if(fl5==1){
		document.getElementById("top").innerHTML="fill the necessary fields correctly";
		return false;
	}else if(fl6==1){
		document.getElementById("top").innerHTML="fill the necessary fields correctly";
		return false;
	}else 
		return true;
}
function nocheck(){
	var a=document.getElementById('card_a1').value;
	var fl=0;
if(a.length=="" || a.length==null){
	fl=1;
	document.getElementById('card_b1').innerHTML="field must not be empty";
return fl;
}if(a.match(/^\d+$/)==null){
	fl=1;
	document.getElementById('card_b1').innerHTML="field must have digits only";
return fl;	
}if(a.length!=16){
	fl=1;
	document.getElementById('card_b1').innerHTML="field must have 16 characters";
return fl;
}if(fl==0){
	document.getElementById('card_b1').innerHTML="";
	return fl;
}
}
function monthcheck(){
	var a=document.getElementById('card_a2').value;
	var fl=0;
	if(a.length==null || a.length==""){
		fl=1;
		document.getElementById('card_b2').innerHTML="field must not be empty";
return fl;
	}
	if(a.length>2){
		fl=1;
		document.getElementById('card_b2').innerHTML="field must not have more than 2 characters";
	return fl;
	}if(a.match(/^\d+$/)==null){
	fl=1;
	document.getElementById('card_b2').innerHTML="field must have digits only";
return fl;	
}if(a>12){
	fl=1;
	document.getElementById('card_b2').innerHTML="month range is 1 to 12 only";
return fl;
}if(fl==0){
	document.getElementById('card_b2').innerHTML="";
	return fl;
}
}
function yearcheck(){
	var a=document.getElementById('card_a3').value;
	var fl=0;
	if(a.length==null || a.length==""){
		fl=1;
		document.getElementById('card_b3').innerHTML=" year field must not be empty";
return fl;
	}
	if(a.length!=2){
		fl=1;
		document.getElementById('card_b3').innerHTML="enter last 2 digits of year e.g(2001 as 01)";
	return fl;
	}if(a.match(/^\d+$/)==null){
	fl=1;
	document.getElementById('card_b3').innerHTML="field must have digits only";
return fl;	
}
if(fl==0){
	document.getElementById('card_b3').innerHTML="";
	return fl;
}	
}
function namecheck(){
	var a=document.getElementById('card_a4').value;
	var fl=0;
	if(a.length==null || a.length==""){
		fl=1;
		document.getElementById('card_b4').innerHTML="field must not be empty";
return fl;
	}
	if(a.match(/^[A-Za-z\s]+$/)==null){//+ symbol allow empty spaces
	fl=1;
	document.getElementById('card_b4').innerHTML="field must have letters only e.g(A-za-Z only)";
return fl;	
}
if(fl==0){
	document.getElementById('card_b4').innerHTML="";
	return fl;
}
}
function cvvcheck(){
	var a=document.getElementById('card_a5').value;
	var fl=0;
	if(a.length==null || a.length==""){
		fl=1;
		document.getElementById('card_b5').innerHTML=" year field must not be empty";
return fl;
	}if(a.match(/^\d+$/)==null){
		fl=1;
		document.getElementById('card_b5').innerHTML="field must have digits only";
	return fl;	
	}
	if(a.length!=3){
		fl=1;
		document.getElementById('card_b5').innerHTML="filed must have 3 digits only";
	return fl;
	}
if(fl==0){
	document.getElementById('card_b5').innerHTML="";
	return fl;
}	
}
</script>
</body>
</html>