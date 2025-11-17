<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
	<center>
	
		<h1>welcome in the Page::["Welcome.jsp"]</h1><br><br>
		
		<b>name[EL] :: ${name}</b><br><br>
		<b>dob[EL] :: ${DOB}</b><br><br>
		<b>name[Request] :: <%=request.getAttribute("name")%></b><br><br>
		<b>name[Request] :: <%=request.getAttribute("DOB")%></b><br><br>
		
		<b> 
			<a href="page-1"> Go_To_Page_1</a><br><br>
			<a href="page-2"> Go_To_Page_2</a><br><br>
		</b>
	</center>
	
	
