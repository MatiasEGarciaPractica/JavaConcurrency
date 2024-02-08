package concurrency.executorsService;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceExample {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(newRunnable("Task 1"));
		executorService.execute(newRunnable("Task 2"));
		executorService.execute(newRunnable("Task 3"));
		
		executorService.shutdown();
	}
	
	private static Runnable newRunnable(String msg) {
		return new Runnable() {
			@Override
			public void run() {
				String completeMsg = Thread.currentThread().getName() + "; " + msg;
				System.out.println(completeMsg);
			}
		};
	}
	 
}
 