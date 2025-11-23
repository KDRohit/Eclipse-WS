<%@ 
	page 
	language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
    <center>
	    <h1>EMPLOYEE--MANAGEMENT--SERVICE</h1>
	    <h2>PAGE::employee.jsp</h2>
	    <h2><u>Employee List</u></h2>
	    <j:choose>
		    <j:when test="${!empty empVOList}">
		    	<table style ="background-color: gray;" border ="2px">
			    	<tr>
			    		<th>Employee Id</th>
			    		<th>Employee Name</th>
			    		<th>Employee Company</th>
			    		<th>Employee Salary</th>
			    		<th>Action 1</th>
			    		<th>Action 2</th>
			    	</tr>
		    	
			    	<j:forEach var="e" items="${empVOList}">
			    	<tr>
			    		<td>${e.id}</td>
			    		<td>${e.name}</td>
			    		<td>${e.company}</td>
			    		<td>${e.salary}</td>
			    		<td><a href="editEmployee?id=${e.id}">Edit</a></td>
			    		<td><a 
			    			href ="deleteEmployee?id=${e.id}"
			    			onclick = "return confirm('do you really want to delete ${e.name}[${e.id}]')"
			    			>
			    			Delete
			    		</a></td>
			    	</tr>
				    </j:forEach>
		    	</table>
		    	
		    </j:when>
		   
		    <j:otherwise>
		     	NO RECORD EXISTS!!!
		    </j:otherwise>
	    </j:choose>
	  
	  	<br>
	  		<j:if test="${!empty message}">
	  			<h1 style="color: orange;">${message}</h1>
	  		</j:if>
	  		
	  	<br>
	    <a href="addEmployee">
	    	ADD-EMPLOYEES
	    </a>
    </center>
