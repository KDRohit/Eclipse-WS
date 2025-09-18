package com.ig.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updateSalary")
public class SalaryUpdater extends GenericServlet
{

	@Override
	public void init()
	{
		System.out.println("--------Salary Updater Initialized------");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String empName =  req.getParameter("empName");
		String empId = req.getParameter("empId");
		int empSal =   Integer.parseInt(req.getParameter("empSal"));
		int empExp = Integer.parseInt(req.getParameter("empExp"));
		
		
		if(empExp>=5)
			empSal*=1.2;
		
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		
		pw.println("<center><h2><br><br>");
		pw.println("********Employee Data*******");
		pw.println("<br>Employee Name:-"+empName);
		pw.println("<br>Employee Id:-"+empId);
		pw.println("<br>Employee Salary:-"+empSal);
		pw.println("<br>Employee Experience:-"+empExp);
	}
	@Override
	public void destroy()
	{
		System.out.println("--------Salary Updater Destroyed");
	}
	

}
