package concurrency.thread.threadLocal;

import concurrency.javaMemory.MyObject;

/**
 * 
 * @author matia
 *
 *	We can create a threadLocal with initial value
 */
public class ThreadLocalInitialValueExample2 {

	public static void main(String[] args) {
		ThreadLocal<MyObject> threadLocal1 = new ThreadLocal<>() {
			@Override
			protected MyObject initialValue() {
				return new MyObject();
			}
		};
		
		ThreadLocal<MyObject> threadLocal2 = ThreadLocal.withInitial(() -> {
			return new MyObject();
		});

		Thread thread1 = new Thread(() -> {
			System.out.println("htreadLocal1: " + threadLocal1.get());
			System.out.println("threadLocal2: " + threadLocal2.get());
		});
		
		Thread thread2 = new Thread(() -> {
			System.out.println("htreadLocal1: " + threadLocal1.get());
			System.out.println("threadLocal2: " + threadLocal2.get());
		});
		
		thread1.start();
		thread2.start();
	}
}
