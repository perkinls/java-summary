package lipan.top.notes.basicsort.impl.optimize;


import lipan.top.notes.basicsort.ISort;
import lipan.top.notes.basicsort.SortTestHelper;

/**
 * <p/>
 * <li>title: 快速排序优化</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2019/12/10 22:50 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 优化1: 对于小规模数组, 使用插入排序,效率更佳
 * 优化2: 对于arr[l...r]可能近乎有序的数组,采用获取随机值的方式随机获取基准值位置
 * 优化3: 对于arr[l...r]可能存在大量元素的数组,可以将数组分割为小于V,等于V,大于V的三部分,然后对小于V和大于V部分进行递归
 * </li>
 */
public class QuickSortOptimize implements ISort<Integer> {

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
    private static void sort(Integer[] arr, int l, int r) {

        /**
         *  优化1: 对于小规模数组, 使用插入排序,效率更佳
         */
        if (r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }

        /**
         * 优化2: 对于arr[l...r]可能近乎有序的数组,采用获取随机值的方式随机获取基准值位置
         * (int) (Math.random() * (r - l + 1)) + l
         */
        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Integer v = arr[l];

        /**
         * 优化3: 对于arr[l...r]可能存在大量元素的数组,可以将数组分割为小于V,等于V,大于V的三部分,然后对小于V和大于V部分进行递归
         * 简称"三路快排"
         */
        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i] < v) {
                SortTestHelper.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }
        SortTestHelper.swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void insertionSort(Integer[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Integer e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1] > e; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }


}
