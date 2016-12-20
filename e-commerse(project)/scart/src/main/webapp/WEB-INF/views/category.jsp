<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<style>
.btn {
margin-right:20px;
}

h3 {
margin-top:80px;
}
</style>
</head>
<body>
<c:if test="${idexist}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-3 col-xs-5" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Id already Exists change the Id</p></div>
</c:if>
<c:if test="${added}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-3 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Successfully a new category added</p></div>
</c:if>
<c:if test="${exception}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-3 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Sorry Some exception happens report us </p></div>
</c:if>
<c:if test="${deltetcategory}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-3 col-xs-5" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Category Deleted Successfully</p></div>
</c:if>
<c:if test="${ not empty updatecategoryresult}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-3 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${updatecategoryresult}
</p></div></c:if>
<form:form action="adminaddcategory" method="post" commandName="cat" onsubmit="return valform()" >
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">Add Categories</h3>
<form:input type="text" class="form-control"  placeholder="enter category id"  path="id" id="cat-a1" required="true" onblur="idcheck()"/>
</div>
</div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="text" class="form-control"  placeholder="enter category name" path="name" id="cat-a2" required="true" onblur="namecheck()" />
</div>
</div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:textarea  class="form-control" row="9"  id="cat-a3" placeholder="enter description" path="description" required="true" onblur="dseccheck()" ></form:textarea>
</div>
</div>
<div class="row">
<button  type="submit" class=" col-xs-offset-5 col-xs-1 btn btn-primary">Add</button>
<a href="adminupdatecategories"><button  type="button" class=" col-xs-1 btn btn-success" >Update</button></a>
<a href="admindeletecategory"><button  type="button" class=" col-xs-1 btn btn-success" >Delete</button></a>
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
	var a=document.getElementById("cat-a1").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("cat-a1").placeholder="field can't be empty";
		return fl;
	}else if(a.length>20){
		fl=1;
		document.getElementById("cat-a1").value="";
		document.getElementById("cat-a1").placeholder="field is more than 20 characters";
		return fl;
	}else if(fl==0){
		return fl;
	}
}
function namecheck(){
	var a=document.getElementById("cat-a2").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("cat-a2").placeholder="field can't be empty";
		return fl;
	}
	else if(a.length>20){
		document.getElementById("cat-a2").value="";
		document.getElementById("cat-a2").placeholder="field is more than 20 characters";
		return fl;
	}else if(fl==0){
		return fl;
	}
}
function dseccheck(){
	var a=document.getElementById("cat-a3").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("cat-a3").placeholder="field can't be empty";
		return fl;
	}else if(a.length>50){
		document.getElementById("cat-a3").value="";
		document.getElementById("cat-a3").placeholder="field is more than 50 characters";
		return fl;
	}else if(fl==0){
		return fl;
	}
}
</script>
</body>
</html>