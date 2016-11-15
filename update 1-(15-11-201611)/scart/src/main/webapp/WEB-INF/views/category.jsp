<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
.btn{margin-right:20px;}
h3{margin-top:100px;}
</style>
</head>
<body>
<form:form action="" method="post" commandName="cat"  >
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">Add Categories</h3>
<form:input type="text" class="form-control" placeholder="enter category id" path="id" id="a" required="true" onblur="idcheck()"/>
<p id="b" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="text" class="form-control" placeholder="enter category name" path="name" id="a1" required="true" onblur="namecheck()" />
<p id="b1" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:textarea  class="form-control" row="9" placeholder="enter category description" id="a2" path="description" required="true" onblur="dseccheck()" />
<p id="b2" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<form:button  type="button" class=" col-xs-offset-4 col-xs-1 btn btn-primary" >Add</form:button>

<form:button  type="button" class=" col-xs-1 btn btn-success" >Update</form:button>

<form:button  type="button" class=" col-xs-1 btn btn-warning" >Delete</form:button>
</div>
</form:form>
<script>
function valform(){
	var fl=idcheck();
	var fl1=namecheck();
	var fl2=dseccheck();
	if(fl==1){
		return false;
	}else if(fl1==1){
		return false;
	}
	else if(fl2==1){
		return false;
	}else return true;
}
function idcheck(){
	var a=document.getElementById("a").value;
	var fl=0;
	if(a==null || a==""){

		fl=1;
		document.getElementById("b").innerHTML="field can't be empty";
		return fl;
	}else if(fl==0){
		document.getElementById("b").innerHTML="";
		return fl;
	}
}
function namecheck(){
	var a=document.getElementById("a1").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("b1").innerHTML="field can't be empty";
		return fl;
	}else if(fl==0){
		document.getElementById("b1").innerHTML="";
		return fl;
	}
}
function dseccheck(){
	var a=document.getElementById("a2").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("b2").innerHTML="field can't be empty";
		return fl;
	}else if(fl==0){
		document.getElementById("b2").innerHTML="";
		return fl;
	}
}
</script>
</body>
</html>