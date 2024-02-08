package concurrency.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author matia
 * Implementing my own BlockingQueue without using BlockingQueue interface,
 * and using Synchronized blocks.
 */
public class MyBlockingQueueSincronizedBlocks<E> {
	
	private Queue<E> queue;
	private int max = 16;
	private Object notEmpty = new Object();
	private Object notFull = new Object();
	
	public MyBlockingQueueSincronizedBlocks(int size) {
		this.queue = new LinkedList<>();
		this.max = size;
	}
	
	public synchronized void put(E e){
		while(queue.size() == max) {
			try {
				notFull.wait();
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		queue.add(e);
		notEmpty.notifyAll();
	}
	
	public E take() {
		while(queue.size() == 0) {
			try {
				notEmpty.wait();
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		E item = queue.remove();
		notFull.notifyAll();
		return item;
	}
	
	
	
	/**
	 * WHY using while instead of if in lines 25 and 37 ?
	 * because in the case of If. if there is more than onw thread waiting to adquire the 
	 * lock, when is signaled thread 1 will add or remove, because if not repeat the question, and then
	 * thread 2 will also add or remove becuase if not repeat the question, that is avoided will while loop, becuase 
	 * will ask continuously until the requirement is fulfilled,
	 * 
	 * Bibliography:
	 * https://www.youtube.com/watch?v=UOr9kMCCa5g
	 */
	
}
