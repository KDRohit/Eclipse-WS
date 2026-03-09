package com.ig.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest 
{
	@Mock
	Calculator cal;
	
	@Test
	public void testCase1()
	{
		when(cal.sum(1, 4)).thenReturn(5);
		assertEquals(5, cal.sum(2, 3));
	}
}
