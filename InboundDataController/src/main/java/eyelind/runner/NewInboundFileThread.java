package eyelind.runner;

public class NewInboundFileThread extends Thread {

	public void run() {
		System.out.println("New thread started...");
		ServiceRunner.setShutdownHook(false);
	}
	
	 public boolean getShutdownHook() {
         return this.getShutdownHook();
     }
	 
}
