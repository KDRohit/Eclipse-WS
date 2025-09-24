package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.jbeans.Product;

@WebServlet("/viewProducts")
public class ViewServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		ArrayList<Product> list =null;
		try
		{
			 list = ProductDao.getProducts();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		req.setAttribute("items", list);
		req.getRequestDispatcher("viewProductResult.jsp").forward(req, res);
	}
}
