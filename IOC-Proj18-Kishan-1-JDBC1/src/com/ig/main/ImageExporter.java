package com.ig.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageExporter 
{
	private String driverurl="com.mysql.cj.jdbc.Driver";
	private String dburl="jdbc:mysql://localhost/ingenuity";
	private String dbuser="root";
	private String dbpass="1234";
	
	private String tableName = "images_in_db";
	private String picExportPath = "D:\\Images Backup\\pic1.png";
	private String picImportPrePath = "D:\\Images Backup\\pic";
	private String picImportPostPath = "_Imported.png";
	
	Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(driverurl);
			con =  DriverManager.getConnection(dburl, dbuser, dbpass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void exportImage()
	{
		String sqlQuery = "insert into "+tableName+" values(?,?)";
		Connection con = getConnection();
		try
		{
			FileInputStream fis = new FileInputStream(picExportPath);
			PreparedStatement	pstmt = con.prepareStatement(sqlQuery);
			pstmt.setInt(1, 4);
			pstmt.setBlob(2, fis ,fis.available());
			
			int rows =  pstmt.executeUpdate();
			if(rows>0)
			{
				System.out.println("Data saved successfully!!!");
			}
			else
			{
				System.out.println("Data saving failed!!!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void importImage()
	{
		String sqlQuery = "select * from "+tableName;
		Connection con = getConnection();
		try
		{
			Statement stmt =  con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			int imgNo = 1;
			while(rs.next())
			{
				Blob blob =  rs.getBlob(2);
				byte[] bytes =  blob.getBytes(1, (int)blob.length());
				FileOutputStream fos = new FileOutputStream(picImportPrePath+ imgNo++ +picImportPostPath);
				fos.write(bytes);
				fos.close();
				System.out.println("File retrieved successfully");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		ImageExporter imgExp = new ImageExporter();
		//imgExp.exportImage();
		imgExp.importImage();
	}
}
