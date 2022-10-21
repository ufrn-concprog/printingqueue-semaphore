/**
 * Implementation of a printing job as a thread
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Job extends Thread {
	/** Reference to the printing queue (shared resource) */
	protected final PrintingQueue queue;
	
	/**
	 * Parameterized constructor
	 * @param name Identification of the printing job
	 * @param queue Reference to the printing queue
	 */
	public Job(String name, PrintingQueue queue) {
		super(name);
		this.queue = queue;
	}

	/** Statements to be executed when the thread runs */
	@Override
	public void run() {
		System.out.println("Printing job sent by " + Thread.currentThread().getName());
		queue.printJob();		// Performs printing job
	}
}
