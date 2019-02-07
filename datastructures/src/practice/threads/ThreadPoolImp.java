package practice.threads;

public class ThreadPoolImp implements Runnable {

	int num;

	public ThreadPoolImp(int n) {
		num = n;
	}

	public void run() {
		System.out.println("Task " + num + " is running.");
	}

	public static void main(String args[]) {
		ThreadPool pool = new ThreadPool(7);
		for (int i = 0; i < 9; i++) {
			ThreadPoolImp task = new ThreadPoolImp(i);
			pool.execute(task);
		}
		
		pool.shutdownNow();
		
		for (int i = 10; i < 19; i++) {
			ThreadPoolImp task = new ThreadPoolImp(i);
			pool.execute(task);
		}

	}

}
