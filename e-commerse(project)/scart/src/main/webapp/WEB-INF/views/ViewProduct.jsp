<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<c:set  var="showindividualproduct"  scope="application" value="${productdescription}"></c:set>
<c:set  var="userid"  scope="application" value="${currentuser}"></c:set>
<div class="container" style="margin-top:10%;margin-left:40%;">
<div><img  class="img-rounded" src="<c:url value="/images/${showindividualproduct.id}.jpg"/>" width="200px" height="200px"></div>
<div class="text-primary" style="margin-top:1%;">Product Id&ensp;&ensp;&ensp;&ensp;: ${showindividualproduct.id}</div>
<div class="text-primary">Product Name : ${showindividualproduct.name}</div>
<div class="text-primary">Product Price &ensp;: Rs.${showindividualproduct.price}</div>
<form action="_cartaddtocart${showindividualproduct.id}/${userid}" method="post">
<p class="text-info"> Quantity :<input type="text" value="1" id="kl"name="quantity" style="width:30px;"></p>
<button type="submit" class="btn btn-success col-xs-offset-1">add to cart</button>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<a href=''  class="btn btn-success" onclick="this.href='cart_checkout?uid=${showindividualproduct.id},'+document.getElementById('kl').value">Proceed</a>
</form></div>

</body>
</html>