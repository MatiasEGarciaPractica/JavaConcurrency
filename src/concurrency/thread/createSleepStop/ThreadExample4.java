package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 * WAY to create a Thread -> anonymous class
 *  Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample4 {
	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable running");
				System.out.println("Runnable finished");
			}
			
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
