<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h3 class="text-center text-info">${cartdeletestatus}</h3>
<table class="table table-bordered">
<tr>
<th>CartId</th>
<th>Product_id</th>
<th>Product_name</th>
<th>Quantity</th>
<th>User</th>
<th>Price</th>
<th>Status (*)</th>
<th>SubTotal</th>
<th>Buying Option</th>
</tr>
<c:forEach items="${showallcart}" var="showallmycart">
<tr>
<td>${showallmycart.id}</td>
<td>${showallmycart.product_id}</td>
<td>${showallmycart.product_name}</td>
<td>${showallmycart.quantity}</td>
<td>${showallmycart.user}</td>
<td>${showallmycart.price}</td>
<td>${showallmycart.status}</td>
<td>${showallmycart.price*showallmycart.quantity}</td><td><c:if test="${showallmycart.status eq 'N' }"><a href="cart_checkout?uid=cart,${showallmycart.id}">buy</a> / <a href="_cartremovefromcart${showallmycart.id}">remove</a></c:if></td>
</tr></c:forEach>
<tr>
<td colspan="7" class="text-center">Total Amount for new items </td>
<td>${total}</td></tr>
</table>
<div class="col-xs-offset-8">
<p>* P-Purchased</p>
<p>* N-NewlyAdded</p>
</div>
<div>
<c:if test="${total!='0'}">
<a href="_cartbuyallnewitems" class=" col-xs-offset-4 btn btn-success">BuyAllNewItems</a></c:if>
</div>

</body>
</html>