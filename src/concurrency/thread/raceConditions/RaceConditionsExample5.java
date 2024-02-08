package concurrency.thread.raceConditions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceConditionsExample5 {

	public static void main(String[] args) {
		Map<String, String> sharedMap = new ConcurrentHashMap<>();// is capable to have multiple thread access

		Thread thread1 = new Thread(getRunnable(sharedMap));
		Thread thread2 = new Thread(getRunnable(sharedMap));

		thread1.start();
		thread2.start();
	}

	private static Runnable getRunnable(Map<String, String> sharedMap) {
		return () -> {
			for (int i = 0; i < 1_000_000; i++) {
				synchronized (sharedMap) {
					if (sharedMap.containsKey("key")) {
						String val = sharedMap.remove("key");
						if (val == null) {// this is still posible if there are 2 threads runnning against the same map.
							System.out.println("Iteration: " + i + ": Value for 'key' was null");
						}
					} else {
						sharedMap.put("key", "value");
					}
				}
			}
			;
		};

	}
}