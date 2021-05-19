package lipan.top.notes.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 自定义Cas实现
 * @createTime 2021年03月22日 16:23:00
 */
public class CounterUnsafeDemo {
    volatile int i = 0;

    private static Unsafe unsafe = null;
    //偏移量
    private static Long valueOffset;

    static {
        try {
            //通过反射得到Unsafe类
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            //获取i字段的偏移量
            Field fieldi = CounterUnsafeDemo.class.getDeclaredField("i");
            valueOffset = unsafe.objectFieldOffset(fieldi);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void add() {

        for (;;){
            //通过偏移量取到变量值
            int current = unsafe.getIntVolatile(this,valueOffset);
            //若CAS操作成功，则停止自旋
            if(unsafe.compareAndSwapInt(this, valueOffset, current, current+1)) {
                break;
            }
        }

    }
}
