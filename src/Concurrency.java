import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private final BlockingQueue queue;
	Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
			System.out.println("Producer interrupted");
		}
	}

	Object produce() {
		return new Object();
	}
}

class ConsumerTest implements Runnable {	
	public final BlockingQueue queue;
	public ConsumerTest(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				consume(queue.take());
			}
		} catch (InterruptedException ex) {
			System.out.println("Consumer interrupted");
		}
	}

	void consume(Object x) {

	}
}

public class Concurrency {
	public static void main(String[] args) {
		BlockingQueue q = new ArrayBlockingQueue(10);
		Producer p = new Producer(q);
		ConsumerTest c1 = new ConsumerTest(q);
		ConsumerTest c2 = new ConsumerTest(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}