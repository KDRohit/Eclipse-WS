package com.ig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ig.models.Developer;
import com.ig.service.IDeveloperService;

@Controller("devcontroller")
public class DevController 
{
	@Autowired
	private IDeveloperService devService;
	
	public List<Developer> getAllDevelopers() throws Exception
	{
		return devService.getAllDevelopers();
	}
	public List<Developer> getDevelopersBasedOnId(String id) throws Exception
	{
		return devService.getDevelopersBasedOnId(id);
	}
	public String InsertDev(Developer dev) throws Exception
	{
		return devService.insertDeveloper(dev);
	}
}
