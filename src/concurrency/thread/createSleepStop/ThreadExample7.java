package concurrency.thread.createSleepStop;
/**
 * 
 * @author matia
 *	Sending to sleep a thread.
 * Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample7 {
	
	public static void main(String[] args) {
		Runnable runnable = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " running");
			
			try {
				Thread.sleep(2000); //2 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(threadName + " finished");
		};
		
		Thread thread = new Thread(runnable, "The thread");
		thread.start();
	}
}
