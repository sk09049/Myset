<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<style>
#form{margin-top:15%;margin-left:30%;width:500px;}
.well{background:#c1f1ec;}
</style>
</head>
<body>
<h2 class="text-danger text-center">${userloginstatus}</h2>
<form id="form" action="login"  method="post" >
<div class="row well">
<div class="form-group">
username:<input  class="form-control" name="user" placeholder="enter email id"/><br></div>
<div class="form-group">
password:<input type="password"  class="form-control" name="pass" placeholder="enter password"/></div>
<div class="form-group col-sm-2">
<input type="submit" class="btn btn-info" value="login"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>
</body>
</html>
