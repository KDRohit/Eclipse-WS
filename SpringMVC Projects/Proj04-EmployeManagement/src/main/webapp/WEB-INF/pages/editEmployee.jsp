<%@ 
	page 
	language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
    <center>
	    <h1>EMPLOYEE--MANAGEMENT--SERVICE</h1>
	    <h2>PAGE::editEmployee.jsp</h2><br>
	    
	    <h2><u>Add Employee</u></h2>
	    <spring:form action="editEmployee" modelAttribute="empVO">
	    	<table style="background-color: gray; border: 1px; ">
	    		<tr>
	    			<td>Employee id</td>
	    			<td><spring:input path="id" readonly="true"/></td>
	    		</tr>
	    		<tr>
	    			<td>Employee Name</td>
	    			<td><spring:input path="name"/></td>
	    		</tr>
	    		<tr>
	    			<td>Employee Company</td>
	    			<td><spring:input path="company"/></td>
	    		</tr>
	    		<tr>
	    			<td>Employee Salary</td>
	    			<td><spring:input path="salary"/></td>
	    		</tr>
	    	</table>
	    	
	    	<input type="submit" value="update"> &nbsp;&nbsp;&nbsp; 
	    	<input type="reset" value="cancel">
	    </spring:form>
	    
    </center>
