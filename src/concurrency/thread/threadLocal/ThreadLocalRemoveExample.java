package concurrency.thread.threadLocal;

/**
 * 
 * @author matia
 *
 * When a thread removes its value from the threadLocal id doesn't remove the others threads values in the same thread local.
 */
public class ThreadLocalRemoveExample {
	
	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		Thread thread1 = new Thread(() -> {
			threadLocal.set("Thread 1");
			
			String value = threadLocal.get();
			
			System.out.println(value);
			
			threadLocal.remove();
			value = threadLocal.get();
			System.out.println(value);
		});
		
		Thread thread2 = new Thread(() -> {
			threadLocal.set("Thread 2");
			
			String value = threadLocal.get();
			System.out.println(value);
			
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			value = threadLocal.get();
			System.out.println(value);
			
			threadLocal.remove();
			value = threadLocal.get();
			System.out.println(value);
		});
		
		thread1.start();
		thread2.start();
		
	}
}
