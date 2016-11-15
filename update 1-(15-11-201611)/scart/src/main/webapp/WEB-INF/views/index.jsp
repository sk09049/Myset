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
<!-- <img src="<c:url value="/images/1.jpg"/>"/> -->
${msg }${msg1} ${msg2}
${ha}
${as}
<c:if test="${check1 }">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
<c:if test="${check2 }">
<jsp:include page="welcome.jsp"></jsp:include>
</c:if>
<c:if test="${check3 }">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
<c:if test="${check4 }">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${check5 }">
<jsp:include page="category.jsp"></jsp:include>
</c:if>
<c:if test="${home}">
<jsp:include page="home.jsp"></jsp:include>
</c:if>
<c:if test="${product}">
<jsp:include page="products.jsp"></jsp:include>
</c:if>
<c:if test="${checkreg }">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${supply }">
<jsp:include page="supplier.jsp"></jsp:include>
</c:if>
<c:if test="${error1}">
<jsp:include page="welcome.jsp"></jsp:include>
</c:if>
</body>
</html>