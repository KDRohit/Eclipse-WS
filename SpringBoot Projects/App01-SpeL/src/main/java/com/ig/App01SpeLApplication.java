package com.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ig.sbeans.Course;
import com.ig.sbeans.Student;

@SpringBootApplication
@PropertySource("com/ig/cfgs/application2.properties")
public class App01SpeLApplication {
	
	public static void main(String[] args) {
		try(
				ConfigurableApplicationContext cac =  SpringApplication.run(App01SpeLApplication.class, args);
			)
		{
			Course course =  cac.getBean("course",Course.class);
			Student student = cac.getBean("student",Student.class);
			
			System.out.println(course);
			System.out.println(student);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
