package concurrency.thread.threadpool;

import java.util.concurrent.BlockingQueue;

//provide the functionality that is needed by the pool threads on order to take tasks out of the queue.
//execute them and then go back and take the next task, until to stop.
public class PoolThreadRunnable implements Runnable {

	private Thread thread = null;
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;
	
	public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
		taskQueue = queue;
	}
	
	@Override
	public void run() {
		this.thread = Thread.currentThread();
		while(!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			}catch(Exception e) {
				//log or otherwise report exception,
				//keep pool thread alive
			}
		}
	}
	
	public synchronized void doStop() {
		isStopped = true;
		//break pool thread out of dequeue() call
		this.thread.interrupt();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}

}
