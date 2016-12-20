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
<c:if test="${idnotexists}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-2 col-xs-7" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  sorry you are not allowed to update supplier id</p></div>
</c:if><c:if test="${updated}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-2 col-xs-7" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
 Supplier details Updated successfully </p></div>
</c:if><c:if test="${updateexeption}">
<div style="height:100px;background-color:#ffffff;width:60%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
sorry ! while updating supplier details some exception happens report us</p></div>
</c:if>
<c:if test="${supplierdeleted}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-2 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  Supplier detail deleted Successfully</p></div>
</c:if>
<c:if test="${idexists}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-3 col-xs-5" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Id already Exists try new one</p></div>
</c:if>
<c:if test="${added}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible  col-xs-offset-2 col-xs-7" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
new Supplier id with details added successfully</p></div>
</c:if>
<c:if test="${exception}">
<div style="height:100px;background-color:#ffffff;width:60%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Sorry Something  happens wrong while adding newSupplier, please report us </p></div>
</c:if>
<form:form action="adminaddsupplier" method="post" commandName="supplier"  >
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">Supplier Details</h3>
<form:input type="text" class="form-control" placeholder="enter supplier id" path="id" id="a" maxlength="20" required="true" onblur="idcheck()"/>
<p id="b" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:input type="text" class="form-control" placeholder="enter supplier name" path="name" maxlength="20" id="a1" required="true" onblur="namecheck()" />
<p id="b1" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<form:textarea  class="form-control" row="9" placeholder="enter supplier Address " id="a2" maxlength="100" path="address" required="true" onblur="adrscheck()" />
<p id="b2" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<form:button  type="submit" class=" col-xs-offset-4 col-xs-1 btn btn-primary" >Add</form:button>

<a href="adminupdatesupplier"><button  type="button" class=" col-xs-1 btn btn-success" >Update</button></a>

<a href="admindeletesupplier"><button  type="button" class=" col-xs-1 btn btn-warning" >delete</button></a>
</div>
</form:form>
<script>
function valform(){
	var fl=idcheck();
	var fl1=namecheck();
	var fl2=adrscheck();
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
function adrscheck(){
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