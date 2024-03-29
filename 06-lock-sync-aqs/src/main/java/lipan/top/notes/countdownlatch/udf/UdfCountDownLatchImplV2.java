package lipan.top.notes.countdownlatch.udf;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 优化--C++,运行时，只能推论。sync对象监视器的原理 owner
 * @createTime 2020年12月21日 11:24:00
 */
public class UdfCountDownLatchImplV2 {
    AtomicInteger count = null; // 共享资源 -- 可以被一定数量线程
    // 需要锁池
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public UdfCountDownLatchImplV2(int count) {
        this.count = new AtomicInteger(count);
    }

    /**
     * 可以看作主线程等待
     */
    public void await() { // 等待计数器归零
        waiters.add(Thread.currentThread());
        while (this.count.get() != 0) {
            LockSupport.park(); // 挂起，等待被唤醒...
        }
        waiters.remove(Thread.currentThread());
    }

    /**
     * 可以看作子线程对count-1操作
     */
    public void countDown() { // 计数器-1
        if (count.decrementAndGet() == 0) {
            // 释放锁之后，要唤醒线程
            for (Thread waiter : waiters) {
                LockSupport.unpark(waiter);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        UdfCountDownLatchImplV2 cdl = new UdfCountDownLatchImplV2(2000); //2000个参与的线程
        for (int i = 0; i < 2000; i++) {
            int finalI = i;
            // 场景调整：压力测试，直接怼2000线程~~ 2000线程，分成4波去发起，500一批，
            new Thread(() -> {
                try {
                    cdl.countDown(); // -1
                    System.out.println("线程" + finalI + "就绪");
                    cdl.await();// 等待计数器归0,如果计数器不归0 则等待

                    // TODO 并发执行这段代码
                    System.out.println(Thread.currentThread() + "运行了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
