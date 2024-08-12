<%@page import="com.org.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
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
<%@ include file="../admin/admin_navbar.jsp"%>

<% UserDao userDao= new UserDao();
List<User> list =userDao.fetchAll();

%>
<c:forEach var="u" items="<%=list %>">
<div class="card" style="width: 18rem;">
  <ul class="list-group list-group-flush">
      <li class="list-group-item"> User Id: ${u.id} </li>
    <li class="list-group-item">User Name: ${u.name} </li>
    <li class="list-group-item"> User Email: ${u.email}</li>
 
  </ul>
  </c:forEach>
</div>
</body>
</html>