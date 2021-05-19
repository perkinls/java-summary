package lipan.top.notes.lock;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;


/**
 * 两个线程，对 i 变量进行递增操作(CAS保证线程安全)
 */
public class Acc2SafeCASDemo {
    volatile int i = 0;
    private static Unsafe unsafe;
    static long valueOffset; // 属性偏移量，用于JVM去定位属性在内存中的地址

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            // CAS 硬件原语 ---java语言 无法直接改内存。 曲线通过对象及属性的定位方式
            valueOffset = unsafe.objectFieldOffset(Acc2SafeCASDemo.class.getDeclaredField("i"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add() { // 方法栈帧~ 局部变量
        int current;
        int value;
        do {
            current = unsafe.getIntVolatile(this, valueOffset); // 读取当前值
            value = current + 1; // 计算
        } while (!unsafe.compareAndSwapInt(this, valueOffset, current, value));// CAS 底层API

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Acc2SafeCASDemo ld = new Acc2SafeCASDemo();

        // 2w相加，20000
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    ld.add();
                }
            }).start();
        }
        System.in.read(); // 输入任意键退出
        System.out.println(ld.i);
    }
}
