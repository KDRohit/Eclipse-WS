package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class FirstServlet extends GenericServlet
{
	@Override
	public void init()
	{
		System.out.println("-------init invoked-------");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw =  res.getWriter();
		res.setContentType("text/html");
		String user_name = req.getParameter("uname");
		String user_mail = req.getParameter("umail");
		System.out.println("***Data From Html****");
		System.out.println("User Name:-"+user_name);
		System.out.println("User e-mail:-"+user_mail);
		
	}
	public void destroy()
	{
		System.out.println("------destroy invoked--------");
	}

}
