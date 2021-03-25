package lipan.top.notes.basicsort.impl;

import lipan.top.notes.basicsort.ISort;
import lipan.top.notes.basicsort.SortTestHelper;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年01月26日 20:40:00
 */
public class QuickSort implements ISort<Integer> {
    /**
     * 快速排序入口
     *
     * @param arr 数组
     */
    @Override
    public void sort(Integer[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    /**
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     *
     * @param arr 无序集合
     * @param l   低索引
     * @param r   高索引
     */
    public static void sort(Integer[] arr, int l, int r) {

        // 递归到底
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    /**
     * 比基准值小的放置在基准值前面，比基准值大的放置在基准值后面(相同数据可以放置任意一边)
     * 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     *
     * @param arr 无序数组
     * @param l   低索引
     * @param r   高索引
     * @return
     */
    private static int partition(Integer[] arr, int l, int r) {

        Integer v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (arr[i] < v) {
                j++;
                SortTestHelper.swap(arr, j, i);
            }

        SortTestHelper.swap(arr, l, j);
        return j;
    }
}
