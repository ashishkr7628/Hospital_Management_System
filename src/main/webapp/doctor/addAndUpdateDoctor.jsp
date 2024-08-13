<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@ include file="../components/bootstrap.jsp"%>
 
<style type="text/css">
.doctor-form {
	width: 30%;
	margin: 10% auto;
	text-align: center;
	padding: 20px;
	background-color: rgb(173, 216, 230);
	height: 50%;
}

form>input {
	margin: 2%;
}
</style>
</head>
<body>
	<%@ include file="../admin/admin_navbar.jsp"%>
	
	<% if(name==null){
		response.sendRedirect("../hospital_management_system/admin_login.jsp");
	
}
	
	%>
	
	<form:form action="registerAndUpdateDoctor" modelAttribute="doctor"
		class="doctor-form">
		
		<h4>Doctor Details: </h4>

		<h5>Name:</h5>
		<form:input path="name" />
		<br>
		<br>

		<h5>DOB:</h5>
		<form:input path="dob" />
		<br>
		<br>

		<h5>Qualification:</h5>
		<form:input path="qualification" />
		<br>
		<br>

		<h5>Specialist:</h5>
		<form:select path="specialist">
			<c:forEach var="spec" items="${list }">
				<form:option value="${spec.name}"></form:option>

			</c:forEach>

		</form:select>

		<br>
		<br>

		<h5>Email:</h5>
		<form:input path="email" type="email" />
		<br>
		<br>

		<h5>Mobile:</h5>
		<form:input path="mobile" type="number" />
		<br>
		<br>


		<h5>Password:</h5>
		<form:input path="password" type="password" />
		<br>
		<br>



		<form:button>Submit</form:button>














	</form:form>

</body>
</html>