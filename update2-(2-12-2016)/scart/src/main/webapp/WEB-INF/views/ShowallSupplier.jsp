<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="row">
<div class="col-xs-3">SupplierId</div>
<div class="col-xs-3">SupplierName</div>
<div class="col-xs-3">Address</div>
</div>
<c:forEach items="${supplierlist}" var="listofsupplier">
<div class="row">
<div class="col-xs-3">${listofsupplier.id}</div>
<div class="col-xs-3">${listofsupplier.name}</div>
<div class="col-xs-3">${listofsupplier.address}</div>
<c:if test="${updatesupplier}">
<a href="editsupplier/${listofsupplier.id}" class="btn btn-info col-xs-1">edit</a></c:if>
<c:if test="${deletesupplier}">
<a href="deletesupplierfromdb/${listofsupplier.id}" class="btn btn-info col-xs-1">Delete</a></c:if>
</div>
<hr>
</c:forEach>
</body>
</html>