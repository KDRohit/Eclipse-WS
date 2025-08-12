package com.ig.main;

import java.lang.reflect.Field;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ig.sbeans.SeasonMessageGenerator;

public class ClassPathXmlApplication 
{
	public static void main(String[] args) throws Exception 
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/ig/cfgs/ApplicationContext.xml");
		SeasonMessageGenerator smg = ctx.getBean("smg",SeasonMessageGenerator.class);
		System.out.println(smg.getMessage());
		
	}
}
