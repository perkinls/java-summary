package lipan.top.notes.basicsort.impl.optimize;


import lipan.top.notes.basicsort.ISort;

import java.util.Arrays;

/**
 * <p/>
 * <li>title: 归并排序优化</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2019/12/7 12:15 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description:
 * 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
 * 优化2: 对于小规模数组, 使用插入排序
 * </li>
 */
public class MergeSortOptimize implements ISort<Integer> {


    @Override
    public void sort(Integer[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    //递归使用归并排序，对arr[l....r]的范围进行进行排序
    private static void sort(Integer[] arr, int l, int r) {

        /**
         *  优化2: 对于小规模数组, 使用插入排序
         */
        if (r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        /**
         * 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
         * 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
         */
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);

    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Integer[] arr, int l, int mid, int r) {

        // 开辟临时空间，合并左半部分已经排好序的数组和右半部分已经排好序的数组
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始位置索引；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {  // k指向两个元素比较后归并下一个需要放置的位置

            /**
             * 考虑数组越界
             */
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕,
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++; // l表示偏移
            }
            /**
             * 真正比较
             */
            else if (aux[i - l] < aux[j - l]) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
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

