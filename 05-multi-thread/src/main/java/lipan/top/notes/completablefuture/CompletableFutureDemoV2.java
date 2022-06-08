package lipan.top.notes.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description runAsync 运行一个简单的没有返回值的异步任务
 * @createTime 2020年12月21日 21:13:00
 */
public class CompletableFutureDemoV2 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<Void> future=CompletableFuture.runAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"正在执行一个没有返回值的异步任务。");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread().getName()+" 结束。");
    }

    // 从上面代码我们可以看到CompletableFuture默认运行使用的是ForkJoin的的线程池。
}
