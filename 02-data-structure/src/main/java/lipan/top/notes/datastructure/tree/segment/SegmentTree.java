package lipan.top.notes.datastructure.tree.segment;


/**
 * @author li.pan
 * @title 线段树：维护区间信息（要求满足结合律）
 * @Date 2022/6/8
 */
public class SegmentTree<E> {
    private final E[] tree; // 线段树
    private final E[] data; // 数据集合
    private final IMerger<E> iMerger; // 区间的具体操作

    public SegmentTree(E[] array, IMerger<E> merger) {
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++)
            data[i] = array[i];

        this.tree = (E[]) new Object[array.length * 4];
        this.iMerger = merger;
        /* 构建线段树 */
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 构建线段树
     *
     * @param treeIndex 创建线段树根节点对应的索引
     * @param l         左边界
     * @param r         右边界
     *
     *                  <p>
     *                  每个节点 treeIndex 的左右子节点的编号分别为 [treeIndex * 2] 和 [treeIndex * 2+  1]
     *                  </p>
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) // 递归到叶子节点
            tree[treeIndex] = data[l]; // 用数组中的数据赋值
        else {
            int midIndex = l + (r - l) / 2;
            int leftChildIndex = leftChild(treeIndex);
            int rightChildIndex = rightChild(treeIndex);

            buildSegmentTree(leftChildIndex, l, midIndex);
            buildSegmentTree(rightChildIndex, midIndex + 1, r);

            tree[treeIndex] = iMerger.merge(tree[treeIndex], tree[treeIndex]);
        }
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }


    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }


    // 返回区间[queryL, queryR]的值

    /**
     * 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     *
     * @param queryL 查询左边界
     * @param queryR 查询右边界
     * @return 区间信息
     */
    public E query(int queryL, int queryR) {

        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;

        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        // 横跨左右,将查询切分为 [searchL,midIndex] 和 [midIndex+1,searchR] 然后再合并
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return iMerger.merge(leftResult, rightResult);
    }


    /**
     * 将index位置的值，更新为e
     *
     * @param index 更新索引的位置
     * @param e     更新后的元素e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else // index <= mid
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = iMerger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
