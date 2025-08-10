package com.ig.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.ig.sbeans.ClassA;
import com.ig.sbeans.ClassB;

public class DependencyInjectionTest 
{
	public static void main(String[] args) 
	{
		try(FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("src/com/ig/cfgs/ApplicationContext.xml"))
		{
			ClassA a = (ClassA)factory.getBean("a");
			ClassB b = (ClassB)factory.getBean("b");
			System.out.println(a.message);
			System.out.println(b.message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
