package concurrency.thread.signaling;

public class ThreadSignalingExampleBasic {

	public static void main(String[] args) {
		Object signalObject = new Object();
		
		Thread waitingThread = new Thread(() -> {
			synchronized(signalObject) {
				try {
					signalObject.wait();//you can call this method if is in a synchronized block
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread notifyingThread = new Thread(() ->{
			synchronized(signalObject) {
				signalObject.notify();//you can call this method if is in a synchronized block
			}
		});
		
		waitingThread.start();
		notifyingThread.start();
	}
}
