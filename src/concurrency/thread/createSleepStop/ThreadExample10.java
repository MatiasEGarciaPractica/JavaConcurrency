package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 * Make a thread wait for another thread.
 *  Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 */
public class ThreadExample10 {
	
	public static void main(String[] args) {
		Runnable runnable = () -> {
			for(int i = 0 ; i < 5 ; i++) {
				sleep(1000);
				System.out.println("Running");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true); //if main thread finish then this finish too.
		thread.start();
		
		
		//we want that the main thread waits the daemon thread to finish.
		try {
			thread.join();//now the main thread will wait.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
