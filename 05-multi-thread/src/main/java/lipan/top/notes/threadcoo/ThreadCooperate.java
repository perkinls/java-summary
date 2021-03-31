package lipan.top.notes.threadcoo;

import java.util.concurrent.locks.LockSupport;

/**
 * <p/>
 * <li>title: 线程协作通信</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/3/17 10:39 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: 三种线程协作通信的方式：
 * 1、suspend/resume
 * 2、wait/notify
 * 3、park/unpark
 * </li>
 */
public class ThreadCooperate {
    /**
     * 包子店
     */
    public static Object bzd = null;

    /**
     * 正常的suspend/resume
     *
     * @throws Exception
     */
    public void suspendResumeTest() throws Exception {
        // 启动线程
        Thread consumerThread = new Thread(() -> {
            if (bzd == null) { // 如果没包子，则进入等待
                System.out.println("1、进入等待");
                Thread.currentThread().suspend();
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        consumerThread.resume();
        System.out.println("3、通知消费者");
    }

    /**
     * 死锁的suspend/resume。
     * suspend并不会像wait一样释放锁，因此形成死循环。
     *
     * @throws Exception
     */
    public void suspendResumeDeadLockTest() throws Exception {
        // 启动线程
        Thread consumerThread = new Thread(() -> {
            if (bzd == null) { // 如果没包子，则进入等待
                System.out.println("1、进入等待");
                // 当前线程拿到锁，然后挂起
                synchronized (this) {
                    Thread.currentThread().suspend();
                }
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        // 争取到锁以后，再恢复consumerThread
        synchronized (this) {
            consumerThread.resume();
        }
        System.out.println("3、通知消费者");
    }

    /**
     * suspend/resume执行先后顺序问题，导致程序永久挂起的suspend/resume
     *
     * @throws Exception
     */
    public void suspendResumeDeadLockTest2() throws Exception {
        // 启动线程
        Thread consumerThread = new Thread(() -> {
            if (bzd == null) {
                System.out.println("1、没包子，进入等待");
                try { // 为这个线程加上一点延时
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 这里的挂起执行在resume后面
                Thread.currentThread().suspend();
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        consumerThread.resume();
        System.out.println("3、通知消费者");
        consumerThread.join();
    }

    /**
     * 正常的wait/notify（会释放锁）
     *
     * @throws Exception
     */
    public void waitNotifyTest() throws Exception {
        // 启动线程
        new Thread(() -> {
            synchronized (this) {
                while (bzd == null) { // 如果没包子，则进入等待
                    try {
                        System.out.println("1、进入等待");
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("2、买到包子，回家");
        }).start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        synchronized (this) {
            this.notifyAll();
            System.out.println("3、通知消费者");
        }
    }

    /**
     * wait/notify 执行先后顺序问题后导致程序永久等待
     *
     * @throws Exception
     */
    public void waitNotifyDeadLockTest() throws Exception {
        // 启动线程
        new Thread(() -> {
            if (bzd == null) { // 如果没包子，则进入等待
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                synchronized (this) {
                    try {
                        System.out.println("1、进入等待");
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("2、买到包子，回家");
        }).start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        synchronized (this) {
            this.notifyAll();
            System.out.println("3、通知消费者");
        }
    }


    /**
     * 线程调用 park 表示线程等待"许可"，unpack 表示为指定的线程提供"许可"
     * park和 unpark 对调用顺序没有要求。
     * 多次调用 unpack 之后，再调用 pack ，线程会立即执行。
     * 但是这个"许可"不是叠加的，是一个标志位。
     * 例如多次调用了 unpack 这个时候也只有一个"许可"，这个时候调用一次 park 就会拿到"许可"直接运行。后面的 park 还是得继续等待
     * <p>
     * 正常的park/unpark
     */
    public void parkUnparkTest() throws Exception {
        // 启动线程
        Thread consumerThread = new Thread(() -> {
            while (bzd == null) { // 如果没包子，则进入等待
                System.out.println("1、进入等待");
                LockSupport.park();
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        LockSupport.unpark(consumerThread);
        System.out.println("3、通知消费者");
    }

    /**
     * park/unpark 不能自动释放锁，可能会导致死锁
     */
    public void parkUnparkDeadLockTest() throws Exception {
        // 启动线程
        Thread consumerThread = new Thread(() -> {
            if (bzd == null) { // 如果没包子，则进入等待
                System.out.println("1、进入等待");
                // 当前线程拿到锁，然后挂起
                synchronized (this) {
                    LockSupport.park();
                }
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 3秒之后，生产一个包子
        Thread.sleep(3000L);
        bzd = new Object();
        // 争取到锁以后，再恢复consumerThread
        synchronized (this) {
            LockSupport.unpark(consumerThread);
        }
        System.out.println("3、通知消费者");
    }


    /**
     * 前面使用了if (baozidian==null) 来判断是否进入等待状态，是错误的。
     * 是指并非由notify/unpack来唤醒的，由更底层的原因被唤醒。
     * @throws InterruptedException
     */
    public void waitNotifyGoodTest() throws InterruptedException {
        new Thread(() -> {
            synchronized (this) {
                //将while放入同步锁中判断
                while (bzd == null) {
                    System.out.println("1 进入等待，线程将会被挂起");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程被唤醒了");
            }
            System.out.println("3 买到包子，回家");
        }).start();

        Thread.sleep(2000L);
        bzd = new Object();
        synchronized (this) {
            this.notify();
        }
        System.out.println("2 通知消费者，消费者线程被唤醒");
    }

    public static void main(String[] args) throws Exception {
        // 对调用顺序有要求，也要开发自己注意锁的释放。这个被弃用的API,容易死锁,也容易导致永久挂起。
        new ThreadCooperate().suspendResumeTest();
        new ThreadCooperate().suspendResumeDeadLockTest();
        new ThreadCooperate().suspendResumeDeadLockTest2();

        // wait/notify要求再同步关键字里面使用，免去了死锁的困扰，但是一定要先调用wait，再调用notify，否则永久等待了
        new ThreadCooperate().waitNotifyTest();
        new ThreadCooperate().waitNotifyDeadLockTest();
//
//        // park/unpark没有顺序要求，但是park并不会释放锁，所有再同步代码中使用要注意
//        new ThreadCooperate().parkUnparkTest();
//        new ThreadCooperate().parkUnparkDeadLockTest();

        // 伪唤醒
        new ThreadCooperate().waitNotifyGoodTest();
    }
}
