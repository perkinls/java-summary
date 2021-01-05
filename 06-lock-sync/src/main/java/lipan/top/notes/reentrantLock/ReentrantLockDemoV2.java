package lipan.top.notes.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description ReentrantLock可重入锁终端机示例
 * @createTime 2020年12月21日 12:48:00
 */
public class ReentrantLockDemoV2 {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemoV2 demo1 = new ReentrantLockDemoV2();
        Runnable runnable = () -> {
            try {
                demo1.test(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        Thread.sleep(500); // 等待0.5秒，让thread1先执行

        thread2.start();
        Thread.sleep(2000); // 两秒后，中断thread2

        thread2.interrupt();
    }

    public void test(Thread thread) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "， 想获取锁");
        lock.lock();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        // lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "得到了锁");
            Thread.sleep(10000); // 抢到锁，10秒不释放
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}
