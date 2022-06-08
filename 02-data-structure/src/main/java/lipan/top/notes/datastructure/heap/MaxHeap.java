package lipan.top.notes.datastructure.heap;

/**
 * @author li.pan
 * @title 最大堆（数组实现,索引位置从0开始）
 * https://www.cnblogs.com/wmyskxz/p/9301021.html
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 实现将数组构建成一个最大堆(Heapify)
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        //实现heapify核心思想,从后至前找到第一个非叶子节点 开始下沉操作
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }


    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }


    /**
     * 返回一个布尔值, 表示堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index 索引
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index 索引
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index 索引
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }


    /**
     * 向最大堆中添加元素e
     *
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作(添加在堆最后一个索引位置)
     *
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看最大堆中最大的元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    /**
     * 下沉操作(最后一个元素提前,重新根据堆特性构建堆)
     *
     * @param k
     */
    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) { // 左子节点大于size时就证明到底了
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)   // 左右子节点中最大的节点下标
                j++;
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
