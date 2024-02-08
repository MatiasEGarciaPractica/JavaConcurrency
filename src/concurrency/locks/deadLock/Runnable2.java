package concurrency.locks.deadLock;

import java.util.concurrent.locks.Lock;

/**
 * 
 * @author matia
 *	This runnable does the same thing than Runnable1 but in reverse.
 */
public class Runnable2 implements Runnable{


	private Lock lock1 = null;
	private Lock lock2 = null;
	
	public Runnable2(Lock lock1,Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		
		System.out.println(threadName + " attempting to lock Lock 2");
		lock2.lock();
		System.out.println(threadName + " lock lock 2");
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			
		}
		
		System.out.println(threadName + " attempting to lock Lock 1");
		lock1.lock();
		System.out.println(threadName + " locked lock 1");
		
		//do the work - now that both locks have been acquired(locked);
		
		//unlock
		System.out.println(threadName + " unlocking Lock 2");
		lock2.unlock();
		System.out.println(threadName + " unlocking lock 1");
		lock1.unlock();
		
	}
}
