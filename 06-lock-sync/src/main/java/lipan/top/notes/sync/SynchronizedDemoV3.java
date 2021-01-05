package lipan.top.notes.sync;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 锁粗化、消除 来源于jit编译器优化
 * @createTime 2020年12月18日 16:13:00
 */
public class SynchronizedDemoV3 {
    int i;

    public void test1(Object arg) {
        synchronized (this) {
            i++;
            // }
            // synchronized (this) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000000; i++) {
            new SynchronizedDemoV3().test1("a");
        }
    }
}
