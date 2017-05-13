import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestProducerConsumer {
    public static final int MAX_SIZE = 10;
    private final BlockingQueue<Integer> tasks = new ArrayBlockingQueue<Integer>(MAX_SIZE);
    public final ExecutorService executor = Executors.newCachedThreadPool();
    public final AtomicInteger count = new AtomicInteger();

    public static final int POISON_VALUE = -1;

    public void addToBuffer(Integer i) {
        try {
            tasks.put(i);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public Integer removeFromBuffer() {
        try {
            return tasks.take();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String... args) {
        TestProducerConsumer pd = new TestProducerConsumer();
        pd.new Producer();
        pd.new Producer();
        pd.new Producer();

        pd.new Consumer();
        pd.new Consumer();
        pd.new Consumer();
        pd.new Consumer();
        pd.new Consumer();
    }

    class Producer implements Runnable {
        public Producer() {
            executor.execute(this);
        }

        public void run() {
            while (count.get() >= 0) {
                addToBuffer(count.getAndIncrement());
            }
            addToBuffer(TestProducerConsumer.POISON_VALUE);
        }
    }

    class Consumer implements Runnable {
        public Consumer() {
            executor.execute(this);
        }

        public void run() {
            Integer num;
            while ((num = removeFromBuffer()) != TestProducerConsumer.POISON_VALUE) {
                System.out.println("popped " + num);
            }
        }
    }
}