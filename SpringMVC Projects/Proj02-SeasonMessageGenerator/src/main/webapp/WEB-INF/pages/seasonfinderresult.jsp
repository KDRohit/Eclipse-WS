<%@page import="java.util.Arrays"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
    <center>
    	<h1>
    		Message = ${message}<br>
    		Array = <%=Arrays.toString((String[])request.getAttribute("Array"))%><br>
    		List = ${List}<br>
    		Set = ${Set}<br>
    		Map = ${Map}<br>
    		SomeDummyModel = ${someDummyModel}<br>
    	</h1>
    	<a href="./">Back</a>
    </center>
   