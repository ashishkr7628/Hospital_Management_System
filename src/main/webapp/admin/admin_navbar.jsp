<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String path =request.getContextPath(); %>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="<%=path%>/index.jsp">Hospital
				Management System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=path %>/temp_Doctor">Add Doctor</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=path%>/doctor/add_specialist.jsp">Add Specialist</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=path %>/fetchAllDoctor">View
							Doctor</a></li>
					<li class="nav-item"><a class="nav-link" href="#">View
							Patients</a></li>
					<li class="nav-item"><a class="nav-link" href="#">View
							Appointments</a></li>
				</ul>
				<span class="navbar-text"> ADMIN </span>
			</div>
		</div>
	</nav>
</body>
</html>