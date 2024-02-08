package concurrency.javaMemory;

/**
 * 
 * @author matia
 *Bibliography
 *		https://www.youtube.com/watch?v=LCSqZyjBwWA&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=4
 */
public class SharedObject {

	public static void main(String[] args) {
		Runnable runnable = new MyRunnable();
		
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
	
		//same runnable,so, they will share the same count value
		thread1.start();
		thread2.start();
	
	}
}
