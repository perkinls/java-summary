package lipan.top.notes.basicsort.impl;

import lipan.top.notes.basicsort.ISort;

import java.util.Arrays;

/**
 * <p/>
 * <li>title: 基础排序-归并排序</li>
 * <li>@author: li.pan</li>
 * <li>Date: 2019/12/7 12:15 下午</li>
 * <li>Version: V1.0</li>
 * <li>Description: </li>
 */
public class MergeSort implements ISort<Integer> {


    @Override
    public void sort(Integer[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    //递归使用归并排序，对arr[l....r]的范围进行进行排序 0,10 0/5 0/2
    private static void sort(Integer[] arr, int l, int r) {

        System.out.println("sort: arr=" + Arrays.toString(arr) + ",l=" + l + ",r=" + r);
        if (l >= r) { //当子序列中只有一个元素递归到底的情况
            System.out.println("------------------------------------------------------------------------------------------------");
            return;
        }

        int mid = (l + r) / 2;  // l=0 r=2
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Integer[] arr, int l, int mid, int r) {
        System.out.println("merge: arr=" + Arrays.toString(arr) + ",l=" + l + ",mid=" + mid + ",r=" + r);

        // 开辟临时空间，合并左半部分已经排好序的数组和右半部分已经排好序的数组
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
        System.out.println("merge: arr=" + Arrays.toString(aux) + ",l=" + l + ",mid=" + mid + ",r=" + r);

        // 初始化，i指向左半部分的起始位置索引；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {  // k指向两个元素比较后归并下一个需要放置的位置
            System.out.println("第K=" + k + "趟");

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
             * 真正比较: 两两比较放入新的序列arr
             */
            else if (aux[i - l] < aux[j - l]) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素（右边的放置待排序前面）
                arr[k] = aux[j - l];
                j++;
            }
        }
        System.out.println("\n");
    }

}

