package concurrency.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 
 * @author matia
 *	Implementing procuder consumer pattern with a blocking queue
 * Bibliography
 * 	https://www.youtube.com/watch?v=UOr9kMCCa5g
 *
 */
public class BlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);
	
		//Producer 
		final Runnable producer = () -> {
			while(true) {
				try {
					queue.put(createItem());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(producer).start();
		
		//Consumer
		final Runnable consumer = () -> {
			while(true) {
				Item i = null;
				try {
					 i = queue.take();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				process(i);
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();
	}
	
	
	
	public static Item createItem() {
		Item item = new Item("Atun");
		return item;
	}
	
	public static void process(Item item) {
		if(item != null) {
			System.out.println("Processes product : "+ item.getName());			
		}
	}
	
	
	
	public static class Item{
		
		private String name;
		
		public Item(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
}
