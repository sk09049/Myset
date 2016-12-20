<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<form action="adminupdatecategory" method="post" onsubmit="return valform()">
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">Edit Categories</h3>
<input type="text" class="form-control"   value="${selectedcategoryrow.id}" name="id" id="editcat-a1" required="true" onblur="idcheck()"/>
</div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<input type="text" class="form-control"  value="${selectedcategoryrow.name}" name="name" id="editcat-a2" required="true" onblur="namecheck()" />
</div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<input type="text" class="form-control"  value="${selectedcategoryrow.description}" name="description" id="editcat-a3" required="true" onblur="namecheck()" />
</div></div>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
<div class="row">
<button  type="submit" class=" col-xs-offset-5 col-xs-1 btn btn-primary">Update</button>
</div>
</form>
<script type="text/javascript">
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
	var a=document.getElementById("editcat-a1").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("editcat-a1").placeholder="field can't be empty";
		return fl;
	}else if(a.length>20){
		fl=1;
		document.getElementById("editcat-a1").value="";
		document.getElementById("editcat-a1").placeholder="field is more than 20 characters";
		return fl;
	}else if(fl==0){
		return fl;
	}
}
function namecheck(){
	var a=document.getElementById("editcat-a2").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("editcat-a2").placeholder="field can't be empty";
		return fl;
	}
	else if(a.length>20){
		document.getElementById("editcat-a2").value="";
		document.getElementById("editcat-a2").placeholder="field is more than 20 characters";
		return fl;
	}else if(fl==0){
		return fl;
	}
}
function dseccheck(){
	var a=document.getElementById("editcat-a3").value;
	var fl=0;
	if(a==null || a==""){
		fl=1;
		document.getElementById("editcat-a3").placeholder="field can't be empty";
		return fl;
	}else if(a.length>50){
		document.getElementById("editcat-a3").value="";
		document.getElementById("editcat-a3").placeholder="field is more than 50 characters";
		return fl;
	}else if(fl==0){
		return fl;
	}
}
</script>
</body>
</html>