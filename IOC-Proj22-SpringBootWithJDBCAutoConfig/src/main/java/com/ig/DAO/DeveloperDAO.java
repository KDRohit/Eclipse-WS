package com.ig.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ig.models.Developer;

@Repository("devdao")
public class DeveloperDAO implements IDeveloperDAO
{
	@Autowired
	private DataSource datasource;
	
	private final String GET_DEV_QUERY="SELECT empId,empName,action FROM developerslog";
	private final String GET_DEV_BY_ID_QUERY="SELECT empId,empName,action FROM developerslog WHERE empId=?";
	private final String INSERT_DEV_QUERY = "INSERT INTO developerslog VALUES(?,?,?,?)";
	
	@Override
	public List<Developer> getAllDevelopers() throws Exception
	{
		List<Developer> devs = null;
		
		try(
				Connection con =  datasource.getConnection();
				)
		{
			PreparedStatement pstmt = con.prepareStatement(GET_DEV_QUERY);
			try(ResultSet rs =  pstmt.executeQuery();)
			{
				devs = new ArrayList<Developer>();
				while(rs.next())
				{
					String eid =  rs.getString(1);
					String ename = rs.getString(2);
					String action = rs.getString(3);
					
					Developer dev = new Developer(eid,ename,action);
					devs.add(dev);
				}
			}
		}
		catch (Exception e) 
		{
			throw e; // this is exception rethrowing...
		}
		return devs;
	}

	@Override
	public List<Developer> getDevelopersBasedOnId(String empId) throws Exception 
	{
		List<Developer> devs = null;
		try(
				Connection con =  datasource.getConnection();
			)
		{
			PreparedStatement pstmt =  con.prepareStatement(GET_DEV_BY_ID_QUERY);
			pstmt.setString(1, empId);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				devs = new ArrayList<Developer>();
				while(rs.next())
				{
					String eid =  rs.getString(1);
					String ename = rs.getString(2);
					String action = rs.getString(3);
					
					Developer dev = new Developer(eid,ename,action);
					devs.add(dev);
				}
			}
		}
		catch (Exception e) 
		{
			throw e; // this is exception rethrowing...
		}
		
		return devs ;
	}

	@Override
	public int insertDeveloper(Developer dev) throws Exception
	{
		System.out.println(datasource);
		int result = 0;
		try(Connection con = datasource.getConnection())
		{
			PreparedStatement pstmt =  con.prepareStatement(INSERT_DEV_QUERY);
			pstmt.setString(1, dev.getEmpId());
			pstmt.setString(2, dev.getEmpName());
			pstmt.setString(3, dev.getEmpAction());
			pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			result = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			throw e;// this is exception rethrowing...
		}
		return result;
	}
}
