package lipan.top.notes.sync;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 可重入锁：主线程调用test1方法(拿到锁),在方法里面递归调用(同一把锁)。
 *                       只要没释放，可以反反复复进入。
 * @createTime 2020年12月18日 16:13:00
 */
public class SynchronizedDemoV2 {
    public synchronized void test1(Object arg) {
        // 继续执行，保证能读取到之前的修改。JMM内存模型中规定
        System.out.println(Thread.currentThread() + " 我开始执行 " + arg);
        if (arg == null) {
            test1(new Object());
        }
        System.out.println(Thread.currentThread() + " 我执行结束" + arg);
    }

    public static void main(String[] args) throws InterruptedException {
        new SynchronizedDemoV2().test1(null);
    }
}
