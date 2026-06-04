package com.ig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DeadLockThreadDumpRunnerTest implements CommandLineRunner 
{
	static final Object lock1 = new Object();
    static final Object lock2 = new Object();
    
	@Override
	public void run(String... args) throws Exception 
	{
		//print();
		 Thread t1 = new Thread(() -> {
	            synchronized (lock1) {
	                System.out.println("Thread-1: Holding lock1...");
	                sleep(100);

	                System.out.println("Thread-1: Waiting for lock2...");
	                synchronized (lock2) {
	                    System.out.println("Thread-1: Acquired lock2");
	                }
	            }
	        });

	        Thread t2 = new Thread(() -> {
	            synchronized (lock2) {
	                System.out.println("Thread-2: Holding lock2...");
	                sleep(100);

	                System.out.println("Thread-2: Waiting for lock1...");
	                synchronized (lock1) {
	                    System.out.println("Thread-2: Acquired lock1");
	                }
	            }
	        });
	        
	        t1.setName("Rohit");
	        t2.setName("Amit");
	        t1.start();
	        t2.start();
	}

	private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	
}
