package com.ig.sbeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;
@Data
@PropertySource("com/ig/properties/info.properties")
@Component("emp")
public class Employee 
{
	@Value("${emp.id}")
	private Integer id;
	@Value("${emp.name}")
	private String name;
	@Value("${emp.ms}")
	private Boolean isMarried;
}
