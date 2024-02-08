package concurrency.locks.deadLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable2TimeOut implements Runnable {

	Lock lock1 = null;
	Lock lock2 = null;
	
	public Runnable2TimeOut(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		
		//we try to provoce a situation where is a deadBlock
		while(true) {
			int failureCount = 0;
			while(!tryLockBothLocks()) {//if fails trying to lock both locks
				failureCount++;
				System.err.println(threadName + " failed to lock both locks. " + 
				"Waiting a bit vefore retying [" + failureCount + " tries]");
				sleep(100L + ((long) Math.random()));
			}
			if(failureCount>0) {
				System.out.println(threadName + "succeded in locking both locks - after " + failureCount + "failures");
			}
			
			//do the work - now that both locks have been acquired(lockded by this thread)
			
			//unlock
			lock2.unlock();
			lock1.unlock();
		}
		
	}
	
	private void sleep(long timeMillis) {
		try {
			Thread.sleep(timeMillis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean tryLockBothLocks() {
		String threadName = Thread.currentThread().getName();
		
		try {
			boolean lock2Succeeded = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
			if(!lock2Succeeded) {
				return false;
			}
		}catch(InterruptedException e) {
			System.out.println(threadName + " interrupted trying to lock Lock 2");
			return false;
		}
		
		try {
			boolean lock1Succeeded = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
			if(!lock1Succeeded) {
				lock2.unlock();
				return false;
			}
		}catch(InterruptedException e) {
			System.out.println(threadName + " interrupted trying to lock Lock 1");
			lock2.unlock();
			return false;
		}
		return true;
	}
}
