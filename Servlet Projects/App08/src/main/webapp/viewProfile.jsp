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
								    String fname=  (String)request.getAttribute("fname");
									out.println("----------- Profile Details--------(Session belongs to "+fname+")");
									out.println("<h1>");
									out.println("User Name:"+user.getUserName()+"<br>");
									String pass = user.getPassword();
									String securePwd = pass.substring(0,1)+"*******"+pass.substring(pass.length()-1);
									out.println("User Password : "+securePwd+"<br>");
									out.println("First Name : "+user.getFirstName()+"<br>");
									out.println("Last Name : "+user.getLastName()+"<br> ");
									out.println("Email Id : "+user.getMailId()+"<br> ");
									out.println("Phone No :"+user.getPhoneNo()+"");
									out.println("</h1>");
								%>
								
				</h1>
				<h3>
								<a href="onEdit">Edit</a><br><br>
								<a href="logout">Logout</a>
				</h3>	
</body>
</html>