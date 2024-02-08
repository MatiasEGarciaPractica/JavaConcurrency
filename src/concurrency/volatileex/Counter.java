package concurrency.volatileex;

/**
 * 
 * @author matia
 *
 *	Using volatile variable is not always enough.
 */
public class Counter {

	private volatile int count = 0;
	
	public boolean inc() {
		if(this.count == 10) {//if three threads try to pass at the same time for this, at the same time, 
			return false;    //they all will pass if they have count == 9, so, this all block needs to be synchronized
		}
		this.count++;
		return false;
	}
	
}
