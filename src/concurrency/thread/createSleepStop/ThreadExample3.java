package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 * WAY to create a Thread -> implements Runnable.
 * Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample3 {

	public static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("MyRunnable running");
			System.out.println("MyRunnable finished");
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}
