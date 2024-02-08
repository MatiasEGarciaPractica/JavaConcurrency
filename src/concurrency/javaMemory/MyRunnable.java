package concurrency.javaMemory;

/**
 * 
 * @author matia
 *	Bibliography
 *		https://www.youtube.com/watch?v=LCSqZyjBwWA&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=4
 */
public class MyRunnable implements Runnable{
	
	//belongs to the MyRunnable object
	private int count = 0; //each object of this class will have it's own count value. because this var is saved on the thread stack.
	// to share the state between threads it has to be an object(so is saved on the heap memory)
	
	@Override
	public void run() {
		
		//each thread that executes this run method will instantiate a new MyObject
		@SuppressWarnings("unused")
		MyObject myObject = new MyObject();//belongs to the thread
		
		for( int i = 0 ; i< 1_000_000; i ++) { //this int i will no be shared between threads.
			this.count++;
		}
		
		System.out.println(Thread.currentThread().getName() + " : " + this.count);
	}
}