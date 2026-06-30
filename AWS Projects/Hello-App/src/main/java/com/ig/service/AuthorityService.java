package com.ig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.Authority;
import com.ig.repo.IAuthorityRepo;

@Service
public class AuthorityService 
{
	@Autowired
	private IAuthorityRepo authRepo;
	
	public List<Authority> getAll()
	{
		return authRepo.findAll();
	}
	
	public String save(Authority data)
	{
		Authority saved =  authRepo.save(data);
		return "[ Authority :: "+saved+" saved successfully!!!]";
	}
}
