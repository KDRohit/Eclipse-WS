<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
 <center>
 		<h1>
 			<u>Welcome in Edit Movie Page</u>
 		</h1>
 		<br><br>
 		<spring:form action="edit" method="post" modelAttribute="movie">
 		
 		<table border="1px" style="background-color: yellow;">
 		
 			<tr>
 				<th> Movie Id</th>
 				<td>
 					<spring:input path="id" readonly="true"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<th> Movie Name</th>
 				<td>
 					<spring:input path="name"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<th> Actor Name</th>
 				<td>
 					<spring:input path="actor"/>
 				</td>
 			</tr>
 			
 			<tr>
 				<th> Actress Name</th>
 				<td>
 					<spring:input path="actress"/>
 				</td>
 			</tr>
 		</table>
 		
 		<input type="submit" value="update">
 		<input type="reset" value="cancel">
 		
 		</spring:form>
	 	
 </center>
