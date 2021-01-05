package lipan.top.notes.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description LinkedBlockingQueue 基于链表实现的FIFO的阻塞队列，创建是可以指定容量大小，不指定则是默认值Integer.MAX_VALUE。
 * 阻塞队列: 当队列为空时，去队列中取数据会被阻塞。当队列满时，往队列中放数据会被阻塞。
 * @createTime 2020年12月21日 12:59:00
 */
public class LinkedBlockingQueueDemo {

    /**
     * 使用并发包下LinkedBlockingQueue阻塞队列模拟生产者消费者问题
     *
     * @param args
     */
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread t1 = new Thread(producerThread);
        Thread t2 = new Thread(consumerThread);
        t1.start();
        t2.start();
        //10秒后 停止线程..
        try {
            Thread.sleep(10 * 1000);
            producerThread.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 生存者类
     */
    static class ProducerThread implements Runnable {
        //定义变量接收LinkedBlockingQueue
        BlockingQueue<String> queue = null;

        public ProducerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }
        //定义一个自增的变量，用来作为队列里面的消息
        AtomicInteger data = new AtomicInteger(0);

        //定义循环的结束条件
        boolean flag = true;

        @Override
        public void run() {
            try {
                //循环往队列里面放值，如果放不进去，设置两秒的等待时间。每个循环设置1秒的等待时间，以便打印的时候方便查看
                System.out.println(Thread.currentThread().getName() + " 生产者启动-----");
                while (flag) {
                    //获取data自增的值
                    String message = data.incrementAndGet() + "";
                    boolean offer = queue.offer(message, 2, TimeUnit.SECONDS);
                    if (offer) {
                        System.out.println(Thread.currentThread().getName() + "  " + message + " 放入队列成功");
                    } else {
                        System.out.println(Thread.currentThread().getName() + "  " + message + " 放入队列失败");
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 生产者停止-----");
            } finally {
                System.out.println(Thread.currentThread().getName() + " 生产者停止-----");
            }
        }


        public void stop() {
            this.flag = false;
        }

    }

    static class ConsumerThread implements Runnable {
        //定义变量接收LinkedBlockingQueue
        BlockingQueue<String> queue = null;

        //定义循环的结束条件
        boolean flag = true;

        public ConsumerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //使用queue 去取队列中的消息
            System.out.println(Thread.currentThread().getName() + " 消费者启动-----");
            try {
                while (flag) {
                    String poll = queue.poll(2, TimeUnit.SECONDS);
                    if (poll == null) {
                        flag = false;
                        System.out.println("消费者超过2秒时间未获取到消息.");
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + "  消费者拿到  " + poll);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
