package com.ig;

import java.io.IOException;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmpServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("Request Received");
		EmpBean bean = new EmpBean();
		bean.setEmpId(req.getParameter("eid"));
		bean.setEmpFirstName(req.getParameter("efname"));
		bean.setEmpLastName(req.getParameter("elname"));
		bean.setSalary(Double.parseDouble(req.getParameter("eid")));
		bean.setAddress(req.getParameter("eaddr"));
		
		AddEmpDao empDao = new AddEmpDao();
		int rowCount =empDao.insertEmpData(bean);
		System.out.println("=======>"+rowCount);
		
		if(rowCount>0)
		{
			//System.out.println("Data inserted successfully");
			req.setAttribute("msg", "Data inserted successfully!!!<br><br>");
			req.getRequestDispatcher("AddEmp.jsp").forward(req, res);
		}
		else
		{
			//System.out.println("Data inserted failed");
			throw new RuntimeException("Data NOT inserted");
		}
	}
}
