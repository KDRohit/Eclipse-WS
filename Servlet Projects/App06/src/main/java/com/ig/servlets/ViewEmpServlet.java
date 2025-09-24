package com.ig.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ig.DAO.ViewEmpDao;
import com.ig.jbeans.EmpBean;

@WebServlet("/view")
public class ViewEmpServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		System.out.println("Request Received By :-"+this.getServletName());
		ViewEmpDao viewObj = new ViewEmpDao();
		ArrayList<EmpBean> al = viewObj.retrieveEmpData();
		request.setAttribute("list", al);
		request.getRequestDispatcher("viewEmp.jsp").forward(request, response);
	}
}
