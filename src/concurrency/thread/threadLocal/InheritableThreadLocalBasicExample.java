package concurrency.thread.threadLocal;

/**
 * 
 * @author matia
 * A InheritableThreadLocal can share its values with child threads created by a parent thread.
 */
public class InheritableThreadLocalBasicExample {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
		
		Thread thread1 = new Thread(() -> {
			System.out.println("=== Thread 1 ===");
			threadLocal.set("Thread 1 - ThreadLocal");
			inheritableThreadLocal.set("Thread 1 - InheritableThreadlLocal");
		
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		
			Thread childThread = new Thread(() -> {
				System.out.println("==== ChildThread ====");
				System.out.println(threadLocal.get());
				System.out.println(inheritableThreadLocal.get());//can get the value because is shared.
			});
			childThread.start();
		});
		
		thread1.start();
		
		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("==== Thread 2 ====");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());//is not child of the first thread so, it doesn't have access to the value
		});
		
		thread2.start();
	}
}
