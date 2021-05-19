package lipan.top.notes.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务准准备完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * @createTime 2020年12月21日 11:44:00
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) { // 启动九个线程，最后一个两秒后启动
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是" + Thread.currentThread() + ".准备中-");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown(); // 参与计数
                System.out.println("我是" + Thread.currentThread() + ".我执行接口-" + finalI + "调用了");
                // 不影响后续操作
            }).start();
        }
        latch.await(); // 主线程等待计数器为0

        //Thread.sleep(1000); // 停顿为了查看日志错乱
        System.out.println("全部执行完毕.我来召唤神龙");
    }
}
