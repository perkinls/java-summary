package lipan.top.notes.singleton;

/**
 * <li>title: 6. 枚举实现(线程安全)</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2020/11/25 10:32 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 从Java1.5起，可以通过使用枚举机制来实现单例模式。虽然这种方法尚未被广泛采用，但单元素枚举类型是实现单例的最佳方法：
 * </li>
 */
public enum EnumSingleton {
    /**
     * 单例对象
     */
    INSTANCE;

    public void doSomething() {
        System.out.println("EnumSingleton doSomething");
    }
}
