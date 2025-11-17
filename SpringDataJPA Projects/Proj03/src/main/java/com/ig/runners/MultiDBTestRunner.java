package com.ig.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ig.entity.mysql.DBAccount1;
import com.ig.entity.oracle.DBAccount2;
import com.ig.service.AccountService;

@Component
public class MultiDBTestRunner implements CommandLineRunner 
{
	@Autowired
	private AccountService service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		DBAccount1 entity1 = new DBAccount1("rohit", 1000.0);
		DBAccount2 entity2 = new DBAccount2("riya", 1000.0);
		String msg = service.save(entity1, entity2);
		System.out.println(msg);
	}

}
