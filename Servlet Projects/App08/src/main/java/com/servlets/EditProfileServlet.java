package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.jbeans.User;

@WebServlet("/onEditProfile")
public class EditProfileServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		User user = new User();
		user.setUserName(request.getParameter("use"));
		user.setFirstName(request.getParameter("firNam"));
		user.setLastName(request.getParameter("lasNam"));
		user.setMailId(request.getParameter("lasNam"));
		user.setPhoneNo(Long.parseLong(request.getParameter("phoNo")));
		int rows = UserDao.updateProfile(user.getUserName(),user);
		if(rows>0)
		{
			System.out.println("Profile updated successfully!");
			request.setAttribute("msg","Profile updated successfully!" );
		}
		else
		{
			System.out.println("Profile updation failed!");
			request.setAttribute("msg","Profile updation failed!" );
		}
	}
}
