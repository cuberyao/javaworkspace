package CreatorAndConsumerBlock;


public class Consumer implements Runnable {
    /**
     * 线程资源
     */
    private Plate plate;

    public Consumer(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        plate.getEgg();
    }
}