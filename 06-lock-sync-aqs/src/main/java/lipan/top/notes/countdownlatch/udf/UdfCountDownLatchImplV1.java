package lipan.top.notes.countdownlatch.udf;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 自定义CountDownLatch自己实现
 * @createTime 2020年12月21日 11:19:00
 */
public class UdfCountDownLatchImplV1 {

    AtomicInteger count;
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public UdfCountDownLatchImplV1(int num) {
        this.count = new AtomicInteger(num);
    }

    /**
     * 可以看作主线程等待
     */
    public void await() {
        // 进入等待列表
        waiters.add(Thread.currentThread());
        while (this.count.get() != 0) {
            // 默认占有许可证，一直在这里等待.
            LockSupport.park();
        }
        waiters.remove(Thread.currentThread());
    }

    /**
     * 可以看作子线程对count-1操作
     */
    public void countDown() {
        // count-1 = 0
        if (this.count.decrementAndGet() == 0) {
            Thread waiter = waiters.peek(); // TODO peek方法和遍历区别？
            LockSupport.unpark(waiter); // 唤醒线程继续 抢锁
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // 一个请求，后台需要调用多个接口 查询数据
        UdfCountDownLatchImplV1 cdLdemo = new UdfCountDownLatchImplV1(10); // 创建，计数数值
        for (int i = 0; i < 10; i++) { // 启动九个线程，最后一个两秒后启动
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是" + Thread.currentThread() + ".我执行接口-" + finalI + "调用了");
                cdLdemo.countDown(); // 参与计数
                // 不影响后续操作
            }).start();
        }

        cdLdemo.await(); // 等待计数器为0
        System.out.println("全部执行完毕.我来召唤神龙");
    }
}
