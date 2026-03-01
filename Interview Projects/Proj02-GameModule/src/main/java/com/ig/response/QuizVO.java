package com.ig.response;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class  QuizVO {
	public Integer id;
	public String que;
	public String opt1;
	public String opt2;
	public String opt3;
	public String opt4;
}
