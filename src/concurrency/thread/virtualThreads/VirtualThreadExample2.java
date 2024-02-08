package concurrency.thread.virtualThreads;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author matia
 *
 *To show that we can create 100000 of virtuals threads, thing that we cannot achive with platform threads
 *Bibliography
 * 	https://www.youtube.com/watch?v=kirhhcFAGB4&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=3
 */
public class VirtualThreadExample2 {

	public static void main(String[] args) {
		
		List<Thread> vThreads = new ArrayList<>();
		
		int vThreadCount = 100_000;
		
		//we create the 100000 of virtuals threads
		for(int i=0 ; i < vThreadCount ; i++) {
			int vThreadIndex = i;
			Thread vThread = Thread.ofVirtual().start(() -> {
				int result = 1;
				for(int j = 0; j< 10 ; j++) {
					result *= (j+1);
				}
				System.out.println("Result[" + vThreadIndex + "]: " + result);
			});
			vThreads.add(vThread);
		}
		
		//we join all the virtuals threads
		for(int i = 0 ; i < vThreads.size(); i++) {
			try {
				vThreads.get(i).join();
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
