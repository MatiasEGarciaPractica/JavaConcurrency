package concurrency.falsesharing;

public class FalseSharingExample {

	public static void main(String[] args) {
		Counter1 counter1 = new Counter1();
		//Counter1 counter2 = counter1; //more slower
		Counter1 counter2 = new Counter1(); //more faster		
		
		long iterations = 1_000_000_000;
		
		Thread thread1 = new Thread(() -> {
			long startTime = System.currentTimeMillis();
			for(long i = 0 ; i < iterations; i++) {
				counter1.count1++;
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("total time:  " + (endTime - startTime));
		});
		
		Thread thread2 = new Thread(() -> {
			long startTime = System.currentTimeMillis();
			for(long i = 0 ; i < iterations; i++) {
				counter2.count1++;
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("total time:  " + (endTime - startTime));
		});
		
		thread1.start();
		thread2.start();
	}
}
