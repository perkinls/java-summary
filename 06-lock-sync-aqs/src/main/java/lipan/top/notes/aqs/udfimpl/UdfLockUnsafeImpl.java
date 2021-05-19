package lipan.top.notes.aqs.udfimpl;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 基于监视器原理，自定义实现Lock锁
 * @createTime 2021年04月26日 22:05:00
 * <p>
 * 线程不安全，
 * 现有线程1、2，线程1获取到锁后线程2去获取锁失败加入等待队列，
 * 在多线程运行环境下在线程1释放锁的同时线程2还未加入等待队列，此时唤醒空气，后续导致不能被唤醒(永久挂起)。
 * </p>
 */
public class UdfLockUnsafeImpl {
    // 锁的拥有者
    AtomicReference<Thread> owner = new AtomicReference<>();
    // 需要锁池
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public void lock() {
        // CAS -- 此处直接CAS，是一种非公平的实现
        while (!owner.compareAndSet(null, Thread.currentThread())) {
            // TODO 没拿到锁，等待
            waiters.add(Thread.currentThread());
            LockSupport.park(); // 挂起，等待被唤醒...
        }
    }

    public void unlock() {
        if (owner.compareAndSet(Thread.currentThread(), null)) {
            // 释放锁之后，要唤醒一个线程
            Thread next = waiters.poll();
            LockSupport.unpark(next);
        }
    }
}
