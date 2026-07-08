package com.ig;

public class VirtualThreadDemo 
{
	public static void mainTemp(String[] args) throws InterruptedException
	{
		Runnable task1 = ()->
		{
			try 
			{
				System.out.println("task 1 is started by :: "+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("task 1 is completed by :: "+Thread.currentThread().getName());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		};
		
		Runnable task2 = ()->
		{
			try 
			{
				System.out.println("task 2 is started by :: "+Thread.currentThread().getName());
				Thread.sleep(4000);
				System.out.println("task 2 is complete by :: "+Thread.currentThread().getName());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		};
		
		Thread.Builder threadBuilder = Thread.ofVirtual();
		Thread worker1 =  threadBuilder.factory().newThread(task1);
		Thread worker2 = threadBuilder.factory().newThread(task2);
		
		worker1.setName("worker 1");
		worker1.start();
		worker2.setName("worker 2");
		worker2.start();
		
		worker1.join();
		worker2.join();
		
		System.out.println("main thread job is completed");
		
		
	}
}
