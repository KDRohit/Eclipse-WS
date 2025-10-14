package com.ig;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Prog2FunctionalInterface 
{
	Supplier<String> supplier ; 					// method_name : get();
	Consumer<String> consumer ;				// method_name : accept();
	Predicate<String> filter;							// method_name : test();
	Function<String,String> function;  // method_name : apply();
	
	void test(String value)
	{
		supplier=()->value;
		consumer = str->System.out.println(str);
		consumer.accept(supplier.get());
		filter=str->str.toLowerCase().startsWith("a");
		consumer.accept("("+value+") starts with (a/A) :"+filter.test(value));
		function = str->new StringBuilder(str).reverse().toString();
		consumer.accept("Reverse of ("+value+") : "+function.apply(value));
		filter=str->str.equals(value);
		consumer.accept("Pallindrone ("+value+") : "+filter.test(function.apply(value)));
	}
	
	public static void main(String[] args) 
	{
		Prog2FunctionalInterface prog2 = new Prog2FunctionalInterface();
		prog2.test("racecar");
	}
}
