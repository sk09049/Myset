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
<jsp:include page="header.jsp"></jsp:include>

<hr>
${msg }
${msg1} ${msg2}
<c:if test="${check1 }">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
<c:if test="${check2 }">
<jsp:include page="welcome.jsp"></jsp:include>
</c:if>
<c:if test="${check3 }">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
</body>
</html>