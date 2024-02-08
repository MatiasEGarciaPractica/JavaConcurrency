package concurrency.compareandswap;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author matia
 * 
 * Allowing more that one thread to enter the critical section but only one can commit its result.
 * 
 * origin -> https://www.youtube.com/watch?v=ufWVK7CHOAk&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=21
 */
public class OptimisticLockCounter{
	
	private AtomicLong count = new AtomicLong();
	
	public void inc() {
		boolean incSuccessful = false;
		while(!incSuccessful) { //only while the new value is different than the current value
			long value = this.count.get(); //value == 10
			long newValue = value + 1;   //nw value 11
			
			incSuccessful = this.count.compareAndSet(value, newValue); //only one threa can compare with success
		}
	}
	
	public long getCount() {
		return this.count.get();
	}
	
}
