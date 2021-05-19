package lipan.top.notes.aqs.udfimpl;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * 基于监视器原理，自定义实现Lock锁
 */
public class UdfLockSafeImpl {
    /**
     * 锁的拥有者
     */
    AtomicReference<Thread> owner = new AtomicReference<>();
    /**
     * 需要锁池
     */
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public void lock() {
        //  没拿到锁，等待
        waiters.add(Thread.currentThread());
        // CAS -- 此处直接CAS，是一种非公平的实现
        while (!owner.compareAndSet(null, Thread.currentThread())) {
            LockSupport.park(); // 挂起，等待被唤醒...
        }
        waiters.remove(Thread.currentThread());
    }

    public void unlock() {
        if (owner.compareAndSet(Thread.currentThread(), null)) {
            // 释放锁之后，要唤醒一个线程
            Thread next = waiters.peek();
            LockSupport.unpark(next);  // park/unpark没有执行先后顺序限定
        }
    }
}
