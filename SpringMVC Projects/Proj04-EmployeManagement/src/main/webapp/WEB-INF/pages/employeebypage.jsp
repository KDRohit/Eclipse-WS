<%@ 
	page 
	language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
    <center>
	    <h1>EMPLOYEE--MANAGEMENT--SERVICE [${sysdate}]</h1>
	     
	    <h2>PAGE::employeebypage.jsp</h2>
	    <h2><u>Employee List</u></h2>
	    <j:choose>
		    <j:when test="${!empty pageVO}">
		    	<table style ="background-color: gray;" border ="2px">
			    	<tr>
			    		<th>Employee Id</th>
			    		<th>Employee Name</th>
			    		<th>Employee Company</th>
			    		<th>Employee Salary</th>
			    		<th>Action 1</th>
			    		<th>Action 2</th>
			    	</tr>

			    	<j:forEach var="e" items="${pageVO.getContent()}">
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
		    	
		    <j:if test="${!pageVO.isFirst()}">
	    		<a href="Employees-by-page?page=0">first</a>&nbsp;
	    	</j:if>
		    
	    	<j:if test="${pageVO.hasNext()}">
	    		<a href="Employees-by-page?page=${pageVO.getNumber()+1}">next</a>&nbsp;
	    	</j:if>
		    
		    <j:forEach step="1" var="i" begin="0" end="${pageVO.getTotalPages()-1}">
		    	<j:if test="${pageVO.getNumber()!=i}">
		    		[<a href="Employees-by-page?page=${i}">${i+1}</a>] &nbsp;
		    	</j:if>
		    	
		    </j:forEach>
		    
		    <j:if test="${pageVO.hasPrevious()}">
	    		<a href="Employees-by-page?page=${pageVO.getNumber()-1}">previous</a>&nbsp;
	    	</j:if>
	    	
		    <j:if test="${!pageVO.isLast()}">
	    		<a href="Employees-by-page?page=${pageVO.getTotalPages()-1}">last</a>
	    	</j:if>
		    
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
