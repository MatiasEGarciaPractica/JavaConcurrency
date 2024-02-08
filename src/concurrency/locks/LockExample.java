package concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @author matia
 *	The java lock interface present a lock which can ward a critical section so one only section can enter this critical section at
 *	the time.
 *
 */
public class LockExample {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock(true);//we add true to guarantee fairness(if not, there can be starvation)
		
		lock.lock();
		//do something;
		lock.unlock();
	}
}
