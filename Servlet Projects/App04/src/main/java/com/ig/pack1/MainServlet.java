package com.ig.pack1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ms")
public class MainServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String ch = req.getParameter("choice");
		if(ch.equalsIgnoreCase("Factorial"))
		{
			RequestDispatcher dis =  req.getRequestDispatcher("/fs");
			dis.forward(req, res);
		}
		else
		{
			RequestDispatcher dis =  req.getRequestDispatcher("/ev");
			dis.forward(req, res);
		}
	}

}
