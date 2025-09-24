package com.ig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewEmpDao 
{
	ArrayList<EmpBean> al =  new ArrayList<EmpBean>();
	
	public ArrayList<EmpBean> retrieveEmpData()
	{
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt =  con.prepareStatement("select * from employee");
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next())
			{
				EmpBean bean = new EmpBean();
				bean.setEmpId(rs.getString(1));
				bean.setEmpFirstName(rs.getString(2));
				bean.setEmpLastName(rs.getString(3));
				bean.setSalary(rs.getDouble(4));
				bean.setAddress(rs.getString(5));
				al.add(bean);
			}
			return al;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
