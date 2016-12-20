<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
p{ margin-left:10px;font-size:10px;color:red;}
#top1{margin-top:10px;}
.form-control:focus{  outline: none;
  border: none;box-shadow: none ;border-bottom:2px solid violet;}
</style>
</head>
<body>
<h1>${erroruser}</h1>
<form:form action="welcome" method="post" commandName="reg"  onsubmit="return valform()">
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h4 id="top1" class="text-primary">Sign up</h4>
<h4  id="top" class="text-warning"></h4>
<form:input type="email" class="form-control" placeholder="enter email id" path="user" required="true" id="a" onblur="usernamecheck()"/>
<p id="b"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="password" class="form-control" placeholder="password" path="pass" required="true" id="a1"  onblur="passcheck()" />
<p id="b1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="password" class="form-control" placeholder="re enter password" path="repass" required="true" id="a2"  onblur="repasscheck()" />
<p id="b2"></p></div></div>
<div class="row">
<div class="form-group  col-xs-offset-4 col-xs-3">
<form:input type="text"  class="form-control" placeholder="phonenumber" path="phone" id="a3" required="true" onblur="phonecheck()"/>
<p id="b3"></p></div></div>
<div class="row">
<div class="form-group  col-xs-offset-4 col-xs-3">
<form:textarea class="form-control"  row="6" placeholder="enter your address" maxlength="50" path="address" id="a5" required="true" />
<p id="b5"></p></div></div>
<div class="row">
<div class="form-group  col-xs-offset-4 col-xs-3">
<form:input type="text"  class="form-control" placeholder="pincode" path="pincode" id="a4" required="true" onblur="pincheck()"/>
<p id="b4"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-1">
<input type="submit" class="form-control btn btn-primary" id="sub" value="submit" onsubmit="valform()" >
</div></div>
</form:form>

<script>
function valform(){
	var fl=usernamecheck();
	var fl1=passcheck();
	var fl3=phonecheck();
	var fl4=pincheck();
	if(fl==1){
		document.getElementById("top").innerHTML="fill the necessary fields";
		return false;
	}else if(fl1==1){
		document.getElementById("top").innerHTML="fill the necessary fields";
		return false;
	}else if(fl3==1){
		document.getElementById("top").innerHTML="fill the necessary fields";
		return false;
	}else if(fl4==1){
		document.getElementById("top").innerHTML="fill the necessary fields";
		return false;
	}else return true;
}

function usernamecheck(){
	var a=document.getElementById("a").value;
var fl=0;
	if(a==null || a==""){
		fl=1;
	document.getElementById("b").innerHTML="enter email id";	
	return fl;
	}
	if(a.length>25){
		fl=1;
		document.getElementById("b").innerHTML=" more than 25 charctres not allowed";	
return fl;
		}else if(fl==0){
			document.getElementById("b").innerHTML="";
			return fl;
		}
}
function passcheck(){
	var a=document.getElementById('a2').value;
	var pass=document.getElementById('a1').value;
	var fl=0;
	if(pass==null || pass==""){
	fl=1;
		document.getElementById("b1").innerHTML="password can't be empty";return fl;
}else if(pass.length<5 || pass.length>10){
		fl=1;
		document.getElementById("b1").innerHTML="password length  minimum 5 and maximum 10 characters ";return fl;
	}else if(a.length>5){
		repasscheck();
	}else if(fl==0){
		document.getElementById("b1").innerHTML="";return fl;
	}
	
}

function phonecheck(){
	var a=document.getElementById('a3').value;
	var fl=0;
	 if (a.length>10){
		fl=1;
		document.getElementById("b3").innerHTML="phone no is not more than 10 charcters";
		return fl;
	}
	 else if(a.match(/\d{10}/)==null){
		fl=1;
		document.getElementById("b3").innerHTML="phone no must have 10 digit nos only";
		return fl;
	}
	 else if (fl==0){
		document.getElementById("b3").innerHTML="";
		return fl;
	}
}
function pincheck(){
	var a=document.getElementById("a4").value;
	var fl=0;
	if(a.length!=6){
		fl=1;
		document.getElementById("b4").innerHTML="pincode must be 6 digits only";
		return fl;
	}else if(a.match(/\d{6}/)==null){
		fl=1;
		document.getElementById("b4").innerHTML="pincode must have 6 digit nos only";
		return fl;
	}else if(fl==0){
		document.getElementById("b4").innerHTML="";
		return fl;
	}
}
function  repasscheck(){
	var a=document.getElementById('a1').value;
	var pass=document.getElementById('a2').value;
	var fl=0;
	if(pass==null || pass==""){
	
		fl=1;
		document.getElementById("b2").innerHTML="password can't be empty";
		return fl;
		}
	else if(pass.length<5 || pass.length>10){
		fl=1;
		document.getElementById("b2").innerHTML="password length  minimum 5 and maximum 10 characters ";return fl;
	}else if(a!=pass){
		fl=1;
		document.getElementById("b1").innerHTML="password mismatch ";
		document.getElementById("b2").innerHTML="password mismatch ";
		return fl;
	}else if(fl==0){
		if(a==pass){
			document.getElementById("b1").innerHTML="";		
		}
		document.getElementById("b2").innerHTML="";
		return fl;
	
}
	
}
</script>
</body>
</html>