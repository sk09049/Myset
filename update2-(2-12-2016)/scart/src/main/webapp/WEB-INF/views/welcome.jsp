<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="well col-xs-offset-4 col-xs-3">
${error}
<c:set var="check" scope="application" value="${error}"></c:set>
<c:if test="${check eq 4}">
<h1>welcome ${employee.user}</h1>
<p class="text-success">you are successfully registered</p> 
<p>login to your account to purchase </p>
</c:if>
<c:if test="${check eq 1}">
<p class="text-warning">Sorry userId Already exists</p> 
<p>Try again</p>
</c:if>

<c:if test="${check eq 3}">
<p class="text-warning">Sorry we can't process </p> 
<p>Try after sometime</p>
</c:if></div>
</body>
</html>