package lipan.top.notes.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 可重入锁演示
 * @createTime 2020年12月21日 12:51:00
 */
public class ReentrantLockDemoV1 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();  // block until condition holds
        try {
            System.out.println("第一次获取锁");
            System.out.println("当前线程获取锁的次数" + lock.getHoldCount());
            lock.lock(); // 可重入的概念 // 如果时不可重入，这个代码应该阻塞
            System.out.println("第二次获取锁了");
            System.out.println("当前线程获取锁的次数" + lock.getHoldCount());
        } finally {
            lock.unlock();
            lock.unlock();
        }
        System.out.println("当前线程获取锁的次数" + lock.getHoldCount());

        // 如果不释放，此时其他线程是拿不到锁的
        new Thread(() -> {
            System.out.println(Thread.currentThread() + " 期望抢到锁");
            lock.lock();
            System.out.println(Thread.currentThread() + " 线程拿到了锁");
        }).start();


    }
}
