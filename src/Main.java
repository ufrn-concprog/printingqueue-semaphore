/**
 * Simulation of a printing queue controlled by a semaphore
 * @author <a href="mailto:everton@dimap.ufrn.br">Everton Cavalcante</a>
 */
public class Main {
	/** Number of jobs to be printed */
	private static final int NUM_JOBS = 10;
	
	/**
	 * Main method
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		// Printing queue (shared resource)
		PrintingQueue queue = new PrintingQueue();
		
		// Instantiation of printing jobs as threads
		Job jobs[] = new Job[NUM_JOBS];
		for (int i = 0; i < NUM_JOBS; i++) {
			jobs[i] = new Job("Thread " + (i+1), queue); 
		}
		
		// Executing the threads
		for (int i = 0; i < NUM_JOBS; i++) {
			jobs[i].start();
		}
		
		// Waiting the threads to finish their execution
		for (int i = 0; i < NUM_JOBS; i++) {
			try {
				jobs[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All printing jobs have been finished.");
	}
}
