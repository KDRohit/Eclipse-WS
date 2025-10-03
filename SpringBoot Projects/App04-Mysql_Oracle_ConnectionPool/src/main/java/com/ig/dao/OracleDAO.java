package com.ig.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.ig.sbeans.Employee;

import lombok.ToString;

@Repository("DAO")
@Profile({"test","prod"})
@ToString
public class OracleDAO implements IDAO
{
	  @Autowired 
	  private DataSource ds;
	 
	 @Override
		public <T> ArrayList<T> select(String tableName,T t) throws SQLException 
	   {
		   Connection con =  ds.getConnection();
		   Statement stmt =  con.createStatement();
		   ResultSet rs =  stmt.executeQuery("select * from "+tableName);
		   if(t instanceof Employee)
		   {
			   ArrayList<Employee> list = new ArrayList<Employee>();
			   while(rs.next())
			   {
				   Employee e = new Employee();
				   e.setEid(rs.getString(1));
				   e.setEfn(rs.getString(2));
				   e.setEln(rs.getString(3));
				   e.setSal(rs.getInt(4));
				   e.setAdd(rs.getString(5));
				   list.add(e);
			   }
			   return (ArrayList<T>)list;
		   }
		   return null;
		}
		@Override
		public <T> int insert(String tableName, T t) throws SQLException 
		{
			int rows = 0;
			if(t instanceof Employee)
			{
				Employee e = (Employee)t;
				Connection con =  ds.getConnection();
				PreparedStatement pstmt =  con.prepareStatement("insert into "+tableName+" values (?,?,?,?,?)");
				pstmt.setString(1, e.getEid());
				pstmt.setString(2, e.getEfn());
				pstmt.setString(3, e.getEln());
				pstmt.setInt(4, e.getSal());
				pstmt.setString(5, e.getAdd());
				rows = pstmt.executeUpdate();
			}
			return rows;
		}

		@Override
		public int update() 
		{
			return 0;
		}

		@Override
		public int delete() 
		{
			return 0;
		}
}
