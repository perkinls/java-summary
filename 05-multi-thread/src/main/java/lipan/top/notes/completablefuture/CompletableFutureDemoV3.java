package lipan.top.notes.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description supplyAsync 运行一个有返回值的异步任务
 * @createTime 2020年12月21日 21:15:00
 */
public class CompletableFutureDemoV3 {
    public static void main(String[] args) throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"正在执行一个有返回值的异步任务。");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "OK";
        });
        String result=future.get();
        System.out.println(Thread.currentThread().getName()+"  结果："+result);
    }
}
