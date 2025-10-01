package com.ig.dao;

import java.util.ArrayList;
import java.util.List;

public interface IDAO
{
	//public <T> ArrayList<T> select();
	public <T> int insert(String tableName,T t);
	public int update();
	public int delete();
}
