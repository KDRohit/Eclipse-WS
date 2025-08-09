package com.ig.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ig.sbeans.SeasonMessageGenerator;

public class DependencyInjectionTest 
{
	public static void main(String[] args) 
	{
		FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("src/com/ig/cfgs/ApplicationContext.xml");
		factory.close();
	}

}
