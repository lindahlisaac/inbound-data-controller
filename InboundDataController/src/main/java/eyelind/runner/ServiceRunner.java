package eyelind.runner;

public class ServiceRunner {

	
	private static boolean running;
	
	public static void main(String[] args) {

		NewInboundFileThread newThread = new NewInboundFileThread();
		Runtime.getRuntime().addShutdownHook(newThread);
		boolean running = true;
		
		while (running) {
			
			setShutdownHook(newThread.getShutdownHook());
			
			try {
				
				System.out.println("Running...");
			} catch (Exception e) {
			}
			
			running = getShutdownHook();
			if (!running) {
				System.out.println("Shutdown hook found, terminating programmain thread...");
				System.exit(1);
			}
		}
	}

	private static boolean getShutdownHook() {
		return running;
	}
	
	public static void setShutdownHook(boolean isRunning) {
		running = isRunning;
	}

}
