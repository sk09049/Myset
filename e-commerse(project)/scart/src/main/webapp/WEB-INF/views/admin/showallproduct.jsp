<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<c:if test="${ not empty deletestatusimage}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${deletestatus}</p></div>
</c:if>
<c:if test="${ not empty deletestatus}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${deletestatus}</p></div>
</c:if>
<c:if test="${ not empty imageupdate}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-1 col-xs-11" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>${imageupdate}</p></div>
</c:if>

<table class="table table-bordered">
<tr>
<th>Id</th><th>Name</th><th>Description</th><th>Price</th>
<th>Image</th>
<th colspan="3" class="text-center">Edit/Delete Options</th>
</tr>
<c:forEach items="${productlist}" var="productlist">
<tr>
<td>${productlist.id}</td>
<td>${productlist.name}</td>
<td>${productlist.description}</td>
<td>${productlist.price}</td>
<td style="width:100px;"><img src="<c:url value="/images/${productlist.id}.jpg"/>" width="75px" height="75px"/></td>
<td style="width:50px;"><a href="adminupdateimaage${productlist.id}">UpdateImage</a></td>
<td style="width:50px;"><a href="adminupdateproducts${productlist.id}">UpdateProduct</a></td>
<td style="width:50px;"><a href="admindeleteproduct${productlist.id}">DeleteProduct</a></td>

</tr></c:forEach>
</table>
</body>
</html>