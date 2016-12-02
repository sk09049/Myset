<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
</div>
</div>
<br />
<br/>
<div class="row thumbnail text-center">
<div class="col-xs-2">
<h4 class=" text-primary" style="padding-top:35px;line-height:25px;height:155px;">Most<br>
Viewed<br>
Today</h4>
</div>
<div class=" col-xs-3 " >
<a href="">
<img src="<c:url value="/images/pendrive.jpg"/>"  width="200px" height="200px"><span>pendrive</span></a></div>
<div class="col-xs-3 ">
<a href="">
<img src="<c:url value="/images/books1.jpg"/>" width="200px" height="200px"><span>books</span></a></div>
<div class="col-xs-3 ">
<a  href="">
<img src="<c:url value="/images/watches.jpg"/>" width="200px" height="200px"><span>watch</span></a></div>
</div>
</body>
</html>