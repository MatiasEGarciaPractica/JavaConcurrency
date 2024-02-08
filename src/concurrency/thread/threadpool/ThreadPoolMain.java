package concurrency.thread.threadpool;

public class ThreadPoolMain {

	public static void main(String[] args) throws Exception {
		//3 threads and 10 max tasks
		ThreadPool threadPool = new ThreadPool(3,10);
		
		for(int i=0; i<10 ; i++) {
			int taskNo = i;
			threadPool.execute(() -> {
				String message = Thread.currentThread().getName() + ": Task " + taskNo;
				System.out.println(message);
			});
		};
		
		threadPool.waitUntilAllTasksFinished();//main thread wait until all the threads finish.
		threadPool.stop();
	}
}
