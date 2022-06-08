package lipan.top.notes.datastructure.heap;

import lipan.top.notes.datastructure.array.UdfArrayV2;

/**
 * @author li.pan
 * @title 用于实现堆的自定义数组结构
 */
public class Array<E> extends UdfArrayV2<E> {

    /**
     * 数据类型由之前的int改成现在的
     */
    private E[] data;
    private int size;

    /**
     * 无参数的构造函数，默认数组容量capaciay=10
     */
    public Array() {
        this(10);
    }

    /**
     * 构造函数,传入数组的容量capacity构造array
     * 这里使用了强制类型转化
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        size = arr.length;
    }

    /**
     * 交换元素
     *
     * @param j
     * @param i
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");
        E t = data[j];
        data[i] = data[j];
        data[j] = t;
    }
}
