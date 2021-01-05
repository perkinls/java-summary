package lipan.top.notes.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 创建一个定长线程池，支持定时及周期性任务执行。
 */
public class ScheduledThreadPools {

    /**
     * 我们获取四次次线程，观察4个线程地址
     *
     * @param args
     */
    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("****************************newFixedThreadPool*******************************");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            //延迟三秒执行
            newScheduledThreadPool.schedule(new ThreadForpools(index), 3, TimeUnit.SECONDS);
        }
    }
}
