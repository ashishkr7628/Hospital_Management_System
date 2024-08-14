<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/bootstrap.jsp" %>
<style type="text/css">
.card{
margin:10% auto;
font-size: larger;
}


</style>
</head>
<body>


<%@ include file="user_navbar.jsp" %>
	<% if(session.getAttribute("userName")==null){
		
		response.sendRedirect("../hospital_management_system/user_login.jsp");
		
	}
			 %>

<h3 class="text-success text-center">Welcome to User HomePage</h3>

<div class="card" style="width: 25rem;">
  <ul class="list-group list-group-flush">
      <li class="list-group-item"> User Id: ${user.id} </li>
    <li class="list-group-item">User Name: ${user.name} </li>
    <li class="list-group-item"> User Email: ${user.email}</li>
 
  </ul>

</div>


</body>
</html>