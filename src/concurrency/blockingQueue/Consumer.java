package concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<String> blockingQueue = null;

	public Consumer(BlockingQueue<String> b) {
		this.blockingQueue = b;
	}

	@Override
	public void run() {
		while(true) {
			try {
				String element = this.blockingQueue.take();
				System.out.println("consumed : " + element);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
