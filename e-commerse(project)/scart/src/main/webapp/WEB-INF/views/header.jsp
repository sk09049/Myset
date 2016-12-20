<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <style>
 .sam{position:fixed;margin-top:200px;background-color:wheat;border-radius:5px;width:30px;height:110px;padding-top:2px;-webkit-transition:width 2s,padding-left 2s;}
 .sam:hover{width:60px;padding-left:30px;}
 .sam>a>img{display:block;margin-top:10px;}
 .navbar a {
    color: white !important;
}
 /*#gh3{border-radius:5px;position:relative;color:white;animation-name:sara;animation-duration:4s;}
@keyframes sara{
0%{background-color:Aqua;transform:rotate(45deg);left:0px;right:0px;}
100%{transform:rotate(180deg);background-color:yellow;left:500px;top:0px;}
}*/
 nav{background-color:#3b74dc !important;margin-bottom:0px;}
 </style>
</head>
<body>
<c:set var="count" scope="application" value="${cartcount}"></c:set>
<c:if test="${ch}"><c:set var="s" scope="application" value="0"/></c:if>
<c:if test="${userlogcheck}"><c:set var="s" scope="application" value="1"/></c:if>
<c:if test="${adminlogcheck}"><c:set var="s" scope="application" value="2"/></c:if>
<nav class="navbar navbar-default">
<ol class="nav navbar-nav">
<li><a id="gh3" href="home" > &ensp; &ensp;Home</a></li>
<c:if test="${s eq 2 }">
<li ><a href="adminproduct" >Products</a></li>
<li ><a href="admincategory" >Category</a></li>
<li ><a href="adminsupply" >Supplier Details</a></li></c:if>
<li ><a href="aboutus" >AboutUs</a></li>
<li style="margin-top:10px;margin-left:400px;">
<form action="submitsearch"><input type="text" name="searchvalue" placeholder="search for products" ><input type="submit" value="search"></form></li>
</ol>

<ul class="nav navbar-nav navbar-right">


<c:if test="${s eq 0}">
<li><a href="register">signup</a></li>
<li><a href="loginjsp"><span class="glyphicon glyphicon-log-in"> &ensp;login &ensp; &ensp;</span></a></li>
</c:if>
<c:if test="${s eq 1}">
<li><a  href="logout"><span class="glyphicon glyphicon-log-out"></span> &ensp;logout</a></li>
<li><a href="_cartaddtocarttomycart"><span class="glyphicon glyphicon-shopping-cart"></span>  &ensp;my cart <c:if test="${count > 0 }">(${cartcount})</c:if></a></li></c:if>
<c:if test="${s eq 2}">
<li><a
  href="logout"><span class="glyphicon glyphicon-log-out"></span> &ensp;logout</a></li>
</c:if>


</ul>

</nav>

<div class="sam" style="margin-bottom:10px;">
<a href="https://github.com/sk09049" target=_blank><img src="<c:url value="/images/github.jpg"/>" class="img-rounded"></a>
<a href="https://www.facebook.com/" target=_blank><img src="<c:url value="/images/facebook.jpg" />" class="img-rounded"></a>
<a href="https://twitter.com/login" target=_blank><img src="<c:url value="/images/twitter.jpg"/>" class="img-rounded"></a>
</div>
</body>
</html>