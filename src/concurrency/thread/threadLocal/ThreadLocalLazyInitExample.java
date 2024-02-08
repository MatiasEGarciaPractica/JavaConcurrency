package concurrency.thread.threadLocal;

/**
 * 
 * @author matia
 * we can set lazily the theadLocal value.
 *
 */
public class ThreadLocalLazyInitExample {
	
	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		String value = threadLocal.get();
		if(value == null) {
			threadLocal.set("Lazily set value");
			value = threadLocal.get();
		}
		
		System.out.println(value);
		
		
	}
}
