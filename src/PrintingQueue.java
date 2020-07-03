import java.util.concurrent.Semaphore;

/**
 * Class that manages (by using a semaphore) the concurrent access to a 
 * printing queue shared among multiple threads, each one simulating
 * a printing job.
 * 
 * @see java.util.concurrent.Semaphore
 * 
 * @author <a href="mailto:everton@dimap.ufrn.br">Everton Cavalcante</a>
 */
public class PrintingQueue {
	/** 
	 * Semaphore for suspending/notifying threads
	 * @see java.util.concurrent.Semaphore
	 */
	private Semaphore semaphore;
	
	/** Default constructor */
	public PrintingQueue() {
		semaphore = new Semaphore(1, true);
	}
	
	
	/**
     * Perform the printing job itself.<br>
     * By implementing mutual exclusion supported by a semaphore, 
     * only one job access the printing queue at a time through
     * the call to the <code>acquire</code> method on the semaphore, 
     * which automatically blocks other jobs attempting to access
     * the printing queue. 
     * After using the printing queue, the resource is released by
     * calling the <code>release</code> method on the semaphore, 
     * which automatically makes some job eventually suspended to
     * be notified for execution.
     */
	public void printJob() {
		try {
			semaphore.acquire();
			
			// Thread is suspended by a random time interval to
			// simulate the printing job
			int duration = (int) (Math.random() * 5) + 1;
			System.out.print(Thread.currentThread().getName());
			System.out.print(" printing by " + duration + "s\n");
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
