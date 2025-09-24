package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import com.jbeans.Product;

public class ProductDao 
{
	private final static String INSERT_QUERY= "insert into product values(?,?,?,?)";
	private final static String SELECT_QUERY= "select * from product";
	
	public static  int insertProduct(Product product) throws Exception
	{
		int rows = 0;
		Connection con =  ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);
		pstmt.setInt(1, product.getpId());
		pstmt.setString(2, product.getpName());
		pstmt.setInt(3, product.getpPrice());
		pstmt.setInt(4, product.getpQty());
		rows =  pstmt.executeUpdate();
		return rows;
	}
	
	public static ArrayList<Product> getProducts() throws Exception
	{
		ArrayList<Product> list = null;
		Connection con = ConnectionManager.getConnection();
		 Statement stmt =  con.createStatement();
		 ResultSet rs =  stmt.executeQuery(SELECT_QUERY);
		 if(rs.next())
		 {
			 list = new ArrayList<Product>();
			 while(rs.next())
			 {
				 Product product = new Product();
				 product.setpId(rs.getInt(1));
				 product.setpName(rs.getString(2));
				 product.setpPrice(rs.getInt(3));
				 product.setpQty(rs.getInt(4));
				 list.add(product);
			 }
		 }
		return list;
	}
}
