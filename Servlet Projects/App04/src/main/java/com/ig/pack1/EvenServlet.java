package com.ig.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ev")
public class EvenServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		System.out.println("service method invoked");
		int number =  Integer.parseInt (req.getParameter("num"));
		boolean isEven = number%2==0?true:false;
		String msg = " Number "+number+" is"+ (isEven ?" Even":" Odd");
		res.setContentType("text/html");
		PrintWriter pw =  res.getWriter();
		pw.println("<center><h1>");
		pw.println(msg);
		pw.println("</h1><center>");
		RequestDispatcher dis =  req.getRequestDispatcher("index.html");
		dis.include(req, res);
	}

}
