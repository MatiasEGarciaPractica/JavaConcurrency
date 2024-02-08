package concurrency.thread;

/**
 * 
 * @author matia
 * Bibliography
 * 	https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
 *
 */
public class ThreadExample {

	public static void main(String[] args) {//run a thread, the main thread
		Thread thread = new Thread();
		thread.start();//now we have 2 threads, the main thread and this that we start
		
	}
}
