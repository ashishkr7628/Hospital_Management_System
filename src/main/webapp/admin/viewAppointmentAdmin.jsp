<%@page import="com.org.dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.AppointmentDao"%>
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
	<% if(name==null){
		response.sendRedirect("../../hospital_management_system/admin_login.jsp");
	
}
	
	%>
	
	
	<% AppointmentDao dao = new AppointmentDao();
	
	List <Appointment> list=dao.fetchAll();
	System.out.println(list);
	
	
	
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
						<td>${ap.status}</td>

						
					</tr>





				</c:forEach>


			</tbody>


		</table>



	</div>


</body>
</html>