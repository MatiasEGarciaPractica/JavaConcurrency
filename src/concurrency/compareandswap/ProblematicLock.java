package concurrency.compareandswap;

/**
 * 
 * @author matia
 * lock without compare and swap
 * origin -> https://www.youtube.com/watch?v=ufWVK7CHOAk&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=21
 */
public class ProblematicLock{

	private volatile boolean locked = false;
	
	public void unlock() {
		this.locked = false;
	}
	
	public void lock() {
		while(this.locked) {
			//busy wait - until this.locked == false;
		}
		this.locked = true;
	}
	
}
