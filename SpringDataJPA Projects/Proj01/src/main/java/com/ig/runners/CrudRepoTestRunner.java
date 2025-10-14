package com.ig.runners;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ig.entity.Politician;
import com.ig.service.IPoliticianService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IPoliticianService polService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		try
		{
			// create the entity object
			Politician politician = new Politician();
			politician.setName("rohit");
			politician.setArea("kanpur");
			politician.setParty("BJP");
			politician.setIncome(89090.0);
			String msg = polService.registerPolitician(politician);
			System.out.println(msg);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
