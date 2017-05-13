import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Producer implements Runnable {
	private String name;

	private BlockingDeque<Integer> deque;

	public Producer(String name, BlockingDeque<Integer> deque) {
		this.name = name;
		this.deque = deque;
	}

	public synchronized void run() {

		for (int i = 0; i < 10; i++) {
			try {
				deque.putFirst(i);
				System.out.println(name + " puts " + i);
				Thread.sleep(300);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Consumer implements Runnable {
	private String name;

	private BlockingDeque<Integer> deque;

	public Consumer(String name, BlockingDeque<Integer> deque) {
		this.name = name;
		this.deque = deque;
	}

	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			try {
				int j = deque.takeLast();
				System.out.println(name + " takes " + j);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BlockingDequeTester {
	public static void main(String[] args) {
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>(5);
		Runnable producer0 = new Producer("Producer0", deque);
		Runnable producer1 = new Producer("Producer1", deque);
		Runnable consumer = new Consumer("Consumer", deque);
		new Thread(producer0).start();
		new Thread(producer1).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(consumer).start();
	}
}