<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="../components/bootstrap.jsp"%>
<body>

<% String path=request.getContextPath(); %>
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
					<li class="nav-item"><a class="nav-link" href="#">View
							Doctor</a></li>
					
				</ul>
				<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
   DOCTOR
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="doctor_logout">Logout</a></li>
 
  </ul>
</div>
			</div>
		</div>
	</nav>
	
	
	
	
	
	
	
	

</body>
</html>