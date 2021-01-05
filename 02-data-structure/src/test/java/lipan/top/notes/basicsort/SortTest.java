package lipan.top.notes.basicsort;

import org.junit.Test;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 选择排序测试类
 * @createTime 2020年12月08日 13:22:00
 */
public class SortTest {

    /**
     * 选择排序测试
     */
    @Test
    public void selectionSortTest() {
        Integer[] integers0 = SortTestHelper.generateRandomArray(100, 0, 1000000);
        Integer[] integers1 = SortTestHelper.generateRandomArray(10000, 0, 1000000);
        Integer[] integers2 = SortTestHelper.generateRandomArray(100000, 0, 1000000);
        System.out.println("------------------------------随机数组--------------------------------");
        System.out.println("选择排序测试1" + SortTestHelper.testSort(integers0, new SelectionSort()));
        System.out.println("选择排序测试2" + SortTestHelper.testSort(integers1, new SelectionSort()));
        System.out.println("选择排序测试3" + SortTestHelper.testSort(integers2, new SelectionSort()));

    }


    /**
     * 插入排序测试
     */
    @Test
    public void insertionSortTest() {
        Integer[] integers0 = SortTestHelper.generateRandomArray(100, 0, 1000000);
        Integer[] integers1 = SortTestHelper.generateRandomArray(10000, 0, 1000000);
        Integer[] integers2 = SortTestHelper.generateRandomArray(100000, 0, 1000000);
        System.out.println("------------------------------随机数组--------------------------------");
        System.out.println("选择排序测试1数据量为100耗" + SortTestHelper.testSort(integers0, new SelectionSort()));
        System.out.println("选择排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new SelectionSort()));
        System.out.println("选择排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new SelectionSort()));
        System.out.println("插入排序测试1数据量为100" + SortTestHelper.testSort(integers0, new InsertionSort()));
        System.out.println("插入排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new InsertionSort()));
        System.out.println("插入排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new InsertionSort()));
    }
}
