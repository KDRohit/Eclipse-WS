<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome in Login Page</title>
</head>
<body>
				<center>
				<%
				
				String msg = (String) request.getAttribute("msg");
				out.println(msg);
				%>
				<jsp:include page="login.html"/>
</body>
</html>