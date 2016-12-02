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

<title>Insert title here</title>
</head>
<body>
<c:if test="${deleted}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-3 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Successfully Category deleted</p></div>
</c:if>
<c:if test="${deleteexception}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-2 col-xs-7" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Sorry! Exception happened while deleting report us </p></div>
</c:if>
<c:if test="${idNotExists}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-warning alert-dismissible col-xs-offset-2 col-xs-7" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Sorry! You are Not allowed to change Primary key </p></div>
</c:if>
<c:if test="${updated}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-3 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Successfully Category Updated</p></div>
</c:if>
<c:if test="${exception}">
<div style="height:100px;background-color:#ffffff;width:50%;margin-top:10px;border-radius:5px;" class="row col-xs-offset-3">
<p class="alert alert-success alert-dismissible col-xs-offset-3 col-xs-6" style="margin-top:25px;">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
Sorry Some exception happened while updating report us </p></div>
</c:if>
<div class="row">
<div class="text-primary  col-xs-2">Id</div>
<div class="text-primary  col-xs-2">name</div>
<div class="text-primary  col-xs-2">description</div>

</div>
<div style="border:.5px solid red;"></div>
<c:forEach items="${list}" var="list">
<div class="row">
<p class="text-success col-xs-2"><c:out value="${list.id}"></c:out></p>
<p class="text-success col-xs-2"><c:out value="${list.name}"></c:out></p>
<p class="text-success col-xs-2"><c:out value="${list.description}"></c:out></p>
<a href="editcategory/${list.id}"><button  class="btn btn-primary col-xs-1">edit</button></a>
<a href="deletecategory/${list.id}"><button class="btn btn-danger col-xs-1">delete</button></a></div>
<div style="border:.5px solid red;"></div>
</c:forEach>
</body>
</html>