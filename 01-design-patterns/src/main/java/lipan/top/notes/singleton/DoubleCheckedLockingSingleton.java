package lipan.top.notes.singleton;

/**
 * <li>title: 3. 双重校验+加锁(线程安全)</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:18 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * JVM在保证最终结果正确的情况下，可以不按照程序编码的顺序执行语句，尽可能提高程序的性能。
 * 使用volatile关键字解决指令重排序问题。
 * </li>
 */
public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton singleton;

    private DoubleCheckedLockingSingleton() {
        System.out.println("DoubleCheckedLockingSingleton Constructor");
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (singleton == null) {
            /** 修饰代码块，指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。 */
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return singleton;
    }

}
