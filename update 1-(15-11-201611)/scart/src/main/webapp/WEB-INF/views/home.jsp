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
  .container{margin-top:-20px;width:800px;}
  .carousel-control{background-color:none;color:wheat;}
  .row img{-webkit-transition:-webkit-transform 0.5s ease-in;}
  .row img:hover{width:212px;height:152px;}
  </style>
</head>
<body>
<div class="container">
<div id="mycarousel" class="carousel slide" data-ride="carousel">
<div class="carousel-inner" role="listbox">
<div class="item active">
<img src="<c:url value="/images/phone.jpg"/>">
</div> 
<div class="item">
<img src="<c:url value="/images/21.jpg"/>">
</div>  
<div class="item">
<img src="<c:url value="/images/ima.jpg"/>">
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
<br />
<br/>
<div class="row thumbnail">
<div class="col-xs-2">
<p class=" text-primary  text-center" style="padding-top:55px;height:150px;background-color:#ffffe6">Todays<br/>
 deal</p></div>
<div class=" col-xs-3" >
<a href="">
<img src="<c:url value="/images/pendrive.jpg"/>" width="200px" height="200px"><p>pendrive</p></a></div>
<div class="col-xs-3">
<a href="">
<img src="<c:url value="/images/books1.jpg"/>" width="200px" height="200px"><p>books</p></a></div>
<div class="col-xs-3">
<a  href="">
<img src="<c:url value="/images/watches.jpg"/>" width="200px" height="200px"><p>watch</p></a></div>
</div>
</body>
</html>