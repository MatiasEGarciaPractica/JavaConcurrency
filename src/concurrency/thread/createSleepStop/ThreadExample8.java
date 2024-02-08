package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 *	How stop a thread.(Don't use stop() from Thread class, is deprecated and we don't know when will stop).
 * Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample8 {

	public static class StoppableRunnable implements Runnable{

		private boolean stopRequested = false;
		
		//if is synchronized means that only one Thread can call it at the same time
		public synchronized void requestStop() {
			this.stopRequested = true;
		}
		
		public synchronized boolean isStopRequested() {
			return this.stopRequested;
		}
		
		private void sleep(long millis) {
			try {
				Thread.sleep(millis);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			System.out.println("StoppableRunnable running");
			while(!isStopRequested()) {
				sleep(1000);
				System.out.println("...");
			}
			System.out.println("StoppableRunnable stopped");
		}
		
	}
	
	public static void main(String[] args) {
		StoppableRunnable stoppableRunnable = new StoppableRunnable();
		Thread thread = new Thread(stoppableRunnable, "The Thread");
		thread.start();
		
		try {
			Thread.sleep(5000); //The main thread sleeps for 5 seconds
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("requesting stop");
		stoppableRunnable.requestStop();
		System.out.println("stop requested");
	}
}
