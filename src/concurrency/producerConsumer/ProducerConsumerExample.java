package concurrency.producerConsumer;

import java.util.concurrent.BlockingQueue;

import concurrency.blockingQueue.Consumer;
import concurrency.blockingQueue.Producer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 
 * @author matia
 *
 * origin-> https://www.youtube.com/watch?v=tEwNXnAmc9c&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=20
 * 
 * producerConsumer with only a blockingQueue
 * 
 */
public class ProducerConsumerExample {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
	
		Producer producer = new Producer(blockingQueue);
		Consumer consumer1 = new Consumer(blockingQueue);
		Consumer consumer2 = new Consumer(blockingQueue);
	
		Thread producerThread = new Thread(producer);
		Thread consumerThread1 = new Thread(consumer1);
		Thread consumerThread2 = new Thread(consumer2);
		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
	
	}
	
}
