package lipan.top.notes.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * @createTime 2020年12月21日 11:44:00
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);

        // 线程1
        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(1000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 线程2
        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
