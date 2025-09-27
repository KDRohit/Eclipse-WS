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
									out.println("----------- Profile Details--------");
									out.println("<h1>");
									out.println("User Name:"+user.getUserName()+"<br>");
									out.println("First Name: "+user.getFirstName()+"<br>");
									out.println("Last Name: "+user.getLastName()+"<br>");
									out.println("Email Id: "+user.getMailId()+"<br>");
									out.println("Phone No:"+user.getPhoneNo()+"<br>");
									out.println("</h1>");
								%>
								
				</h1>
				<h3>
								<a href="editProfile.jsp">Edit Profile</a><br><br>
								<a href="logout">Logout</a>
				</h3>	
</body>
</html>