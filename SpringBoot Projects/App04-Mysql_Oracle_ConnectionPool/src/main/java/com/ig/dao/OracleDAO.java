package com.ig.dao;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import lombok.ToString;

@Repository("DAO")
@Profile({"pro,tester"})
@ToString
public class OracleDAO implements IDAO
{
	@Autowired
	private DataSource ds;
	
	@Override
	public <T> int insert(String tableName, T t)
	{
		return 0;
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
