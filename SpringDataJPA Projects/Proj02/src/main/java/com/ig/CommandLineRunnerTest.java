package com.ig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ig.controllers.AppController;

@Component("commandLineRunnerTest")
public class CommandLineRunnerTest implements CommandLineRunner 
{
	@Autowired
	AppController appController;
	
	@Override
	public void run(String... args) throws Exception 
	{
		appController.showMenu(true);
	}
}
