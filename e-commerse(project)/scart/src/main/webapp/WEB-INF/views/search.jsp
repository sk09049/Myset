<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style>
#div{cursor:pointer;width:150px;height:200px;display:inline;background-color:#ffffff;}
#img:hover{width:165px;height:165px;}
#containerforimage{width:150px;height:150px;overflow:hidden;}
</style></head>
<body>
<h2 class="text-center text-info">You searched for : ' ${searchvalue} '</h2>
<c:if test="${not empty message}">
<div class="jumbotron"><h2 class="text-center  text-warning">${message}</h2></div></c:if>
<div class="container">
<div class="row">
<c:forEach items="${serachlist}" var="searchproductdetails">
<div onclick="location.href='product${searchproductdetails.id}'" id="div" style="display:inline-block;margin-left:20px;">
<div id="containerforimage">
<img class="img-rounded" src="<c:url value="/images/${searchproductdetails.id }.jpg" />" width="150px" height="150px" id="img"/></div>
<p class="text-primary">${searchproductdetails.name}</p>
<p class="text-success">Rs.${searchproductdetails.price}</p></div>
</c:forEach></div></div>
</body>
</html>