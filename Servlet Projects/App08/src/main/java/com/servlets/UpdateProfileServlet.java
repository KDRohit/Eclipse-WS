package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.jbeans.User;

@WebServlet("/onUpdate")
public class UpdateProfileServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		User user =  (User)request.getServletContext().getAttribute("ubean");
		user.setFirstName(request.getParameter("firNam"));
		user.setLastName(request.getParameter("lasNam"));
		user.setMailId(request.getParameter("lasNam"));
		user.setPhoneNo(Long.parseLong(request.getParameter("phoNo")));
		int rows = UserDao.updateProfile(user);
		if(rows==1)
		{
			System.out.println("User updated successfully!");
		}
		else
		{
			System.out.println("User updation failed!");
		}
	}

}
