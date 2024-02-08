package concurrency.locks.deadLock;

import java.util.concurrent.locks.Lock;

/**
 * 
 * @author matia
 *A dead lock can occur with Synchronized blocks too.
 *
 *This class does the same than RunnableSync1 but in reverse.
 */
public class RunnableSync2 implements Runnable{

	private Lock lock1;
	private Lock lock2;

	public RunnableSync2(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();	
		
		System.out.println(threadName + " attempting to lock Lock 2");
		synchronized(lock2) {
			System.out.println(threadName + " locked Lock 2");
			
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				//ignore
			}
			
			System.out.println(threadName + " attempting to lock Lock 1");
			synchronized(lock1) {
				System.out.println(threadName + " locked Lock 1");
				//do the work - now that both locks have been acquired(Locked).
			}
			System.out.println(threadName + " unlocking Lock 1");
		}
		System.out.println(threadName + " unlocking Lock 2");
	}
	
}
