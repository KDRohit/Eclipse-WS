<%@page import="java.util.Arrays"%>
<%@page import="com.ig.EmpBean"%>
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

		<h1>----- Employees-----</h1>
		<center>
			<% 
			String[] params = request.getParameterValues("list");
			ArrayList<EmpBean> al = new ArrayList<EmpBean>(Arrays.asList(params));
			al.forEach(t->
			{
				try
				{
					out.println("");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			});
			
			%>
</body>
</html>