package concurrency.executorsService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author matia
 *ExecutorService invokeAny method with Callable
 */
public class ExecutorServiceExample5 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
	
		List<Callable<String>> callables = new ArrayList<>();
		callables.add(newCallable("Task 1.1"));
		callables.add(newCallable("Task 1.2"));
		callables.add(newCallable("Task 1.3"));
		
		try {
			String result = executorService.invokeAny(callables);//get the result from the first that complete the task succesfuly.
			System.out.println(result);
		}catch(InterruptedException e) {
			
		}catch(ExecutionException e) {
			
		}
	
	}
	
	private static Callable<String> newCallable(String msg) {
		return new Callable<String>() {
			@Override
			public String call() throws Exception{
				String completeMsg = Thread.currentThread().getName() + ": " + msg;
				return completeMsg;
			}
		};
	}
}
