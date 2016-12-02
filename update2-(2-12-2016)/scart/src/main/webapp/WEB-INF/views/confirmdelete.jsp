<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../deletecategory" method="post">
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">delete Categories</h3>
<input type="text" class="form-control"   value="${selectedcategoryrow.id}" name="id" id="a" required="true" onblur="idcheck()"/>
<p id="b" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<input type="text" class="form-control"  value="${selectedcategoryrow.name}" name="name" id="a1" required="true" onblur="namecheck()" />
<p id="b1" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<input type="text" class="form-control"  value="${selectedcategoryrow.description}" name="description" id="a1" required="true" onblur="namecheck()" />
<p id="b1" class="text-warning small col-xs-offset-1"></p></div></div>
<div class="row">
<button  type="submit" class=" col-xs-offset-5 col-xs-1 btn btn-primary">Update</button>
<a href="viewall"><button  type="button" class=" col-xs-1 btn btn-success" >ViewAll</button></a>
</div>
</form>
</body>
</html>