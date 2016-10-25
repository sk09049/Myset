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
<div class="container">
<nav class="navbar navbar-default">
<ul class="nav navbar-nav">
<li ><a href="#" >home</a></li>
<li ><a href="#" >Products</a></li>
<li ><a href="aboutus" >AboutUs</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
<c:if test="${ch}"><c:set var="s" scope="application" value="${0}"/></c:if>
<c:if test="${check2}"><c:set var="s" scope="application" value="${1}"/></c:if>
<c:if test="${ch1}"><c:set var="s" scope="application" value="${0}"/></c:if>
<c:if test="${s eq 0}">
<li><a href="login"><span class="glyphicon glyphicon-log-in"> &ensp;login</span></a></li>
</c:if>
<c:if test="${s eq 1}">
<li><a  href="logout"><span class="glyphicon glyphicon-log-out"></span> &ensp;logout</a></li>
<li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span>  &ensp;my cart</a></li></c:if>

</ul>
</nav>
</div>

</body>
</html>