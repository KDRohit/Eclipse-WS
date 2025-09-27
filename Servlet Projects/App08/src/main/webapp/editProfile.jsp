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
									out.println("<br>");
								%>
								
								<form action = "onUpdate" method="post">
								
											First Name:- <input type=text  name="firNam"  value = <%=user.getFirstName() %>><br>
											Last Name:- <input type=text  name="lasNam" value = <%=user.getLastName() %>><br>
											Email Id:- <input type=text  name="emaId" value = <%=user.getMailId() %>><br>
											Phone No:- <input type=text  name="phoNo" value = <%=user.getPhoneNo() %>><br>
									
										   <input type="submit" value ="Update">
											
								</form>
								
								
				</h1>
				
				<h3>
								<a href="home.jsp">Home</a><br><br>
								<a href="logout">Logout</a>
				</h3>	
</body>
</html>