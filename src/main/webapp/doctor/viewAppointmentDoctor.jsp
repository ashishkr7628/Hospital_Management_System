<%@page import="com.org.dto.Doctor"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.org.dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp"%>
</head>
<body>

<%@ include file="doctor_homepage.jsp" %>

<% 
List<Appointment> list =doctor.getAppointment();
%>


	<div class="d-flex justify-content-center">

		<table class="table">
		
		

			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Gender</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile</th>
					<th scope="col">Aadhar</th>
					<th scope="col">Address</th>
					<th scope="col">Appointment Date</th>
					<th scope="col">Disease</th>
					<th scope="col">Doctor</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>






				</tr>





			</thead>
			<tbody>
			<c:forEach var="ap" items="<%=list%>">
			
			<tr>
			
			<td>${ap.name}</td>
			<td>${ap.age}</td>
			<td>${ap.gender}</td>
			<td>${ap.email}</td>
			<td>${ap.phone}</td>
			<td>${ap.aadhar}</td>
			<td>${ap.address}</td>
			<td>${ap.appointmentDate}</td>
			<td>${ap.diseases}</td>
			<td>${ap.doctor.name}</td>
			
			<c:if test="${ap.status.equals('pending')}">
			<td class="bg-warning text-light">${ap.status}</td>
			
			</c:if>
			
			<c:if test="${ap.status.equals('accepted')}">
			<td class="bg-success text-light">${ap.status}</td>
			
			</c:if>
			<c:if test="${ap.status.equals('rejected')}">
			<td class="bg-danger text-light">${ap.status}</td>
			
			</c:if>
			
			
			<td><a class="btn btn-md btn-success" href="<%=path %>/updateAccept?id=${ap.id}">Accept</a>
			<a class="btn btn-md btn-danger" href="<%=path %>/updateReject?id=${ap.id}">Reject</a>
			</td>
			
			
			</tr>
			
			
			
			
			
			
			
			
			
			
			
			</c:forEach>












			</tbody>














		</table>



	</div>


</body>
</html>