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
									out.println("----------- Edit Profile --------");
									out.println("<h1>");
									out.print("<form action='onEditProfile' method=post>");
											out.println("User Name: <input type=text placeholder="+user.getUserName()+" name='use'><br>");
											out.println("First Name: <input type=text placeholder="+user.getFirstName()+"  name = 'firNam'><br>");
											out.println("Last Name: <input type=text placeholder="+user.getLastName()+" name = 'lasNam'><br>");
											out.println("Email Id: <input type=text placeholder="+user.getMailId()+" name = 'emaId'><br>");
											out.println("Phone No: <input type=text placeholder="+user.getPhoneNo()+" name = 'phoNo'><br>");
											out.println("<input type=submit value=update>");
									out.print("</form>");
									
									out.println("</h1>");
								%>
								
				</h1>
				<h3>
								<a href="viewProfile.jsp">Back</a><br><br>
								<a href="logout">Logout</a>
				</h3>	
</body>
</html>