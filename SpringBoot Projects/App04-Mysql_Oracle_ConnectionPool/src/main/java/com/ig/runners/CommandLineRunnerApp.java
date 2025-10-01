package com.ig.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ig.controller.DAOController;

@Component("cmdRunner")
public class CommandLineRunnerApp implements CommandLineRunner
{
	@Autowired
	private DAOController daoController;
	
	@Override
	public void run(String... args) throws Exception
	{
		daoController.showDBService();
	}
}
