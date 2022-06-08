package lipan.top.notes.countdownlatch.udf;

import lipan.top.notes.aqs.UdfAQSImpl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 自定义CountDownLatch实现, 基于自定义AQS实现
 * @createTime 2020年12月21日 11:08:00
 */
public class UdfCountDownLatchImplV3 {
    // Object  AQS = new Oject(state, queue);
    // AQS 具体实现对象（state、queue、owner）
    UdfAQSImpl aqs = new UdfAQSImpl() {
        /**
         * 获取共享资源
         * @return
         */
        @Override
        public int tryAcquireShared() { // 如果非等于0，代表当前还有线程没准备就绪，则认为需要等待
            return this.getState().get() == 0 ? 1 : -1;
        }

        /**
         * 释放共享资源
         * @return
         */
        @Override
        public boolean tryReleaseShared() { // 如果非等于0，代表当前还有线程没准备就绪，则不会通知继续执行
            return this.getState().decrementAndGet() == 0;
        }
    };

    public UdfCountDownLatchImplV3(int count) {
        aqs.setState(new AtomicInteger(count));
    }

    public void await() {
        aqs.acquireShared();
    }

    public void countDown() {
        aqs.releaseShared();
    }

    public static void main(String[] args) throws InterruptedException {
        // 一个请求，后台需要调用多个接口 查询数据
        UdfCountDownLatchImplV3 cdLdemo = new UdfCountDownLatchImplV3(10); // 创建，计数数值
        // 启动九个线程，最后一个两秒后启动
        for (int i = 0; i < 10; i++) {
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
