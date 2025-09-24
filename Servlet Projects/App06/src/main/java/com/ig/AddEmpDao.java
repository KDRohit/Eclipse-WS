package com.ig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmpDao 
{
	public static void main1(String[] args) 
	{
		EmpBean bean = new EmpBean();
		
		bean.setEmpId("1");
		bean.setEmpFirstName("rohit");
		bean.setEmpLastName("dubey");
		bean.setSalary(1200.50);
		bean.setAddress("nimi");
		
		AddEmpDao instance = new AddEmpDao();
		instance.insertEmpData(bean);
	}
	
	public int insertEmpData(EmpBean eb)
	{
		int rowCount = 0;
		String insertQuery = "insert into employee values(?,?,?,?,?)";
		try
		{
			Connection con =  DBConnection.getConnection();
			PreparedStatement pstmt =  con.prepareStatement(insertQuery);
			pstmt.setString(1, eb.getEmpId());
			pstmt.setString(2, eb.getEmpFirstName());
			pstmt.setString(3, eb.getEmpLastName());
			pstmt.setDouble(4, eb.getSalary());
			pstmt.setString(5, eb.getAddress());
			rowCount = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return rowCount;
	}
}
