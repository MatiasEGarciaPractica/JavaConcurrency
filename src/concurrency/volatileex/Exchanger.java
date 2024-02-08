package concurrency.volatileex;

public class Exchanger {

	private Object object = null;
	private volatile boolean hasNewObject = false;//now this var will be read always from main memory, not from thread personal memory or cache.
	
	public void setObject(Object obj) {
		this.object= obj;
		this.hasNewObject = true;
	}
	
	public Object getObject() {
		while(!this.hasNewObject) {
			//busy wait
		}
	
		Object returnValue = this.object;
		this.hasNewObject = false;
		return returnValue;
	}
	
	
	
	
}
