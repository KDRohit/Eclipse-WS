package com.ig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.DAO.IDeveloperDAO;
import com.ig.models.Developer;

@Service("DevService")
public class DeveloperService implements IDeveloperService 
{
	@Autowired
	IDeveloperDAO dao;
	
	@Override
	public List<Developer> getAllDevelopers() throws Exception
	{
		List<Developer>  devs = dao.getAllDevelopers();
		return devs;
	}
	@Override
	public List<Developer> getDevelopersBasedOnId(String id) throws Exception
	{
		List<Developer>  devs = dao.getDevelopersBasedOnId(id);
		return devs;
	}
	@Override
	public String insertDeveloper(Developer dev) throws Exception 
	{
		 int result = dao.insertDeveloper(dev);
		 String r = result==1?"Data Inserted Successfully!":"Data insertion failed!!!";
		 return r;
	}
}
