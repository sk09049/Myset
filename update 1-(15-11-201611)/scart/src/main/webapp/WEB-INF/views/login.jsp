<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
form{margin-top:20%;margin-left:30%;width:500px;}
.well{
background:Aqua;
}
</style>
</head>
<body>
${error}
${ha}

<form action="logincheck"  method="post" >
<div class="row well">
<div class="form-group">
username:<input  class="form-control" name="user"/><br></div>
<div class="form-group">
password:<input type="password"  class="form-control" name="pass"/></div>
<div class="form-group col-sm-2">
<input type="submit" class="btn btn-info"></div>
</div>
</form>
</body>
</html>