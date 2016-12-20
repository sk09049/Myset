<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<c:if test="${ not empty updateimage}">
<div class="col-xs-offset-4" style="margin-top:200x;">
<p class="text-primary lead">Current Image</p>
<img class=" img img-circle" src="<c:url value="images/${updateimage}.jpg"/>" width="200px" height="200px" >
</div>
<form action="adminupdateselectedimage${updateimage}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data"">
<div class="col-xs-offset-4 col-xs-6">
<p class="text-primary lead">To Change the Image Click the Browse Button</p>
<input type="file"  class="btn btn-info" name="image" style="margin-top:30px;margin-bottom:20px;" >
<input type="submit" class="btn btn-info" value="upload image">
</div>
</form>
</c:if>
<c:if test="${empty updateimage }">
<h3 class="text-success col-xs-offset-3" style="margin-top:50px;">Edit / Update the Product Details</h3>
<form action="adminsubmitupdatedetails" method="post">
<div class="row">
<div class="form-group col-xs-offset-3 col-xs-3">
<input type="text" class="form-control" value="${singlerowdetailofproduct.id}" name="id"></div></div>
<div class="row">
<div class="form-group col-xs-offset-3 col-xs-3">
<input type="text"  class="form-control" value="${singlerowdetailofproduct.name}" name="name"></div></div>
<div class="row">
<div class="form-group col-xs-offset-3 col-xs-3">
<input type="text" class="form-control" value="${singlerowdetailofproduct.description}" name="description"></div></div>
<div class="row">
<div class="form-group col-xs-offset-3 col-xs-3">
<input type="text" class="form-control" value="${singlerowdetailofproduct.price}" name="price"></div></div>
<div class="row">
<div class="form-group col-xs-offset-3 col-xs-3">
<select  class="form-control" name="category_id" >
<option>${singlerowdetailofproduct.category_id}</option>
<c:forEach items="${list}" var="cat">
<option>${cat.id}</option></c:forEach></select>	</div></div>
<div class="row">
<div class="form-group col-xs-offset-3 col-xs-3">
<select  class="form-control" name="supplier_id" >
<option>${singlerowdetailofproduct.supplier_id}</option>
<c:forEach items="${supplierlist}" var="supplylist">
<option >${supplylist.id}</option></c:forEach></select></div></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="submit"  class="btn btn-info col-xs-offset-3"value="update">
</form></c:if>
</body>
</html>