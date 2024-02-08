package concurrency.fairness;

/**
 * 
 * @author matia
 *FairLock creates a new instance of QueueObject and enqueue it for each thread calling lock(). 
 *With this we are sure that we only notify the correct thread.
 *This is a semaphore. 
 */
public class QueueObject {
	
	private boolean isNotified = false;
	
	public synchronized void doWait() throws InterruptedException{
		while(!isNotified) {
			this.wait();
		}
		this.isNotified = false;
	}
	
	public synchronized void doNotify() {
		this.isNotified = true;
		this.notify();
	}
	
	public boolean equals(Object o) {
		return this == o;
	}
	
	
}
