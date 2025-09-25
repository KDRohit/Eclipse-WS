package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ig.sbeans.Student;

@SpringBootApplication
@PropertySource("application.yml")
public class App02BulkInjectionApplication {

	public static void main(String[] args)
	{
		try(ConfigurableApplicationContext cac =  SpringApplication.run(App02BulkInjectionApplication.class, args);)
		{
			Student stu =  cac.getBean("stu",Student.class);
			System.out.println(stu);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
