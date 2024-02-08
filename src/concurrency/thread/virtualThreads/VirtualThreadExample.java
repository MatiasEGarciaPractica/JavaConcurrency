package concurrency.thread.virtualThreads;

/**
 * 
 * @author matia
 * VIRTUAL THREAD
 * Bibliography
 * 	https://www.youtube.com/watch?v=kirhhcFAGB4&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=3
 */
public class VirtualThreadExample {
 
	public static void main(String[] args) {
		//Example 1: Create Runnable. Create and start virtual thread
		Runnable runnable = () -> {
			for(int i = 0; i < 10 ; i++) {
				System.out.println("Index: " + i);
			}
		};
		
		
		@SuppressWarnings("unused")
		Thread vTrhead1 = Thread.ofVirtual().start(runnable);//we start the virtual thread at the moment
		
		Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable); 
		
		vThreadUnstarted.start();//now the start the virtual tread
		
		//how to join a virtual thread?
		try {
			vThreadUnstarted.join(); //now until this virtual thread finish, the main thread not ends.
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	}
}
