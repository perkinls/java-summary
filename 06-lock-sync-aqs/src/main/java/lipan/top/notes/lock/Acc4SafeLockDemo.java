package lipan.top.notes.lock;

import lipan.top.notes.lock.udf.UdfLockSafeImpl;

import java.io.IOException;


/**
 * lock时下线程安全
 */
public class Acc4SafeLockDemo {
    volatile int i = 0;

    // 自己写 --
    UdfLockSafeImpl lock = new UdfLockSafeImpl(); // 基于sync关键字的原理来手写


    //Lock lock=new ReentrantLock();

    public void add() { // 方法栈帧~ 局部变量
        lock.lock(); // 如果一个线程拿到锁，其他线程会等待
        try {
            i++; // 三次操作,字节码太难懂
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws IOException {
        Acc4SafeLockDemo ld = new Acc4SafeLockDemo();

        for (int i = 0; i < 2; i++) { // 2w相加，20000
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
