package concurrency.thread.raceConditions;

public class Counter {

	private long count = 0;
	
	//this method is not atomic, wiht this the threads don't access sequentially 
	/*public long incAndGet() {
		this.count++;
		return this.count;
	}*/
	
	//this is atomic and allow sequentially access 
	public long incAndGet() {
		synchronized(this) {
			this.count++;
			return this.count;
		}
	}
	
	public long get() {
		return this.count;
	}
}
