package CreatorAndConsumerBlock;

/**
 * 生产者
 *
 * @author Martin
 */
public class Creator implements Runnable {
    /**
     * 线程资源
     */
    private Plate plate;

    public Creator(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        Object egg = new Object();
        plate.addEgg(egg);
    }
}