package com.pack1;

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
	public void service(ServletRequest req, ServletResponse res) throws IOException,ServletException
	{
		RequestDispatcher reqDis =  req.getRequestDispatcher("Display.jsp");
		reqDis.forward(req, res);
	}
}
