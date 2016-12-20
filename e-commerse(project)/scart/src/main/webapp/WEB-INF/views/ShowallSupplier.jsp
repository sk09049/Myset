<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<table class="table">
<tr>
<th>SupplierId</th><th>SupplierName</th><th>Address</th><th colspan="2">Editing Option</th>
</tr>
<c:forEach items="${supplierlist}" var="listofsupplier">
<tr>
<td>${listofsupplier.id}</td><td>${listofsupplier.name}</td><td>${listofsupplier.address}</td>
<td><c:if test="${updatesupplier}">
<a href="admineditsupplier${listofsupplier.id}">edit</a></c:if></td>
<td>
<c:if test="${deletesupplier}">
<a href="admindeletesupplierfromdb${listofsupplier.id}">Delete</a></c:if></td>
</tr>
</c:forEach>
</table>
</body>
</html>