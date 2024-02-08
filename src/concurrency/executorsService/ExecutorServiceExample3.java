package concurrency.executorsService;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author matia
 * 	ExecutorService submit method with Future interface.
 */
public class ExecutorServiceExample3 {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
	
		Future future = executorService.submit(newRunnable("Task 1.1"));
	
		System.out.println(future.isDone());//probably not done yet
		
		try {
			future.get(); //in this case is null the return, because run method from newRunnable is void.
		}catch(InterruptedException e) {
			
		}catch(ExecutionException e) {
			
		}
		
		System.out.println(future.isDone());
		
		executorService.shutdown();
		
	}
	
	private static Runnable newRunnable(String msg) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + msg);
			}
		};
	}
}
