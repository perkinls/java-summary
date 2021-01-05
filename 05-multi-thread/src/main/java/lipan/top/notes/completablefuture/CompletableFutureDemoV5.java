package lipan.top.notes.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 证明每一步都是异步执行的
 * @createTime 2020年12月21日 21:28:00
 */
public class CompletableFutureDemoV5 {
    public  static void asyncCallback() throws ExecutionException, InterruptedException {
        CompletableFuture<String> ref1=  CompletableFuture.supplyAsync(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " supplyAsync开始执行任务1.... ");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " supplyAsync: 任务1");
            return null;
        });
        CompletableFuture<String> ref2= CompletableFuture.supplyAsync(()->{
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " thenApplyAsync: 任务2");
            return null;
        });
        CompletableFuture<String> ref3=ref2.thenApplyAsync(value->{
            System.out.println(Thread.currentThread().getName() +" thenApplyAsync: 任务2的子任务");
            return  " finish";
        });
        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName() + ref3.get());
    }
    public static void main(String[] args) throws Exception {
        asyncCallback();
    }
}
