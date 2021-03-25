package lipan.top.notes.basicsort.impl;

import lipan.top.notes.basicsort.ISort;
import lipan.top.notes.basicsort.SortTestHelper;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 选择排序
 * @createTime 2020年12月08日 13:07:00
 */
public class SelectionSort implements ISort<Integer> {
    /**
     * Step 1 − 设置最小值到位置0
     * Step 2 − 搜索列表中的最小元素
     * Step 3 − 在MIN位置交换值
     * Step 4 − 递增MIN以指向下一个元素
     * Step 5 − 重复直到列表排序
     *
     * @param arr
     */
    @Override
    public void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 最小元素索引
                    minIndex = j;
                }
            }
            //交换最小元素到头
            SortTestHelper.swap(arr, i, minIndex);
        }
    }

}
