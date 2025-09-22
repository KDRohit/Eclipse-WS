<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
		String data = (String)request.getAttribute("msg");
		out.println("<h1>"+data+"</h1>");
		%>
		
		<h1><br><br>
		<a href="addEmp.html"> Add Employee Details </a><br><br>
		<a href="view"> View Employee Details </a><br><br>
</body>
</html>