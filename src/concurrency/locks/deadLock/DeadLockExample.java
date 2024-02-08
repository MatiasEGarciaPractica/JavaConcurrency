package concurrency.locks.deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

	//deadLock
	public static void main(String[] args) {
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
	
		//with this 2 runnable we created an artificial deadBlock
		Runnable runnable1 = new Runnable1(lock1, lock2);
		Runnable runnable2 = new Runnable2(lock1, lock2);
	
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		
		thread1.start();
		thread2.start();
	}
	
	//deadLock with Sync blocks
	/*public static void main(String[] args) {
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
	
		//with this 2 runnable we created an artificial deadBlock
		RunnableSync1 runnable1 = new RunnableSync1(lock1, lock2);
		RunnableSync2 runnable2 = new RunnableSync2(lock1, lock2);
	
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		
		thread1.start();
		thread2.start();
	}
	*/
}
