package com.ig.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDAO
{
	public <T> ArrayList<T> select(String tableName,T t) throws SQLException;
	public <T> int insert(String tableName,T t) throws SQLException;
	public int update();
	public int delete();
}
