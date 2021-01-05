package lipan.top.notes.sync;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 类锁(class对象 ， 静态方法)，实例锁(this，普通方法)
 * @createTime 2020年12月18日 16:13:00
 */
public class SynchronizedDemoV1 {
    static Object temp = new Object();

    public void test1() { // 方法上面：锁的对象是类的一个实例(不同线程操作同一个实例)
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread() + " 我开始执行");
                Thread.sleep(3000L);
                System.out.println(Thread.currentThread() + " 我执行结束");
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            new SynchronizedDemoV1().test1();
        }).start();

        Thread.sleep(1000L); // 等1秒钟,让前一个线程启动起来
        new Thread(() -> {
            new SynchronizedDemoV1().test1();
        }).start();
    }
}
