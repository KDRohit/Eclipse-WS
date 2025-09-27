package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onView")
public class ViewProfileServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		Cookie[] arr = request.getCookies();
		String fname = null;
		if(arr==null)
		{
			String msg="Session Expired!!!";
			request.setAttribute("msg",msg );
			request.getRequestDispatcher("registrationResult.jsp").forward(request, response);
		}
		else
		{
			for(Cookie ck:arr)
			{
				if("name".equals(ck.getName()))
				{
					fname= ck.getValue();
					break;
				}
			}
			request.setAttribute("fname",fname );
			request.getRequestDispatcher("viewProfile.jsp").forward(request, response);
		}
	}
	
}
