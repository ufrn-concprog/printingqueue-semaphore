import java.util.concurrent.Semaphore;

/**
 * Class that manages (by using a semaphore) the concurrent access to a 
 * printing queue shared among multiple threads, each one simulating
 * a printing job.
 * 
 * @see java.util.concurrent.Semaphore
 * 
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class PrintingQueue {
	/** 
	 * Semaphore for suspending/notifying threads
	 * @see java.util.concurrent.Semaphore
	 */
	private final Semaphore semaphore;
	
	/** Default constructor */
	public PrintingQueue() {
		semaphore = new Semaphore(1, true);
	}
	
	/** Perform the printing job itself */
	public void printJob() {
		try {
			semaphore.acquire();
			
			// Thread is suspended by a random time interval to
			// simulate the printing job
			int duration = (int) (Math.random() * 5) + 1;
			System.out.print(Thread.currentThread().getName());
			System.out.print(" printing for " + duration + " second(s)\n");
			Thread.sleep(duration * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
