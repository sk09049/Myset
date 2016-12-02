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
<form:form commandName="shippingAddress">
<form:input type="text" path="id"/>
<form:input type="text" path="doorno"/>
<form:input type="text" path="street"/>
<form:input type="text" path="city"/>
<form:input type="text" path="pincode"/>
<form:input type="text" path="country"/>
<input type="submit" name="_eventId_submitshippingaddress" class="btn btn-info" value="save"/>
</form:form>
</body>
</html>