package concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;


public class AdditionalMethods {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		
		int size = blockingQueue.size();
		
		int capacity = blockingQueue.remainingCapacity();
		
		boolean containsElement = blockingQueue.contains("1");
	}
}
