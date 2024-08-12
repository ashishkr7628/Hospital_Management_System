<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@ include file="components/bootstrap.jsp"%>

    <style>
        .login {
            width: 30%;
            margin: 10% auto;
            text-align: center;
            padding: 20px;
            background-color: rgb(173, 216, 230);
            height: 70%;
        }

        .navbar-text {
            padding-right: 5%;
        }

        .container {
            display: flex;
            width: 100%;
            height: 100vh;
        }

        .image-container {
            margin: 5%;
            width: 50%;
            
            
        }

        .image-container img {
            width: 100%;
        }
    </style>
</head>
<body>
    <%@ include file="components/navbar.jsp" %>

    <div class="container">
        <div class="image-container">
         <img src="src/main/webapp/user/user1.jpg" alt="Description of Image">
        
        
           
        </div>

        <div class="login">
            <form action="admin_login" method="post">
                <h2>Admin Login</h2>
                
                <c:if test="${not empty failed }">
                <h4 class="text-success text-center">${failed}</h4>
                
                
                </c:if>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                    <div id="emailHelp" class="form-text"></div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
