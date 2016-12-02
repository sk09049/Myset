<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set  var="showindividualproduct"  scope="application" value="${productdescription}"></c:set>
<div class="container" style="margin-top:200px;margin-left:200px;">
<div><img src="<c:url value="/images/${showindividualproduct.id}.jpg"/>" ></div>
<div class="text-primary">${showindividualproduct.id}</div>
<div class="text-primary">${showindividualproduct.name}</div>
<div class="text-primary">${showindividualproduct.price}</div>
<div class="text-primary">${showindividualproduct.description}</div></div>
<a href="cart_checkout" class="btn btn-success">Checkout</a>
</body>
</html>