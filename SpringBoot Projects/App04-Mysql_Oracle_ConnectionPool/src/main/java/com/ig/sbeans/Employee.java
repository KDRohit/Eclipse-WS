package com.ig.sbeans;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class Employee implements ITable
{
	private String eid;
	private String efn;
	private String eln;
	private Integer sal;
	private String add;
}
