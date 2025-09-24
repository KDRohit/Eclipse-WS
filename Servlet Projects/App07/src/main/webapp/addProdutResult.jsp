<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
		<center>
						<%
						String msg =  (String) request.getAttribute("msg");
						out.println("<center><h1>");
						out.println(msg);
						out.println("</h1>");
						%>
						<jsp:include page="menu.html"/>
</body>
</html>