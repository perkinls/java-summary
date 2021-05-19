package lipan.top.notes.datastructure.array;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 基于Java中数组进行二次封装
 * @createTime 2020年12月08日 22:59:00
 */
public class UdfArrayV1 {
    private int[] data;
    private int size;

    public UdfArrayV1() {
        this(10);
    }

    /**
     * 构造函数,传入数组的容量capacity构造array
     *
     * @param capacity
     */
    public UdfArrayV1(int capacity) {
        data = new int[capacity];
        size = 0;
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
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中末尾添加元素
     *
     * @param e
     */
    public void addList(int e) {

        // 如果元素的个数等于数组的容量，那么抛出异常
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed. array is full");
        data[size] = e;
        size++;
    }


    /**
     * 在第index个位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {

        if (size == data.length)
            throw new IllegalArgumentException("Add failed. array is full");

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. array is full");
        }

        // 对于index后面的元素都向后挪动一个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }


    /**
     * 在所有元素前添加一个新元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("GET failed. array is full");
        return data[index];
    }

    /**
     * 修改index索引位置的元素e
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
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
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果元素不存在，返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 从数组中删除index位置的元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed");

        int ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        // 这个地方需要注意
        size--;
        return ret;
    }


    /**
     * 从数组中删除第一个元素，返回删除的元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }


    /**
     * 从数组中删除元素e（只会删除一个）
     *
     * @param e
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
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
