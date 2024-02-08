package concurrency.executorsService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;

/**
 * 
 * @author matia
 * how to shutdown ExecutorService
 */
public class ExecutorServiceExample7 {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		executorService.shutdown();//1
		
		List<Runnable> runnables = executorService.shutdownNow();//2
		
		try {
			executorService.awaitTermination(3000L, TimeUnit.MILLISECONDS);//3
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
