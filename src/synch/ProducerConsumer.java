package synch;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		ProductQueue productQueue = new ProductQueue(10);
		int nProducer = 5;
		int nConsumer = 7;
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < nProducer; i++)
			exec.execute(new Producer(productQueue));
		Thread.sleep(2000);
		for (int i = 0; i < nConsumer; i++)
			exec.execute(new Consumer(productQueue));
		Thread.sleep(2000);
		exec.shutdownNow();
	}
}

class ProductQueue extends ArrayBlockingQueue<Product> {
	public ProductQueue(int capacity) {
		super(capacity);
	}
	public synchronized void print() {
		Iterator<Product> ite = this.iterator();
		while (ite.hasNext()) {
			System.out.print(ite.next()+",");
		}
		System.out.println();
	}
}	

class Product {
	private int id;
	public Product (int id) {
		this.id = id;
	}
	public String toString() {
		return "Product" + id;
	}
}

class Producer implements Runnable {
	private ProductQueue productQueue;
	private static AtomicInteger count = new AtomicInteger(0);
	//private Random rand = new Random(109);
	public Producer(ProductQueue productQueue) {
		this.productQueue = productQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Product p = new Product((int) count.incrementAndGet());
				
				productQueue.put(p);
				synchronized (this) {
					System.out.print("after Produce,");
					productQueue.print();										
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Producer interrupted");
		}	
		System.out.println("Producer off");
	}	
}

class Consumer implements Runnable {
	private ProductQueue productQueue;
	public Consumer(ProductQueue productQueue) {
		this.productQueue = productQueue;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				productQueue.take();				
				synchronized (this) {
					System.out.print("after Consume,");
					productQueue.print();										
				}
				Thread.sleep(1000);
				//System.out.println("--------consume:" + p);
			}
		} catch (InterruptedException e) {
			System.out.println("Consumer interrupted");
		}
		System.out.println("Consumer off");		
	}
}
