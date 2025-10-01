package com.ig.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ig.service.DAOService;

@Controller("daoController")
public class DAOController
{
	@Autowired
	private  DAOService dbService;
	
	public void showDBService()
	{
		System.out.println(dbService);
	}
	
}
