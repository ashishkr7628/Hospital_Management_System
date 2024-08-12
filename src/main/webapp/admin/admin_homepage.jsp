<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp"%>
</head>
<body>
<%@ include file="admin_navbar.jsp" %>
<br>
<br>
<h3 class="text-success text-center">Welcome to Admin HomePage</h3>

<c:if test="${not empty success }">
<h4 class="text-success text-center">${success }</h4>


</c:if>

</body>
</html>