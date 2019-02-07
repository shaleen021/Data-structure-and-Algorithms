package practice.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private final int nThreads;
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue queue;
	private Boolean shutdown;
	private Boolean shutdownNow;

	public ThreadPool(int n) {
		this.nThreads = n;
		this.queue = new LinkedBlockingQueue<>();
		this.threads = new PoolWorker[n];
		this.shutdown = false;
		this.shutdownNow = false;

		for (int i = 0; i < n; i++) {
			this.threads[i] = new PoolWorker();
			this.threads[i].start();
		}
	}

	public void shutdown() {
		shutdown = true;
	}

	public List<Runnable> shutdownNow() {
		this.shutdownNow = true;
		List<Runnable> taskList = new ArrayList<>();
		synchronized (queue) {
			while (!queue.isEmpty()) {
				taskList.add((Runnable) queue.poll());
			}
		}
		return taskList;
	}

	public void execute(Runnable task) {
		if (!shutdown && !shutdownNow) {
			int t = 0;
			while (t < 10000000) {
				t++;
			}
			synchronized (queue) {
				queue.add(task);
				queue.notify();
			}
		}
	}

	private class PoolWorker extends Thread {
		public void run() {
			Runnable task;
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = (Runnable) queue.poll();
					task.run();
					if (queue.isEmpty() && (shutdown)) {
						break;
					}
					if (shutdownNow) {
						break;
					}
				}
			}
		}
	}
	
	public static void main(String args[]){
		int i =010;
		
		int j =07;
		System.out.println(i);
	}
}
