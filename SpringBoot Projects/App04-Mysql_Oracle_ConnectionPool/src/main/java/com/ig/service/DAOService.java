package com.ig.service;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.dao.IDAO;

import lombok.ToString;

@Service("service")
@ToString
public class DAOService
{
	@Autowired
	private IDAO dao;
	
	public <T> ArrayList<T> select(String tableName,T t) throws SQLException 
	{
		return  dao.select(tableName, t);
	}
	public <T> int insert(String tableName,T t) throws SQLException 
	{
		return  dao.insert(tableName, t);
	}
	public <T> int update(String tableName,T t) throws SQLException 
	{
		return  dao.update(tableName, t);
	}
}
