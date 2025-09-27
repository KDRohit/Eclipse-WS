<%@page import="com.jbeans.User"%>
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
				<h1>
								<%
									User user =  (User)application.getAttribute("ubean");
									out.println("Welcome:-"+user.getUserName());
									out.println("<br><br>");
								%>
								
								<a href="viewProfile.jsp">View Profile</a><br>
								<a href="logout">Logout</a>
				</h1>
</body>
</html>