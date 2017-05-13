package CreatorAndConsumerBlock;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 盘子，表示共享的资源
 *
 * @author Martin
 */
public class Plate {
    /**
     * 将arraylist换成阻塞队列，可见使用了阻塞队列后，代码中再也没有了lock、condition等了，完全不需要手动控制线程的等待还是唤醒了
     */
    private ArrayBlockingQueue<Object> eggs = new ArrayBlockingQueue<Object>(99999);

    /**
     * 获取蛋
     *
     * @return
     */
    public Object getEgg() {
        try {
            Object egg = eggs.take();
            System.out.println("消费者取蛋,当前剩余：" + eggs.size());
            return egg;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 加入蛋
     *
     * @return
     */
    public void addEgg(Object egg) {
        try {
            eggs.put(new Object());
            System.out.println("生产者生蛋,当前剩余：" + eggs.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
