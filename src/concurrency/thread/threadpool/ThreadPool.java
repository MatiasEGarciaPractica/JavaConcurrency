package concurrency.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	
	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThreadRunnable> runnables = new ArrayList<>();
	private boolean isStopped = false;
	
	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		taskQueue = new ArrayBlockingQueue<Runnable>(maxNoOfTasks);
	
		for(int i = 0; i < noOfThreads; i++) {
			PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue); //create the thread and give it access to the task queue
			runnables.add(poolThreadRunnable); //we add the thread implementation on the list of runnables.
		}
	
		for(PoolThreadRunnable runnable : runnables) {
			new Thread(runnable).start();
		}
	}
	
	public synchronized void execute(Runnable task) throws Exception{
		if(this.isStopped) throw new IllegalStateException("threadPool is stopped");
		this.taskQueue.offer(task);
	}
	
	public synchronized void stop() {
		this.isStopped = true;
		for(PoolThreadRunnable runnable : runnables) {
			runnable.doStop();
		}
	}
	
	public synchronized void waitUntilAllTasksFinished() {
		while(this.taskQueue.size() > 0) {
			try {
				Thread.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
