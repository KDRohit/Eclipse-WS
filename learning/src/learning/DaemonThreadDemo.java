package learning;

public class DaemonThreadDemo implements Runnable
{ 
	@Override
	public void run() throws Exception {
		int i=0;
		while(true)
		{
			System.out.println("daemon thread :: "+i++);
			Thread.currentThread().sleep(1000);
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		DaemonThreadDemo daemonThreadDemoObject = new DaemonThreadDemo();
		Thread t = new Thread(daemonThreadDemoObject);
		t.setDaemon(true);
		t.start();
		Thread.currentThread().sleep(10000);
	}
}
