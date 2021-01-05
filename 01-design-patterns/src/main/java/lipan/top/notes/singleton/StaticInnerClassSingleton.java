package lipan.top.notes.singleton;

/**
 * <li>title: 5. 饿汉模式-内部类(线程安全)</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:30 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 使用了一个专门的内部类来初始化Singleton，JVM将推迟SingletonHolder的初始化操作，直到开始使用这个类时才初始化。
 * 并且在初始化的过程中JVM会去获取一个用于同步多个线程对同一个类进行初始化的锁，这样就不需要额外的同步。
 * 这种方式不仅能够保证线程安全，也能保证单例对象的唯一性，同时也延迟实例化，是一种非常推荐的方式
 * </li>
 */
public class StaticInnerClassSingleton {

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
        System.out.println("StaticInnerClassSingleton Constructor");
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
