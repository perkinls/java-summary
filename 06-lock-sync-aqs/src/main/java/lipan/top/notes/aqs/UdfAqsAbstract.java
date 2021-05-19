package lipan.top.notes.aqs;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * 对 @UdfAqsImpl 进一步升华,使用模板方法设计模式和java底层AQS实现思想基本一致。
 * 基于CountDownLatch、Semaphore、CyclicBarrier的自定义实现,对AQS(抽象队列同步器)的一个自定义抽象。
 * <p>
 * 不完整版本
 */
public abstract class UdfAqsAbstract {
    /**
     * 资源数量 -- 共享资源状态
     */
    AtomicInteger state = null;

    /**
     * 锁的拥有者 (独享锁 -- 资源只能被一个线程占有)
     */
    AtomicReference<Thread> owner = new AtomicReference<>();

    /**
     * 需要锁池
     */
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public void acquire() { // 获取独占资源
        // 进入等待列表
        waiters.add(Thread.currentThread());
        // TODO 获取资源抽象实现
        while (tryAcquire()) { // CDL,Lock...区别:真正获取资源的步骤是不同
            // 没有获取到资源的后续流程都是一样的
            LockSupport.park(); // 挂起线程
        }
        waiters.remove(Thread.currentThread());
    }

    public void release() {
        if (tryRelease()) {
            // 释放锁之后，要唤醒其他等待的线程
            for (Thread waiter : waiters) {
                LockSupport.unpark(waiter);
            }
        }
    }

    /**
     * 释放资源
     */
    protected abstract boolean tryRelease();

    /**
     * 这个方法的实现,应该交给具体的使用者
     */
    public abstract boolean tryAcquire();

    public void acquireShare() { // 获取共享资源
        // 进入等待列表
        waiters.add(Thread.currentThread());
        // TODO 获取资源
        waiters.remove(Thread.currentThread());
    }
}
