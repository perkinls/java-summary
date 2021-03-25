package lipan.top.notes.basicsort.impl;

import lipan.top.notes.basicsort.ISort;
import lipan.top.notes.basicsort.SortTestHelper;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 冒泡排序(双重for循环解决)
 * @createTime 2021年01月26日 20:23:00
 */
public class BubbleSort implements ISort<Integer> {
    @Override
    public void sort(Integer[] arr) {

        int length = arr.length;
        for (int i = 0; i <= length; i++) {
            //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { //即这两个相邻的数是逆序的，交换
                    SortTestHelper.swap(arr, j + 1, j);
                }
            }
        }
    }
}
