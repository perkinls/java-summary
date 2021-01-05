package lipan.top.notes.singleton;

/**
 * <li>title: 4. 饿汉模式(线程安全)</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:27 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 饿汉式在<类加载>时已经创建好该对象，在程序调用时直接返回该单例对象即可，即我们在编码时就已经指明了要马上创建这个对象，
 * 不需要等到被调用时再去创建。
 * </li>
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("HungrySingleton Constructor");
    }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
