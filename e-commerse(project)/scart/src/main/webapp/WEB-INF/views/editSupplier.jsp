<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<c:set value="${supplierrow}" var="editsupplier"></c:set>
<form action="adminsubmitupdatesupplier" method="post" onsubmit="return valform()">
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<h3 class="text-primary col-xs-offset-2">Edit Supplier</h3>
<input type="text" class="form-control"   value="${editsupplier.id}" name="id" id="editcat-a1" required="true" onblur="idcheck()"/>
</div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<input type="text" class="form-control"  value="${editsupplier.name}" name="name" id="editcat-a2" required="true" onblur="namecheck()" />
</div></div>
<div class="row">
<div class="form-group col-xs-offset-4 col-xs-3">
<input type="text" class="form-control"  value="${editsupplier.address}" name="address" id="editcat-a3" required="true" onblur="namecheck()" />
</div></div>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
<div class="row">
<button  type="submit" class=" col-xs-offset-5 col-xs-1 btn btn-primary">Update</button>
</div>
</form>
</body>
</html>