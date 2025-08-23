package com.ig.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("student")
@Lazy(true)
public class Student 
{
	@Autowired
	@Qualifier("hindi")
	private IMaterial material;
	
	private Student()
	{
		System.out.println("Student is created");
	}
	
	public void showMaterial()
	{
		System.out.println("Student (Course):- "+material.getMaterial());
	}
}
