package com.ig.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component("student")
public class Student 
{
	@Value("${sbeans.student.name}")
	private String name;
	
	@Value("#{T(java.lang.Math).random() * 100}")
	private Integer  rollNo;
	
	@Value("#{course}")
	private Course cource;
	
	@Value("#{course.getName()}")
	private String courceName;

	@Value("#{factory}")
	private IAccount account;
}
