<%@page import="com.org.dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 	<% if(session.getAttribute("userName")==null){
 		
 		
 		

		response.sendRedirect("../../hospital_management_system/user_login.jsp");
 	}
%>
<%
DoctorDao dao = new DoctorDao();

List<Doctor> list = dao.fetchAll();
int userId = (int)session.getAttribute("userId");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp"%>
<style>
.login {
	width: 30%;
	margin: 10% auto;
	text-align: center;
	padding: 20px;
	background-color: rgb(173, 216, 230);
	height: 100%;
}

.navbar-text {
	padding-right: 5%;
}

.container {
	display: flex;
	width: 100%;
	height: 80%;
}
</style>
</head>
<body>
	<%@ include file="user_navbar.jsp"%>
	
	


	<div class="container">






		<div class="login">


			<form action="<%=path %>/update_appointment" method="post">
				<h2>Appointment Form</h2>

				<label>name</label><br>
				<input type="text" name="name" value="${appoint.name}"><br> <br>
				<label>age</label><br>
				<input type="text" name="age" value="${appoint.age}"><br> <br>
				 <label>gender</label><br>
				<select name="gender" value="${appoint.gender}">


					<option>Male</option>
					<option>Female</option>
					<option>Others</option>


				</select><br> <br>
				 <label>email</label><br> 
				 <input type="email" name="email" value="${appoint.email}"><br> <br> 
				<label>diseases</label><br>
				<input type="text" name="diseases" value="${appoint.diseases}"><br> <br>
				 <label>AppointmentDate</label><br>
				<input type="text" name="appointmentDate" value="${appoint.appointmentDate}"><br> <br>
				<label>phone</label><br>
				 <input type="text" name="phone" value="${appoint.phone}"><br><br>
				  <label>address</label><br>
				   <input type="text" name="address" value="${appoint.address}"><br> <br> 
					<label>aadhar</label><br>
					 <input type="text" name="aadhar" value="${appoint.aadhar}"><br> <br>
					  <label>Doctor</label> <br>
				<select name="doctorId" value="${appoint.doctor.name}" >
					<c:forEach var="d" items="<%=list%>">

						<option value="${d.id}">${d.name }(${d.specialist })</option>
						<input type="hidden" name="docId" value="${d.id }">

					</c:forEach>

				</select><br><br>
				<input type="hidden" name="docId" value="<%=userId%>">
				<input type="hidden" name="userId" value="<%=userId%>">
				 <input type="submit" value="register">

			</form>

		</div>
	</div>

</body>
</html>