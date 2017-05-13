package CreatorAndConsumerBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {
    public static void main(String[] args)
    {
        //共享资源
        Plate plate = new Plate();
        ExecutorService pool = Executors.newFixedThreadPool(100);

		int nProducer = 20;
		int nConsumer = 10;
		for (int i = 0; i < nProducer; i++) {
			pool.execute(new Creator(plate));
			
		}
		for (int i = 0; i < nConsumer; i++) {
			pool.execute(new Consumer(plate));
		}

        pool.shutdown();
    }
}