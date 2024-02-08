package concurrency.compareandswap;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 
 * @author matia
 * lock with compare and swap
 * origin -> https://www.youtube.com/watch?v=ufWVK7CHOAk&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=21
 */
public class CompareAndSwapLock{
	
	private AtomicBoolean atomicLocked = new AtomicBoolean(false);//to know when is lock and when allow another thread enter the code
	
	private void unlock() {
		this.atomicLocked.set(false);//we allow another thread to lock the lock
	}
	
	public void lock() {
		while(!this.atomicLocked.compareAndSet(false, true)) {
			//busy wait - until compareAndSet succeds
		}
	}
	
	
}
