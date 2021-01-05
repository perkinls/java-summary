package lipan.top.notes.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class SingleThreadExecutor {

    /**
     * 我们获取四次次线程，观察4个线程地址
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("****************************newFixedThreadPool*******************************");
        for (int i = 0; i < 4; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new ThreadForpools(index));
        }
    }
}
