package concurrency.executorsService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author matia
 *	ExecutorService execute method.
 */
public class ExecutorServiceExample2 {
	
	public static void main(String[] args) {
		//ExecutorService executorService = Executors.newSingleThreadExcecutor();
		
		//is the same than use newSingleThreadExcecutor.
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		executorService.execute(newRunnable("Task 1.1"));
		executorService.execute(newRunnable("Task 1.2"));
		executorService.execute(newRunnable("Task 1.3"));
		
		executorService.shutdown();
	}

	private static Runnable newRunnable(String msg) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ": " + msg);
			}
		};
	}
	
}

