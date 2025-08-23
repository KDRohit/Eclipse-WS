package com.ig.main;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.ig.reflect.ReflectClass;

public class MainClass 
{
	public static void main(String[] args) throws Exception
	{
		ReflectClass rc = new ReflectClass();
		Class c = ReflectClass.class;
		Method m = c.getDeclaredMethod("getA");
		m.setAccessible(true);
		int val =  (int)m.invoke(rc);
		System.out.println("original A:-"+val);
		Field f = c.getDeclaredField("a");
		f.setAccessible(true);
		f.setInt(rc, 100);
		val =  (int)m.invoke(rc);
		System.out.println("reflected A:-"+val);
	}

}
