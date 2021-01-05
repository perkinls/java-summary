package lipan.top.notes.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 可重入锁, 响应式中断
 * @createTime 2020年12月21日 12:52:00
 */
public class ReentrantLockDemoV3 {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemoV3 demo1 = new ReentrantLockDemoV3();
        Runnable runnable = () -> {
            try {
                demo1.test(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread0.start();
        Thread.sleep(500); // 等待0.5秒，让thread1先执行

        thread1.start();
        Thread.sleep(2000); // 两秒后，中断thread2

        thread1.interrupt(); // 应该被中断
    }

    public void test(Thread thread) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "， 想获取锁");
        lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName() + "~~运行了~~");
            Thread.sleep(10000); // 抢到锁，10秒不释放
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}
