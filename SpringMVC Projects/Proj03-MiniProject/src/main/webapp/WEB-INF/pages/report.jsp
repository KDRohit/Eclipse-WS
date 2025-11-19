<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <center>
 		<h1>
 			<u>Welcome in Report Page</u>
 		</h1>
 		<c:choose>
	 		<c:when test="${!empty movies}">
		 		<table bgcolor="cyan" border="1px" align="center">
			 		<tr>
			 			<th>movie id</th>
			 			<th>movie name</th>
			 			<th>movie actor</th>
			 			<th>movie actress</th>
			 		</tr>
			 		<c:forEach var="movie" items="${movies}">
				 		<tr>
				 			<td>${movie.id}</td>
				 			<td>${movie.name}</td>
				 			<td>${movie.actor}</td>
				 			<td>${movie.actress}</td>
				 			<td>
				 				<a href="edit?no=${movie.id}">
				 					<img alt="" src="images/edit.png" width="20px" height="20px">
				 				</a>
				 			</td>
				 			<td>
				 				<a href="delete?no=${movie.id}" 
				 					onclick="return confirm('are you sure you want to delete movie-${movie.name}?')">
				 					<img alt="" src="images/delete.png" width="20px" height="20px">
				 				</a>
				 			</td>
				 		</tr>
			 		</c:forEach>
		 		
		 		</table>
		 	</c:when>
		 	<c:otherwise>
		 		<h1 align="center">No Movies Found!!!</h1>
		 	</c:otherwise>
 		</c:choose>
	 	<c:if test="${!empty message}">
	 		<h2>${message}</h2>
	 	</c:if>
	 	<a href="add">
	 		Add Movies<img src="images/add.png" width="50px" height="50px">
	 	</a>
 </center>
