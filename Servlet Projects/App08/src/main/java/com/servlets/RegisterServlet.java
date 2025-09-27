package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.jbeans.User;

@WebServlet("/onRegister")
public class RegisterServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		User user = new User();
		user.setUserName(request.getParameter("use"));
		user.setPassword(request.getParameter("pas"));
		user.setFirstName(request.getParameter("firNam"));
		user.setLastName(request.getParameter("lasNam"));
		user.setMailId(request.getParameter("lasNam"));
		user.setPhoneNo(Long.parseLong(request.getParameter("phoNo")));
		
		int rows = UserDao.doRegister(user);
		String msg = rows==1?"Data Inserted Successfully!!!":"Data Insertion Failed!!!";
		request.setAttribute("msg",msg );
		request.getRequestDispatcher("registrationResult.jsp").forward(request, response);
	}
}
