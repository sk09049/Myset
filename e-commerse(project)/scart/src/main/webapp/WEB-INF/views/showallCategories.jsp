<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<table class="table">
<tr class="bg-success">
<th class="text-center">
Id
</th>
<th class="text-center">
Name
</th>
<th class="text-center">
Description
</th>
<th>
</th>
</tr>
<c:forEach items="${list}" var="list">
<tr>
<td class="text-center">
${list.id}
</td>
<td class="text-center">
${list.name}
</td>
<td class="text-center">
${list.description}
</td>
<td class="text-center" >
<c:if test="${categoryupdate}"><a href="admineditcategory${list.id}">edit</a></c:if>
<c:if test="${categorydelete}"><a href="admindeletecategory${list.id}">delete</a></c:if>
</td>
</tr></c:forEach></table>
</body>
</html>