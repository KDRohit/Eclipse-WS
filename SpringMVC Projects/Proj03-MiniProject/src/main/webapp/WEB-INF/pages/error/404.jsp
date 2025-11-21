<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
 <center>
 		<h1>
 			<u>Welcome in Mini Project(Error Page-404)</u>
 		</h1>
 		<br><br>
 		
 		<h2>Error Info Table</h2>
 		<table border="1px">
	 		<tr>
	 			<td>status</td>
	 			<td>${status}</td>
	 		</tr>
	 		<tr>
	 			<td>message</td>
	 			<td>${message}</td>
	 		</tr>
	 		<tr>
	 			<td>type</td>
	 			<td>${type}</td>
	 		</tr>
	 		<tr>
	 			<td>path</td>
	 			<td>${path}</td>
	 		</tr>
	 		<tr>
	 			<td>trace</td>
	 			<td>${trace}</td>
	 		</tr>
	 		
	 		<tr>
	 			<td>error</td>
	 			<td>${error}</td>
	 		</tr>
	 		
			<tr>
				<td>errors</td>
				<td>${errors}</td>
			</tr>
			
			<tr>
				<td>message</td>
				<td>${message}</td>
			</tr>
			
			<tr>
				<td>timestamp</td>
				<td>${timestamp}</td>
			</tr>
			
			<tr>
				<td>path</td>
				<td>${path}</td>
			</tr>
 		
 		</table>
 		
	 	<a href="./">Home
	 		<img width="100px" height="100px" src="images/report.png">
	 	</a>
	 	
 </center>
