package lipan.top.notes.sync;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月18日 16:13:00
 */
public class SynchronizedDemoV4 {
    public void test3(Object arg) {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append(arg);
        builder.append("c");
        System.out.println(arg.toString());
    }

    public void test2(Object arg) {
        String a = "a";
        String c = "c";
        System.out.println(a + arg + c);
    }

    public void test1(Object arg) {
        // jit 优化, 消除了锁 （Buffer 实例 局部变量）
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append(arg);
        stringBuffer.append("c");
        // System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            new SynchronizedDemoV4().test1("123");
        }
    }
}
