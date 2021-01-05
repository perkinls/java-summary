package lipan.top.notes.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 简单使用CompletableFuture
 * @createTime 2020年12月21日 21:11:00
 */
public class CompletableFutureDemoV1 {

    /**
     * 在主线程里面创建一个CompletableFuture，然后主线程调用get方法会阻塞，最后我们在一个子线程中使其终止。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // ForkJoinPool所有的工作线程都是守护模式的，也就是说如果主线程退出，那么整个处理任务都会结束，而不管你当前的任务是否执行完。
        // 如果需要主线程等待结束，可采用ExecutorsThreadPool
        // ExecutorService pool = Executors.newFixedThreadPool(5);
        // final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        //        ... }, pool);

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " 执行.....");
                completableFuture.complete("success");//在子线程中完成主线程completableFuture的完成
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();//启动子线程
        String result = completableFuture.get();//主线程阻塞，等待完成
        System.out.println(Thread.currentThread().getName() + " 1x:  " + result);
    }
}
