package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 * WAY to create a Thread -> lambda expression
 *  Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample5 {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			System.out.println("Lambda running");
			System.out.println("Lambda finished");
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
}
