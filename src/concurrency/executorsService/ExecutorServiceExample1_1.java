package concurrency.executorsService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 
 * @author matia
 *TYPES OF threadPoolExecutor and its constructors.
 */
public class ExecutorServiceExample1_1 {
	
	public static void main(String[] args) {
		int corePoolSize = 10;
		int maxPoolSize = 20;
		long keepAliveTime = 3000;//milisseconds
		
		//ThreadPoolExecutor will try to execute a task as fast as it can
		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
				corePoolSize, //10 base threads numbers
				maxPoolSize, //if there are too many tasks, the is allowed to create at least 20 threads max
				keepAliveTime, //if there was some extra thread creationg(from base 10 to 20) , then this is the time to keep them alive. 
				TimeUnit.MILLISECONDS, //to set what measure of time we use
				new ArrayBlockingQueue<>(128) //how we store tasks.
				);
	
		threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
	
		//ScheduledThreadPoolExecutor can execute a task at a specific time 
		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);
		
		scheduledExecutorService = Executors.newScheduledThreadPool(10);
	}
}
