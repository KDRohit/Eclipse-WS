package com.ig.DAO;

import java.util.List;

import com.ig.models.Developer;

public interface IDeveloperDAO
{
	public List<Developer> getAllDevelopers() throws Exception;
	public List<Developer> getDevelopersBasedOnId(String empId) throws Exception;
	public int insertDeveloper(Developer dev) throws Exception;
	
}
