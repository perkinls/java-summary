package lipan.top.notes.basicsort.impl;

import lipan.top.notes.basicsort.ISort;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 希尔排序
 * @createTime 2021年01月26日 20:36:00
 */
public class ShellSort implements ISort<Integer> {
    @Override
    public void sort(Integer[] arr) {

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) { // 同一步长内
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Integer e = arr[i];
                int j = i;
                for (; j >= h && e < arr[j - h]; j -= h)
                    arr[j] = arr[j - h]; //原有序数组最大的后移
                arr[j] = e; //找到了合适的位置插入
            }
            h /= 3; // 步长逐渐减少
        }

    }
}
