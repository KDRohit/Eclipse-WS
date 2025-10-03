package com.ig.runners;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ig.controller.DAOController;
import com.ig.sbeans.Employee;

@Component("cmdRunner")
public class CommandLineRunnerApp implements CommandLineRunner
{
	@Autowired
	private DAOController daoController;
	
	@Override
	public void run(String... args) throws Exception
	{
		daoController.showDBInfo();
		daoController.showDBServices(true);
	}
}
