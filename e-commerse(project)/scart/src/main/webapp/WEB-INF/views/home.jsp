<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <style>
  .carousel-control{background-color:none;color:wheat;}
  /*.row img{-webkit-transition:-webkit-transform 0.5s ease-in;}
  .row img:hover{width:212px;height:152px;}*/
.thumbnail span{color:red;}
.thumbnail{padding-top:10px;}
  </style>
</head>
<body>
<div class="row">
<div class="col-xs-1">
<span style="color:white;font-size: 25px;cursor:default;position:absolute;" onclick="document.getElementById('addimg1').style.display='none';" > &times;</span>
<a href="adimage" target="_blank"><img src="<c:url value="/images/ad1.jpg"/>" width="110px" 
height="400px"  id="addimg1"></a>
</div>
<div class="container col-xs-10">
<div id="mycarousel" class="carousel slide" data-ride="carousel">
<div class="carousel-inner" role="listbox">
<div class="item active">
<img src="<c:url value="/images/phone.jpg"/>" width="1070px">
</div> 
<div class="item">
<img src="<c:url value="/images/cam.jpg"/>" width="1070px">
</div>  
<div class="item">
<img src="<c:url value="/images/ima.jpg"/>" width="1070px">
</div> 
 </div>
    <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</div>
<div class="col-xs-1">
<span style="color:white;font-size: 25px;cursor:default;position:fixed;position:absolute;margin-left:-20px;" onclick="document.getElementById('addimg2').style.display='none';" > &times;</span>
<a href="adimage" target="_blank"><img src="<c:url value="/images/ad1.jpg"/>" width="113px" height="400px" id="addimg2" style="margin-left:-33px;">
</a>
</div>
</div>
<br />
<br/>
<div class="row  text-center" style="background:#ffffff;padding:10px;">
<div class="col-xs-2">
<h4 class=" text-primary" style="padding-top:35px;line-height:25px;height:155px;">Most<br>
Viewed<br>
Today</h4>
</div>
<c:forEach items="${top3}" var="top3products">
<div class=" col-xs-3 " >
<a href="product${top3products.id}">
<img src="<c:url value="/images/${top3products.id}.jpg"/>" class="img-rounded" width="200px" height="200px"><span><br>${top3products.name}</span></a>
</div> </c:forEach>
</div>
<br>
<br>
<div class="row" style="background:#ffffff;padding:10px;">
<h3 class="text-center text-primary">Products From Different Categories</h3>
<c:forEach items="${list}" var="category">
<c:forEach items="${category.product}" var="product" begin="1" end="1">
<div class=" col-xs-3 " >
<a href="product${product.id}">
<img src="<c:url value="/images/${product.id}.jpg"/>" class="img-rounded" width="200px" height="200px"><span><br>${category.name}</span></a>
</div>
</c:forEach>
</c:forEach>
</div>
</body>
</html>