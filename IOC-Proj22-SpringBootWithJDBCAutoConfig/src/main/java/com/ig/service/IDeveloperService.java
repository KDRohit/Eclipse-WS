package com.ig.service;

import java.util.List;

import com.ig.models.Developer;

public interface IDeveloperService
{
	public List<Developer> getAllDevelopers() throws Exception ;
	public List<Developer> getDevelopersBasedOnId(String empId) throws Exception;
	public String insertDeveloper(Developer dev) throws Exception;
}
