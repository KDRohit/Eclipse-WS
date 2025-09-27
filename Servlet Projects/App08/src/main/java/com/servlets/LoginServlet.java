package com.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.jbeans.User;

@WebServlet("/onLogin")
public class LoginServlet extends HttpServlet
{
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		 String name = (String) request.getParameter("user");
		 String pass = (String) request.getParameter("pass");
		 System.out.println("Name: "+name);
		 System.out.println("Pass: "+pass);
		 
		 User result =  UserDao.doLogin(name,pass);
		 if(result==null)
		 {
			 System.out.println("Login Failed!");
			 request.setAttribute("msg", "Invalid Credentials...");
			 request.getRequestDispatcher("registrationResult.jsp").forward(request, response);
		 }
		 else
		 {
			 System.out.println("Login Successfully!");
			 ServletContext context =  request.getServletContext();
			 context.setAttribute("ubean", result);
			 Cookie ck = new Cookie("name", result.getUserName());
			 request.getRequestDispatcher("home.jsp").forward(request, response);
		 }
	}
}
