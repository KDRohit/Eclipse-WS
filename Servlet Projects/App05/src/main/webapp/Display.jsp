<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<%			
						String pname =  request.getParameter("pname");
						String pid =  request.getParameter("pid");
						String pprice =  request.getParameter("pprice");
						String pqty =  request.getParameter("pqty");
						
						out.println("<center><h1>");
							
							out.println("Product Details:-"+"<br><br>");
							out.println("Product Name:-"+pname+"<br><br>");
							out.println("Product Id:-"+pid+"<br><br>");
							out.println("Product Price:-"+pprice+"<br><br>");
							out.println("Product Quantity:-"+pqty+"<br><br>");
							
					    out.println("</h1></center>");
		
		%>
		
</body>
</html>