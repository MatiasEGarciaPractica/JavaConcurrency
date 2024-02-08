package concurrency.fairness;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author matia
 *	Fair lock to avoid starvation and implement fairness.
 */
public class FairLock {

	private boolean isLocked = false;
	private Thread lockingThread = null;
	private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

	public void lock() throws InterruptedException {
		QueueObject queueObject = new QueueObject();
		boolean isLockedForThisThread = true;
		synchronized(this) { //with this we are talking about this FairLock object
			waitingThreads.add(queueObject); //we add each thread's queueObject
		}
		
		while(isLockedForThisThread) {
			synchronized(this) {
				isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
				
				if(!isLockedForThisThread) {
					isLocked = true; //we set that the lock is locked with the current thread
					waitingThreads.remove(queueObject);//quit the the top thread that is the currently thread
					lockingThread = Thread.currentThread(); //we get the current thread which we just remove it from the waiting threads
					return;
				}
			}
			
			//now, we work with another thread that is not the current thread.
			try {
				queueObject.doWait();
			}catch(InterruptedException e) {
				synchronized (this) {
					waitingThreads.remove(queueObject);
					throw e;
				}
			}	
		}
	}
	
	
	public synchronized void unlock() {
		if(this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		
		isLocked = false;
		lockingThread = null; //we quit the current thread, current thread has not anymore the lock for itself
		if(waitingThreads.size() > 0 ){  
			waitingThreads.get(0).doNotify(); // activate the next thread in the list. 
		}
		
	}
	

}
