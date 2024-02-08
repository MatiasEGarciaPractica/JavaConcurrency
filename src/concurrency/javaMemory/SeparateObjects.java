package concurrency.javaMemory;

/**
 * 
 * @author matia
 *	Bibliography
 *		https://www.youtube.com/watch?v=LCSqZyjBwWA&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=4
 */
public class SeparateObjects {
	
	public static void main(String[] args) {
		Runnable runnable1 = new MyRunnable();
		Runnable runnable2 = new MyRunnable();
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
	
		//two different runnable ,so, two different count value.
		thread1.start(); //count will begin on 0 to 1000000;
		thread2.start(); //count will begin on 0 to 1000000;
	
	}
}
