package concurrency.falsesharing;

public class Counter2 {

	public volatile long count1 = 0;
	//padding bytes
	public volatile long count2 = 0;
	
}
