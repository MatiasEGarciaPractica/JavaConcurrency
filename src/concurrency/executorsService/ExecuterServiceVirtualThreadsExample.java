package concurrency.executorsService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecuterServiceVirtualThreadsExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
	
		executor.submit(() -> {
			System.out.println("This is a runnable that is executed by a virtual thread");
		});
		
		Callable<String> callable = new Callable<>() {
			@Override
			public String call() throws Exception {
				System.out.println("Callable executed by virtual thread");
				return "Result from Callable";
			}
		};
		
		Future<String> futureResult = executor.submit(callable);
		
		try{
			System.out.println(futureResult.get());
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}catch(ExecutionException e) {
			throw new RuntimeException(e);
		}
	
		executor.shutdown();
		try {
			executor.awaitTermination(10 , TimeUnit.SECONDS);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
	}
}
