package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 * WAY to create a Thread -> extends the Thread class.
 * Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 * 
 */
public class ThreadExample2 {
	
	public static class MyThread extends Thread{

		@Override
		public void run() {
			System.out.println("My thread running");
			System.out.println("My thread finished");
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}
}
