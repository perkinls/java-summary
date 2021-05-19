package lipan.top.notes.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 可重入锁
 * @createTime 2020年12月18日 17:36:00
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            //支持重入锁
            lock.lock();
            try {
                i++;
            } finally {
                //执行两次解锁
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //输出结果：20000000
        System.out.println(i);
    }
}
