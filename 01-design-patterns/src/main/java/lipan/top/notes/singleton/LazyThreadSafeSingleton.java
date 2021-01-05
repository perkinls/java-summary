package lipan.top.notes.singleton;

/**
 * <li>title: 2.懒汉模式(线程安全)</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:11 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 这样就规避了两个线程同时创建Singleton对象的风险，但是引来另外一个问题：
 * 每次去获取对象都需要先获取锁，并发性能非常地差，极端情况下，可能会出现卡顿现象。
 * </li>
 */
public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton singleton;

    private LazyThreadSafeSingleton() {
        System.out.println("LazyThreadSafeSingleton Constructor");
    }

    /** 当synchronized作用于静态方法时，其锁就是当前类的class对象锁 */
    public static synchronized LazyThreadSafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazyThreadSafeSingleton();
        }
        return singleton;
    }
}
