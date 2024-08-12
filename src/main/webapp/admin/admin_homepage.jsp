<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dao.AppointmentDao"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp"%>
<style type="text/css">

#box{

height:20vh;
width:20%;
align-items: center;
align-content: center;
padding: 10% auto;
margin: 10% auto;
margin-left: 10%



}




</style>
</head>
<body>
<%@ include file="admin_navbar.jsp" %>
<br>
<br>
<h3 class="text-success text-center">Welcome to Admin HomePage</h3>

<c:if test="${not empty success }">
<h4 class="text-success text-center">${success }</h4>


</c:if>

<%! int doctor= new DoctorDao().fetchAll().size();

int appoint= new AppointmentDao().fetchAll().size();

int user= new UserDao().fetchAll().size();


%>

<div class="d-inline-flex p-2 bd-highlight border border-primary" id="box">
<h4> No. of Doctors: <%=doctor %></h4>
 </div>
 


 
<div class="d-inline-flex p-2 bd-highlight border border-secondary" id="box">
<h4> No. of Users: <%=user %></h4>
 </div>


<div class="d-inline-flex p-2 bd-highlight border border-danger" id="box">
<h4> No. of Appointments: <%=appoint %></h4>
 </div>


</body>
</html>