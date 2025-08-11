package com.ig.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ig.sbeans.SeasonMessageGenerator;

public class ClassPathXmlApplication 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/ig/cfgs/ApplicationContext.xml");
		SeasonMessageGenerator smg = ctx.getBean("smg",SeasonMessageGenerator.class);
		System.out.println(smg.getMessage());
	}
}
