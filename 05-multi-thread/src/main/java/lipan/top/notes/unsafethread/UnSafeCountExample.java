package lipan.top.notes.unsafethread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p/>
 * <li>Description: 线程不安全统计模拟实例</li>
 * <li>@author: lipan@cechealth.cn</li>
 * <li>Date: 2019-05-24 13:37</li>
 * <li>Version: V1.0</li>
 * Semaphore类：信号量.
 *             充当监控并发数的角色。能够维持在同一时间的请求的并发量，达到并发量上线，会阻塞进程。
 * CountDownLatch类：计数器向下减的闭锁
 *                 CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 *
 *                 CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，
 *                 计数器的值就会减1。当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 *
 *             eg:假设计数器的值为3，线程A执行了await()方法之后，进入了awaiting等待状态。在其他线程的方法中执行了countDown()方法之后，
 *             计数器的值都会减一，直到计数器的值减为0，线程A的方法才继续执行。所以说，countDownLatch类可以阻塞线程执行，并且当满足
 *             指定条件后让线程继续执行。
 */
public class UnSafeCountExample {
    private static Logger log = LoggerFactory.getLogger("UnSafeCountExample");
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行线程数
     */
    public static int threadTotal = 200;
    /**
     * 计数  多个线程执行，会引发线程不安全问题
     */
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //创建一个缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量，给出允许并发的数目
        final Semaphore semaphore = new Semaphore(threadTotal);
        //定义计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();//判断进程是否允许被执行
                    add();
                    semaphore.release();//释放进程
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();//保证信号量减为0,等待所有的线程执行完毕
        executorService.shutdown();//关闭线程池
        log.info("count:{}", count);
    }


    private static void add() {
        count++;
    }
}
