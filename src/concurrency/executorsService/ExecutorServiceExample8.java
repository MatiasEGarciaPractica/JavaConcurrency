package concurrency.executorsService;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author matia
 *	Cancel task via Future.
 */
public class ExecutorServiceExample8 {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Future future = executorService.submit(newCallable("Task 1.1"));
		
		System.out.println(future.isDone());
		
		boolean mayInterrupt = true;
		boolean wasCancelled = future.cancel(mayInterrupt);
		System.out.println(wasCancelled);
		
		try {
			String result = (String) future.get();//should throw a cancellationException, because was cancel(line 25)
		}catch(InterruptedException e) {
			
		}catch(ExecutionException e) {
			
		}catch(CancellationException e) {
			String msg = "Cannot call Future.get() since task was cancelled";
			System.out.println(msg);
		}
		System.out.println(future.isDone());
		System.out.println(future.isCancelled());
		executorService.shutdown();
		
	}
	
	
	private static Callable newCallable(String msg) {
		return new Callable() {
			@Override
			public Object call() throws Exception{
				String completeMsg = Thread.currentThread().getName() + ": " + msg;
				return completeMsg;
			}
		};
	}
}
