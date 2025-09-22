package com.ig.sbeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Component("course")
public class Course
{
	@Value("${sbeans.cource.name}")
	private String name;
	@Value("${sbeans.cource.prize}")
	private Double  prize;
	@Value("${sbeans.cource.duration}")
	private Double duration;
	
	
}
