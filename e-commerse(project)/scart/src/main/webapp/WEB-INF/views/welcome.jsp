<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<div class="well">
<c:set var="check" scope="application" value="${userstatus}"></c:set>
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
</c:if>
<h2 class="text-success text-center">${userloginstatus}</h2>
<h2 class="text-success text-center">${adminloginstatus}</h2>
</div>
</body>
</html>