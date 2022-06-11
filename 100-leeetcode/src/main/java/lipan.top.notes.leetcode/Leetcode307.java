package lipan.top.notes.leetcode;

/**
 * @author li.pan
 * @title 区域和检索 - 数组可修改
 * @Date 2022/6/8
 * <p>
 * https://leetcode.cn/problems/range-sum-query-immutable/
 * </p>
 */
public class Leetcode307 {

    interface Merger<E> {
        E merger(E var1, E var2);
    }

    class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            if (arr.length > 0) {
                data = (E[]) new Object[arr.length];
                tree = (E[]) new Object[arr.length * 4];
                this.merger = merger;

                for (int i = 0; i < arr.length; i++)
                    data[i] = arr[i];

                buildSegmentTree(0, 0, arr.length - 1);
            }

        }

        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) { // 递归到低的情况
                tree[treeIndex] = data[l];
                return;
            }
            int midIndex = l + (r - l) / 2;
            int leftChildIndex = treeIndex * 2 + 1;
            int rightChildIndex = treeIndex * 2 + 2;
            buildSegmentTree(leftChildIndex, l, midIndex);
            buildSegmentTree(rightChildIndex, midIndex + 1, r);
            tree[treeIndex] = merger.merger(tree[leftChildIndex], tree[rightChildIndex]);
        }

        public E searchRange(int searchL, int searchR) {
            return searchRange(0, 0, data.length - 1, searchL, searchR);
        }

        public void update(int index, E e) {
            data[index] = e;
            updateTree(0, 0, data.length - 1, index, e);
        }

        private void updateTree(int treeIndex, int l, int r, int updateIndex, E e) {
            if (l == r) { // 递归到底
                tree[treeIndex] = e;
                return;
            }
            int midIndex = l + (r - l) / 2;
            int leftChildIndex = treeIndex * 2 + 1;
            int rightChildIndex = treeIndex * 2 + 2;
            if (updateIndex <= midIndex)
                updateTree(leftChildIndex, l, midIndex, updateIndex, e);
            else
                updateTree(rightChildIndex, midIndex + 1, r, updateIndex, e);
            // 数据更新后相应的父亲节点涉及变化
            tree[treeIndex] = merger.merger(tree[leftChildIndex], tree[rightChildIndex]);
        }

        private E searchRange(int treeIndex, int l, int r, int searchL, int searchR) {
            if (l == searchL && r == searchR)
                return tree[treeIndex];
            int midIndex = l + (r - l) / 2;
            int leftChildIndex = treeIndex * 2 + 1;
            int rightChildIndex = treeIndex * 2 + 2;
            if (midIndex >= searchR) // 全在左节点
                return searchRange(leftChildIndex, l, midIndex, searchL, searchR);
            else if (midIndex < searchL) // 全在右节点
                return searchRange(rightChildIndex, midIndex + 1, r, searchL, searchR);

            // 横跨左右,将查询切分为 [searchL,midIndex] 和 [midIndex+1,searchR] 然后再合并
            E leftVal = searchRange(leftChildIndex, l, midIndex, searchL, midIndex);
            E rightVal = searchRange(rightChildIndex, midIndex + 1, r, midIndex + 1, searchR);
            return merger.merger(leftVal, rightVal);
        }
    }

    private SegmentTree segmentTree;

    public Leetcode307(int[] nums) {
        Integer[] num = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            num[i] = nums[i];

        this.segmentTree = new SegmentTree<>(num, Integer::sum);

    }

    public int sumRange(int left, int right) {
        return (int) segmentTree.searchRange(left, right);
    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5};
        Leetcode307 leetcode307 = new Leetcode307(nums1);
        System.out.println(leetcode307.sumRange(0, 2));
        leetcode307.update(1, 2);
        System.out.println(leetcode307.sumRange(0, 2));
    }
}
