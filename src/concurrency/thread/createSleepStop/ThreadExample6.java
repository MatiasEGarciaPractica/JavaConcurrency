package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 *	Access to the Thread executed name.
 * We don't have guarantees of which thread will be executed first, can be thread 1 or thread 2.
 *  Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample6 {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println( threadName +" running");
		};
		
		Thread thread = new Thread(runnable, "The Thread 1");
		thread.start();
		
		Thread thread2 = new Thread(runnable, "The Thread 2");
		thread2.start();
	}
}
