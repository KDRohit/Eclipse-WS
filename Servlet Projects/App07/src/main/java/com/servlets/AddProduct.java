package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.jbeans.Product;

@WebServlet("/addProducts")
public class AddProduct extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		System.out.println("request received by "+this.getServletName());
		Product product = new Product();
		product.setpId(Integer.parseInt(request.getParameter("pid")));
		product.setpName((String)request.getParameter("pname"));
		product.setpPrice(Integer.parseInt(request.getParameter("pprize")));
		product.setpQty(Integer.parseInt(request.getParameter("pqnty")));
		try
		{
			int rows =  ProductDao.insertProduct(product);
			String msg = rows==1?"product added Successfully!!!":"product failed to add in DB";
			System.out.println("msg:"+msg);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("addProdutResult.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
