package concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExamples {

	public static void main(String[] args) {
		//lockBasics();
		//lockInterruptbly();
		//tryLock();
		
		ReentrantLock lock = new ReentrantLock();
		int holdCount = lock.getHoldCount();//how many times this thread has locks and holds the lock.
		int queueLength = lock.getQueueLength();
		boolean hasQueueThisThread = lock.hasQueuedThread(Thread.currentThread());
		boolean hasQueuedThreads = lock.hasQueuedThreads();
		boolean isFair = lock.isFair();
		boolean isLocked = lock.isLocked();
		boolean isHeldByCurrentThread = lock.isHeldByCurrentThread();
		
		//Differences between synchronized blocks and locksss
		/**
		 *  1. Synchronized blocks must be contained within a single method.
		 *  	lock.lock() and lock.unlock() can be called from different methods.
		 * 
		 * 	2. lock.lock() and lock.unclock() provides the same visibility and happens before guarantees as entering 
		 * 		and existing a synchronized block.
		 * 
		 * 	3. Synchronized blocks are always reentrant. Lock could decide not to be.
		 * 
		 * 	4.Synchronized blocks don't guarantee fairness. Locks can.
		 */
	}
	
	private static void lockBasics() {
		Lock lock = new ReentrantLock(false);
	
		Runnable runnable = () -> { lockSleepUnlock(lock, 1000);};
		
		Thread thread1 = new Thread(runnable, "Thread 1 ");
		Thread thread2 = new Thread(runnable, "Thread 2 ");
		Thread thread3 = new Thread(runnable, "Thread 3 ");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	private static void lockInterruptbly() {
		Lock lock = new ReentrantLock();
		Thread.currentThread().interrupt();
		try {
			lock.lockInterruptibly();//if the thread is interrupted will throw a InterruptedException.
			lock.unlock();
		}catch(InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}
	
	/**
	 * The tryLock() will try to lock the lock, if there is another thread holds the lock, then will not block the thread
	 * until is possible to lock the lock,rather will return false, otherwise(I mean , if can lock the lock) will return true.
	 * 
	 * it does not provide any fairness at all.
	 * If you want fairnes you'll need to provide milliseconds.
	 */
	private static void tryLock() {
		Lock lock = new ReentrantLock();
		try {
			boolean lockSuccesful = lock.tryLock();
			System.out.println("Lock succesful; " + lockSuccesful);
		}finally {
			lock.unlock();
		}
	}
	
	
	private static void lockSleepUnlock(Lock lock, long time) {
		try {
			lock.lock();
			printThreadMsg(" holds the lock. ");
			sleep(time);
		}finally {
			lock.unlock();
		}
	}
	
	private static void printThreadMsg(String text) {
		System.out.println(Thread.currentThread().getName() + text);
	}
	
	
	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
