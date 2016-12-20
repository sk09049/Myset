<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.btn{margin-right:20px;}
h3{margin-top:100px;}
</style>
</head>
<body>

<c:if test="${ not empty savestatusimage}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${savestatusimage}</p></div>
</c:if>
<c:if test="${ not empty savestatus}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${savestatus}</p></div>
</c:if>
<c:if test="${ not empty productupdatestatus}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-9" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${productupdatestatus}</p></div>
</c:if>
<form:form action="adminaddproduct?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" commandName="pro" onsubmit="return valform();" >
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
<form:input type="file" name="image" path="image" class="btn btn-success" required="true"></form:input></div></div> 
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

<a href="adminupdateproduct"><form:button  type="button" class="col-md-2 btn btn-success" >Manage Product</form:button></a>
</div>
</form:form>
<script>
function valform(){
	var fl=idcheck();
	var fl1=namecheck();
	var fl2=pricecheck();
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
	}if(a.lenght>20){
		fl=1;
		document.getElementById("b").innerHTML="id must be less than 20 characters";
		return fl;	
	}
	if(fl==0){
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
	}
	if(a.length>20){
		fl=1;
		document.getElementById("b1").innerHTML="id must be less than 20 characters";
		return fl;	
	}if(fl==0){
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
	}if(a.length>17){
		fl=1;
		document.getElementById("b2").innerHTML="id must be less than 17 characters";
		return fl;	
	}
	if(a.match(/^\d+$/)==null){
		fl=1
		document.getElementById('b2').innerHTML="field  must have nos only";
return fl;
	}if(fl==0){
		document.getElementById("b2").innerHTML="";
		return fl;
	}
}

</script>
</body>
</html>