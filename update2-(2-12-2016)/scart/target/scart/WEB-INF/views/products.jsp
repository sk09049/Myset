<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
<form:form action="addproduct" method="post" enctype="multipart/form-data" commandName="pro"  >
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">Add Products</h3>
<form:input type="text" class="form-control" placeholder="enter product id" path="id" id="a" required="true" onblur="idcheck()"/>
<p id="b" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="text" class="form-control" placeholder="enter product  name" path="name" id="a1" required="true" onblur="namecheck()" />
<p id="b1" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="text" class="form-control" placeholder="enter product price" path="price" id="a2" required="true" onblur="pricecheck()" />
<p id="b2" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="text" class="form-control" placeholder="enter product description" path="description" id="a3"  onblur="catidcheck()" />
<p id="b3" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="file" name="image" path="image" class="btn btn-success"></form:input></div></div> 
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:select  class="form-control" path="category_id" >
<c:forEach items="${list}" var="cat">
<option>${cat.id}</option></c:forEach></form:select>	
</div></div>
<div class="form-group col-xs-offset-4 col-xs-3">
<form:select  class="form-control" path="supplier_id" >
<c:forEach items="${supplierlist}" var="supplylist">
<option >${supplylist.id}</option></c:forEach></form:select>
</div>
<div class="row">
<form:button  type="submit" class=" col-xs-offset-4 col-xs-1 btn btn-primary" >Add</form:button>

<form:button  type="button" class=" col-xs-1 btn btn-success" >Update</form:button>

<form:button  type="button" class=" col-xs-1 btn btn-warning" >Delete</form:button>
</div>
</form:form>
<script>
function valform(){
	var fl=idcheck();
	var fl1=namecheck();
	var fl2=pricecheck();
	var fl3=catidcheck();
	if(fl==1){
		return false;
	}else if(fl1==1){
		return false;
	}
	else if(fl2==1){
		return false;
	}else if(fl3==1){
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
function pricecheck(){
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
function catidcheck(){
	var a=document.getElementById("a4").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("b4").innerHTML="field can't be empty";
		return fl;
	}else if(fl==0){
		document.getElementById("b4").innerHTML="";
		return fl;
	}
}
</script>
</body>
</html>