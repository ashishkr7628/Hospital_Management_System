<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp" %>
</head>
<body>
<%@ include file="../admin/admin_navbar.jsp" %>

<% if(name==null){
	response.sendRedirect("../hospital_management_system/admin_login.jsp");
	
}
	
	%>

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctors Details</p>
<!-- 						<a href="#" class="text-decoration-none btn btn-primary">Add -->
<!-- 							User</a> -->
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>DOB</th>
									<th>Qualification</th>
									<th>Specialist</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Password</th>
									<th>Action</th>
								
								</tr>
								<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
								<c:forEach var="doc" items="${list }">
								<tr>
								<td>${ doc.name} </td>
								<td>${ doc.dob} </td>
								<td>${doc.qualification} </td>
								<td>${doc.specialist } </td>
								<td>${doc.email } </td>
								<td>${doc.mobile } </td>
								<td>${doc.password}</td>
								<td><a href="<%=path %>/updateDoctor?id=${doc.id}"
										class="btn btn-success text-decoration-none">Update</a> 
										<a
										href="<%=path %>/deleteDoctor?id=${doc.id}" class="btn btn-danger text-decoration-none">Delete</a>
									</td>
								</tr>
								</c:forEach>
								
								



							</thead>
							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>

</body>
</html>