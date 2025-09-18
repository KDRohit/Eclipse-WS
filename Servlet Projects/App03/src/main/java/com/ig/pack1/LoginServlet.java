package com.ig.pack1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/user-login")
public class LoginServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String u =  req.getParameter("u");
		String p = req.getParameter("p");
		if(u.equalsIgnoreCase(""))
	}

}
