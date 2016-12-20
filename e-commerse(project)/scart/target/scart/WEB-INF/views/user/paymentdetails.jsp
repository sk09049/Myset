<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form commandName="paymentmode">
<input type="text" value="cod" path="paymentmethod" readonly="true"/>
<input type="submit"name="_eventId_cod" value="cod">
<input type="text" value="cod" path="paymentmethod" readonly="true"/>
<input type="submit"name="_eventId_netbanking" value="netbanking"></form:form>
</body>
</html>