package lipan.top.notes.singleton;

/**
 * <li>title: 1.懒汉模式(线程不安全)</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:07 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 这个方法其实是存在问题的，试想一下，如果两个线程同时判断singleton为空，
 * 那么它们都会去实例化一个Singleton对象，这就变成双例了。
 * </li>
 */
public class LazyThreadUnsafeSingleton {

    private static LazyThreadUnsafeSingleton singleton;

    private LazyThreadUnsafeSingleton() {
        System.out.println("LazyThreadUnsafeSingleton Constructor");
    }

    public static LazyThreadUnsafeSingleton getInstance() {
        // 多线程同时判定,会造成线程安全问题
        if (singleton == null) {
            singleton = new LazyThreadUnsafeSingleton();
        }
        return singleton;
    }
}
