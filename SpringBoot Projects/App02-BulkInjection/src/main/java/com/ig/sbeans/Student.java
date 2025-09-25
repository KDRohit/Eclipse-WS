package com.ig.sbeans;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component("stu")
//@ConfigurationProperties(prefix = "sbean.student")
@PropertySource("application.yml")
@Data
public class Student
{
	private int rollNo;
	private String name;
	private int std;
	private String section;
}
