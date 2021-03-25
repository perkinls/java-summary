package lipan.top.notes.cas;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 原子更新整型数组里的元素
 * @createTime 2021年03月22日 19:54:00
 */
public class AtomicIntegerArrayDemo {
    // 数组value通过构造方法传递进去，然后AtomicIntegerArray会将当前数组复制一份，
    // 所以当AtomicIntegerArray对内部的数组元素进行修改时，不会影响传入的数组。
    private static int[] value = new int[]{1,2,3};
    private static AtomicIntegerArray atomicInteger = new AtomicIntegerArray(value);

    public static void main(String[] args){
        atomicInteger.getAndSet(0,12);
        System.out.println(atomicInteger.get(0));
        System.out.println(value[0]);
    }
}
