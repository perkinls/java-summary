package lipan.top.notes.datastructure.array;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 自定义数组 E 范型
 * @createTime 2020年12月09日 13:03:00
 */
public class UdfArrayV2<E> {

    /**
     * 数据类型由之前的int改成现在的
     */
    private E[] data;
    private int size;


    /**
     * 构造函数,传入数组的容量capacity构造array
     * 这里使用了强制类型转化
     *
     * @param capacity
     */
    public UdfArrayV2(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组容量capaciay=10
     */
    public UdfArrayV2() {
        this(10);
    }


    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 向所有元素后添加一个新元素，转入参数类型改变
     *
     * @param e
     */
    public void addLast(E e) {

        // 如果元素的个数等于数组的容量，那么抛出异常
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed. array is full");
        data[size] = e;
        size++;

    }


    /**
     * 在所有元素前添加一个新元素，转入参数类型改变
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 在第index个位置插入一个新元素e，转入参数类型改变
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        // 如果数组已经满了
        if (size == data.length)
            // 调用动态数组，扩容到之前容量的二倍
            resize(2 * data.length);

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. array is full");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;


    }


    /**
     * 获取index索引位置的元素，返回类型改变
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("GET failed. array is full");
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }


    /**
     * 修改index索引位置的元素e，转入参数类型改变
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed. array is full");
        data[index] = e;
    }


    /**
     * 查找数组中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 查找数组中元素e所在的索引，如果元素不存在，返回-1，转入参数类型改变
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素，返回类型改变
     *
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed");

        E ret = data[index];
        for (int i = index + 1 ; i < size ; i++)
            data [ i - 1] = data[i];
        size --;
        // data[size] = null;    // loitering objects

        // 这里等于1/4的才进行缩容，但是还要注意长度除于2不能等于0
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }


    /**
     * 从数组中删除第一个元素，返回删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }


    /**
     * 从数组中删除最后一个元素，返回删除的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    /**
     * 动态扩展数组
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        // 使用泛型，强制类型转换
        E[] newData = (E[]) new Object[newCapacity];

        // 把之前数组中的数据传到新的数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        //新的数组再指向到原来的数组，狸猫换太子
        data = newData;

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array: size = %d , capacity = %d\n", size, data.length));

        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();

    }

}