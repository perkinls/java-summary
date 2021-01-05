package lipan.top.notes.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */
public class FixedThreadPools {


    /**
     * 我们获取四次次线程，观察4个线程地址
     *
     * @param args
     */
    public static void main(String[] args) {
        //线程池允许同时存在两个线程
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        System.out.println("****************************newFixedThreadPool*******************************");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            newFixedThreadPool.execute(new ThreadForpools(index));
        }
    }
}
