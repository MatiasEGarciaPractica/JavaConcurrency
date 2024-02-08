package concurrency.thread.createSleepStop;

/**
 * 
 * @author matia
 * The jvm will be alive meanwhile there is one thread running, it doesn't need to be the main thread.
 * DAEMON THREAD
 *  Bibliography
 *  https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample9 {
	
	public static void main(String[] args) {
		//this runnable will run forever
		Runnable runnable = () -> {
			while(true) {
				sleep(1000);
				System.out.println("Running");
			}
		};
		
		Thread threadForever = new Thread(runnable);
		threadForever.setDaemon(true);
		threadForever.start();
		sleep(3100);//this will sleep main thread by 3100 seconds 
		//the main thread will finish but the threadForever will keep runnning because will sleep forever, but if 
		//you make threadForever a daemon thread then will stop when the main thread stop.
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
