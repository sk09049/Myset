<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class="text-primary">Billing Address</h3>
<form:form commandName="billingAddress">
<form:input type="text" path="id" placeholder="enter id"/>
<form:input type="text" path="doorno" placeholder="enter door no"/>
<form:input type="text" path="street" placeholder="enter street name"/>
<form:input type="text" path="city" placeholder="enter city name"/>
<form:input type="text" path="pincode" placeholder="enter pincode"/>
<form:input type="text" path="country" placeholder="enter country name"/>
<input type="submit" name="_eventId_submitbillingaddress" class="btn btn-info" value="save"/>
</form:form>
</body>
</html>