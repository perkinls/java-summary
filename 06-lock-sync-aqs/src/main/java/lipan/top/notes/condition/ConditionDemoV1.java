package lipan.top.notes.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description
 * Condition 接口也提供了类似Object的监视器方法，与Lock配合可以实现等待/通知模式
 * (一般用于底层组件开发)
 * @createTime 2020年12月21日 10:22:00
 */
public class ConditionDemoV1 {

    final Lock lock = new ReentrantLock();
    // 指定条件的等待 - 等待有空位
    final Condition notFull = lock.newCondition();
    // 指定条件的等待 - 等待不为空
    final Condition notEmpty = lock.newCondition();

    // 定义数组存储数据
    final Object[] items = new Object[100];
    int putPtr, takePtr, count;


    /**
     * 写入数据的线程,写入进来
     *
     * @param x
     * @throws InterruptedException
     */
    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) // 数据写满了
                notFull.await(); // 写入数据的线程,进入阻塞
            items[putPtr] = x;
            if (++putPtr == items.length) putPtr = 0;
            ++count;
            notEmpty.signal(); // 唤醒指定的读取线程
        } finally {
            lock.unlock();
        }
    }

    /**
     * 读取数据的线程,调用take
     *
     * @return
     * @throws InterruptedException
     */
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await(); // 线程阻塞在这里,等待被唤醒
            Object x = items[takePtr];
            if (++takePtr == items.length) takePtr = 0;
            --count;
            notFull.signal(); // 通知写入数据的线程,告诉他们取走了数据,继续写入
            return x;
        } finally {
            lock.unlock();
        }
    }
}
