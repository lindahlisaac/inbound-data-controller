package eyelind.runner;

public class ServiceRunner {

	
	private static boolean running;
	
	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new NewInboundFileThread());
		boolean running = true;
		
		while (running) {
			
			try {
				
				setShutdownHook(true);
			} catch (Exception e) {
				setShutdownHook(false);
			}
			
			running = getShutdownHook();
			if (!running) {
				System.out.println("Shutdown hook true, terminating program safely...");
				System.exit(1);
			}
		}
		
	}

	private static boolean getShutdownHook() {
		return running;
	}
	
	private static void setShutdownHook(boolean isRunning) {
		running = isRunning;
	}

}
