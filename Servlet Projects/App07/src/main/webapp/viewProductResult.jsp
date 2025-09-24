<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.jbeans.Product"%>
<%@page import="java.util.ArrayList"%>
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
			<h1>----Product List------</h1>
			<%
					 ArrayList<Product> items  = (ArrayList<Product>)request.getAttribute("items");
					for(Product item : items)
					{
						out.println(item.getpId()+" "+item.getpName()+" "+item.getpPrice()+""+item.getpQty()+"<br><br>");
					}
			%>
			<jsp:include page="menu.html"></jsp:include>
</body>
</html>