package com.ig.scheduling;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTest 
{
		//@Scheduled(fixedDelay = 1000)
		public void Timer()
		{
			
		}
		
		//@Scheduled(cron = "59 * * * * *")
		public void TaskOn59thSecond()
		{
			System.out.println("Current Time : : "+LocalDateTime.now());
			System.out.println("Job [scheduled] :: 59th Second of Each Minute");
		}
		
		@Scheduled(cron = "59 19 * * * *")
		public void TaskOnXXthMinute()
		{
			System.out.println("Current Time : : "+LocalDateTime.now());
			System.out.println("Job [scheduled] :: 19th Minute of Each Hour");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//@Scheduled(initialDelay = 1000, fixedDelay = 2000)
	public void Task1InLoop()
	{
		System.out.println("------TASK-1 STARTED at ["+LocalDateTime.now()+"]--------by ["+Thread.currentThread().getName()+"]-------");
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("----TASK-1 COMPLETED at ["+LocalDateTime.now()+"]--------by ["+Thread.currentThread().getName()+"]-------");
	}
	
	//@Scheduled(initialDelay = 2000, fixedDelay = 2000)
	public void Task2InLoop()
	{
		System.out.println("------TASK-2 STARTED at ["+LocalDateTime.now()+"]--------by ["+Thread.currentThread().getName()+"]-------");
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("----TASK-2 COMPLETED at ["+LocalDateTime.now()+"]--------by ["+Thread.currentThread().getName()+"]-------");
	}
}
