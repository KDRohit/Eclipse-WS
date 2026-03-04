package com.ig.logic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest 
{
	@Test
	public void sumTest1()
	{
		Calculator calculator = new Calculator();
		assertEquals(7, calculator.sum(2, 5));
	}
	
	@Test
	public void sumTest2()
	{
		Calculator calculator = new Calculator();
		assertEquals(10, calculator.sum(5, 5));
	}
}
