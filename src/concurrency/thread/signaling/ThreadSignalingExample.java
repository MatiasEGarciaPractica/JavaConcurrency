package concurrency.thread.signaling;

public class ThreadSignalingExample {

	public static void main(String[] args) {
		SignalCarrier signalCarrier = new SignalCarrier();
	
		Thread waiter = new Thread(() -> {
			try {
				signalCarrier.doWait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread notifier = new Thread(() -> {
			try {
				signalCarrier.doNotify();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		waiter.start();
		notifier.start();
	}
	
}
