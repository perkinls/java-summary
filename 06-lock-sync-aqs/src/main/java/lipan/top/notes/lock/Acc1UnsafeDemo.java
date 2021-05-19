package lipan.top.notes.lock;

import java.io.IOException;

/**
 * 两个线程，对 i 变量进行递增操作（线程不安全）
 */
public class Acc1UnsafeDemo {
    volatile int i = 0;

    /**
     * volatile保证了可见行,但是不能保证原子性
     */
    public void add() {
        i++;
        // 字节码的角度，三个步骤
        // int x = i; // 读取
        // int a = x + 1; // 计算
        // i = a; //赋值
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        Acc1UnsafeDemo ld = new Acc1UnsafeDemo();

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
