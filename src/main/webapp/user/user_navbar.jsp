
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
					
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="../../hospital_management_system/user/add_appointment.jsp">Add Appointment</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=path %>/view_appoint">
							View Appointment</a></li>
					<li class="nav-item"><a class="nav-link" href="#">View
							User</a></li>
					
				</ul>
				<span class="navbar-text"> USER </span>
			</div>
		</div>
	</nav>