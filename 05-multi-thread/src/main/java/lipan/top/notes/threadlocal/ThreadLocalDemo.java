package lipan.top.notes.threadlocal;

/**
 * <p/>
 * <li>title: 线程封闭</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/3/18 1:11 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 为了确保线程的安全，通常需要保证可变的共享数据的同步访问，具体采用的方式有很多；但还有一种方法可以保证线程的安全，
 * 即是使可变数据不共享，或者是使数据不可变。所谓“线程封闭”即是仅在单线程中访问数据，也就是通过让可变数据不被多个线程共享以确保数据的正确性。
 * 1、ThreadLocal
 * 2、局部变量
 * </li>
 */
public class ThreadLocalDemo {
    /**
     * threadLocal变量，每个线程都有一个副本，互不干扰
     */
    public static ThreadLocal<String> value = new ThreadLocal<>();

    /**
     * 线程封闭测试代码
     **/
    public void threadLocalTest() throws Exception {

        // 主线程设置值
        value.set("这是主线程设置的123");
        String v = value.get();
        System.out.println("线程1执行之前，主线程取到的值：" + v);

        new Thread(() -> {
            String v1 = value.get();
            System.out.println("线程1取到的值：" + v1);
            // 设置 threadLocal
            value.set("这是线程1设置的456");

            v1 = value.get();
            System.out.println("重新设置之后，线程1取到的值：" + v1);
            System.out.println("线程1执行结束");
        }).start();

        // 等待所有线程执行结束
        Thread.sleep(5000L);
        v = value.get();
        System.out.println("线程1执行之后，主线程取到的值：" + v);

    }

    public static void main(String[] args) throws Exception {
        new ThreadLocalDemo().threadLocalTest();
    }
}
