<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<h3 class= "col-xs-offset-4 text-success" style="margin-top:100px;">Choose your Payment Mode</h3>
<form:form commandName="paymentmode" style="margin-top:100px;" >
<input type="hidden" value="cod" path="paymentmethod" readonly="true"/>
<input type="submit"name="_eventId_cod" value="cod" class=" col-xs-offset-5 btn btn-success">
<input type="hidden" value="cod" path="paymentmethod" readonly="true"/>
<input type="submit"name="_eventId_netbanking" value="netbanking" class="btn btn-success">
</form:form>
<a style="margin-top:50px;" href="${flowExecutionUrl}&_eventId=back" class=" col-xs-offset-4 btn btn-primary">back</a>
<a style="margin-top:50px;"href="${flowExecutionUrl}&_eventId=cancel" class=" col-xs-offset-3 btn btn-danger">cancel</a>
</body>
</html>