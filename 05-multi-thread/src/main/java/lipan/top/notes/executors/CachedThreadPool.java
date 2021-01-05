package lipan.top.notes.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */
public class CachedThreadPool {

    /**
     * 我们获取四次次线程，观察4个线程地址
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("****************************newCachedThreadPool*******************************");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            newCachedThreadPool.execute(new ThreadForpools(index));
        }
    }
}

