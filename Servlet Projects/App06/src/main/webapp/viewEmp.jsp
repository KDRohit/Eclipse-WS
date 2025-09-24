<%@page import="java.util.Iterator"%>
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
		<center>
		
		<h1>----- Employees-----</h1>
		
			<% 
			ArrayList<EmpBean> al = (ArrayList<EmpBean>)request.getAttribute("list");
			if(al.size()==0)
			{
				out.println("data not found");
			}
			else
			{
				Iterator<EmpBean> i =  al.iterator();
				while(i.hasNext())
				{
					EmpBean e =  (EmpBean)i.next();
					out.println(e.getEmpId()+" "+e.getEmpFirstName()+" "+e.getEmpLastName()+" "+e.getSalary()+" "+e.getAddress()+"<br><br>");
				}
			}
			
			%>
			
			<jsp:include page="index.html"/>
</body>
</html>