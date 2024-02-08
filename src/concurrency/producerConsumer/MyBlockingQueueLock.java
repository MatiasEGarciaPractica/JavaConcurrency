package concurrency.producerConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * 
 * @author matia
 *	Implementing my own BlockingQueue whithout the BlockingQueue interface, to protect the method
 *	from simultaneous access I will use lock.
 *
 * @param <E>
 */
public class MyBlockingQueueLock<E> {

	private Queue<E> queue;
	private int max = 16;
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	
	public MyBlockingQueueLock(int size) {
		queue = new ArrayDeque<>();//it would be better LinkedList
		this.max = size;
	}
	
	public void put(E e) throws InterruptedException{
		lock.lock();
		try {
			//if the queue is full we don't want to add more
			//elements to the queue, so we stop the thread
			while(queue.size() == max) {
				notFull.await();
			}
			queue.add(e);
			//now we notify all the threads that are waiting to
			//take an element and to continue(line 49)
			notEmpty.notifyAll();
		}finally {
			lock.unlock();
		}
		
		
	}
	
	public E take() throws InterruptedException{
		lock.lock();
		try {
			//if there are not more elements we stop the thread to remove more
			while(queue.size() == 0) {
				notEmpty.wait();
			}
			E item = queue.remove();
			//we signal all the threads that are waiting to 
			//add more elements to the queue. (line 36)
			notFull.signalAll();
			return item;
		}finally {
			lock.unlock();
		}
	}
	
	/**
	 * WHY using while instead of if in lines 35 and 53 ?
	 * because in the case of If. if there is more than onw thread waiting to adquire the 
	 * lock, when is signaled thread 1 will add or remove, because if not repeat the question, and then
	 * thread 2 will also add or remove becuase if not repeat the question, that is avoided will while loop, becuase 
	 * will ask continuously until the requirement is fulfilled,
	 * 
	 * Bibliography:
	 * https://www.youtube.com/watch?v=UOr9kMCCa5g
	 */
}
