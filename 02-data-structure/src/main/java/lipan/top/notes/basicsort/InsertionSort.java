package lipan.top.notes.basicsort;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月08日 20:13:00
 */
public class InsertionSort implements ISort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 写法1：子列表的数据一一比较交换
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j - 1])
//                    SortTestHelper.swap(arr, j, j - 1);
//                else
//                    break;
//            }

            // 写法2: j-- 维护子列表
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--)
                SortTestHelper.swap(arr, j, j - 1);

            // 写法3 中间变量处理
//            Integer e = arr[i];
//            int j = i;
//            for (; j > 0 && arr[j - 1] > e; j--)
//                arr[j] = arr[j - 1];
//            arr[j] = e;
        }
    }
}
