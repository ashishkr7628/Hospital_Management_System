<%@page import="com.org.dto.Doctor"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


.card{

margin: 10% auto;
 
 font-size: larger;

}



</style>
</head>
<%@ include file="../components/bootstrap.jsp"%>
<body>

<% String path=request.getContextPath(); %>


<% int doctorId=(int)session.getAttribute("doctorId");
DoctorDao dao = new DoctorDao();
Doctor doctor=dao.fetchDoctorById(doctorId);

%>


<%if(session.getAttribute("name")==null){
	
	response.sendRedirect("../doctor_login.jsp");
	
}
	%>

<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="../../hospital_management_system/index.jsp">Hospital
				Management System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					
					<li class="nav-item"><a class="nav-link" href="<%=path %>/doctor/viewAppointmentDoctor.jsp">
							View Appointment</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=path%>/doctor/doctor_homepage.jsp">View
							Doctor</a></li>
					
				</ul>
				<a href="<%=path%>/doctor/doctor_homepage.jsp">><button type="button" class="btn btn-info">Back</button></a>
				<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
   <%=doctor.getName() %>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="<%=path %>/doctor_logout">Logout</a></li>
 
  </ul>
</div>
			</div>
		</div>
	</nav>
	
	
	<div class="card " style="width: 25rem;">
  <ul class="list-group list-group-flush">
  
    <li class="list-group-item text-center ">Doctor Details:</li>
    <li class="list-group-item text-center">Doctor Name:  <%=doctor.getName() %> </li>
    <li class="list-group-item text-center">Doctor DOB:  <%=doctor.getDob() %> </li>
    <li class="list-group-item text-center">Doctor Email:  <%=doctor.getEmail() %> </li>
    <li class="list-group-item text-center">Doctor Specialist:  <%=doctor.getSpecialist() %> </li>
    <li class="list-group-item text-center">Doctor Qualification:  <%=doctor.getQualification() %> </li>
    <li class="list-group-item text-center">Doctor Mobile:  <%=doctor.getMobile() %> </li>
    </ul>
</div>
	
	
	
	
	

</body>
</html>