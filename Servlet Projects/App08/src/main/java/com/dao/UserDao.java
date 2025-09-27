package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jbeans.User;

public class UserDao
{
	private static final String REG_QUERY= "insert into registration values(?,?,?,?,?,?)";
	private static final String LOG_IN_QUERY= "select * from registration where username=? and password = ?";
	private static final String UPDATE_QUERY="update registration set "
																				+ "firstname=?, "
																				+ "lastname=?, "
																				+ "mailid=?, "
																				+ "phone=? where "
																				+ "username= ? ";
	
	public static int doRegister(User user)
	{
		int rows = 0;
		Connection con =  ConnectionManager.getConnection();
		try 
		{
			PreparedStatement pstmt =  con.prepareStatement(REG_QUERY);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getMailId());
			pstmt.setLong(6, user.getPhoneNo());
			rows = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public static User doLogin(String user,String pass)
	{
		User result = null;
		Connection con = ConnectionManager.getConnection();
		try 
		{
			PreparedStatement pstmt =  con.prepareStatement(LOG_IN_QUERY);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next())
			{
				String userName =  rs.getString(1);
				String password =  rs.getString(2);
				String firstName =  rs.getString(3);
				String lastName =  rs.getString(4);
				String mailId =  rs.getString(5);
				Long phone =  rs.getLong(6);
				
				result= new User();
				result.setUserName(userName);
				result.setPassword(password);
				result.setFirstName(firstName);
				result.setLastName(lastName);
				result.setMailId(mailId);
				result.setPhoneNo(phone);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static int updateProfile(User user)
	{
		int rows = 0;
		Connection con = ConnectionManager.getConnection();
		try 
		{
			PreparedStatement pstmt =  con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getMailId());
			pstmt.setLong(4, user.getPhoneNo());
			pstmt.setString(5, user.getUserName());
			rows = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}
}
