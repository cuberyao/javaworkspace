//package synch;
//
//import java.util.Random;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class ProducerConsumerQueue {
//
//	public static void main(String[] args) throws InterruptedException {
//		ProductQueue queue = new ProductQueue(10);
//		int nProducer = 3;
//		int nConsumer = 2;
//		ExecutorService exec = Executors.newCachedThreadPool();
//		for (int i = 0; i < nProducer; i++)
//			exec.execute(new Producer(queue, i));
//		Thread.sleep(1000);
//		for (int i = 0; i < nConsumer; i++)
//			exec.execute(new Consumer(queue, i));
//		Thread.sleep(5000);
//		exec.shutdownNow();
//	}
//
//}
//class Product {
//	private final int id;
//	public Product(int id) {
//		this.id = id;
//	}
//	public int getId() {
//		return id;
//	}
//	public String toString() {
//		return "Product:" + id; 
//	}
//}
//
//class ProductQueue extends ArrayBlockingQueue<Product> {
//	public ProductQueue(int capacity) {
//		super(capacity);
//	}	
//}	
//
//class Producer implements Runnable{
//	private ProductQueue productQueue;
//	private int id;
//	private static AtomicInteger count = new AtomicInteger(0);
//	private Random rand = new Random(35);
//	public Producer (ProductQueue productQueue, int id) {
//		this.productQueue = productQueue;
//		this.id = id;
//	}
//	
//	@Override
//	public synchronized void run() {
//		try {
//			while (true) {
//				Product p = new Product((int) count.incrementAndGet());
//				Thread.sleep(1000 + rand.nextInt(500));
//				productQueue.put(p);
//				//System.out.println(productQueue.size());
//				System.out.println("生产者:" + id + "生产了:" + p);
//			}
//		} catch (InterruptedException e) {
//			System.out.println("producer interrupted");
//		}
//		System.out.println("producer off");
//	}	
//}
//
//class Consumer implements Runnable {
//	private int id;
//	private ProductQueue productQueue;
//	public Consumer(ProductQueue productQueue, int id) {
//		this.productQueue = productQueue;
//		this.id = id;
//	}
//	@Override
//	public synchronized void run() {
//		try {
//			while (true) {
//				Product p = productQueue.take();
//				//System.out.println(productQueue.size());
//				System.out.println("消费者:"+ id + "消费了：" + p);
//			}
//		} catch (InterruptedException e) {
//			System.out.println("consumer interrupted");
//		}		
//		System.out.println("consumer off");
//	}	
//}