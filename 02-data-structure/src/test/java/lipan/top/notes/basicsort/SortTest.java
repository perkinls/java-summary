package lipan.top.notes.basicsort;

import lipan.top.notes.basicsort.impl.*;
import lipan.top.notes.basicsort.impl.optimize.MergeSortOptimize;
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

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSortTest() {
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
        System.out.println("冒泡排序测试1数据量为100" + SortTestHelper.testSort(integers0, new BubbleSort()));
        System.out.println("冒泡排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new BubbleSort()));
        System.out.println("冒泡排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new BubbleSort()));
    }

    /**
     * 希尔排序
     */
    @Test
    public void shellSortTest() {
        Integer[] integers0 = SortTestHelper.generateRandomArray(100, 0, 1000000);
        Integer[] integers1 = SortTestHelper.generateRandomArray(10000, 0, 1000000);
        Integer[] integers2 = SortTestHelper.generateRandomArray(100000, 0, 1000000);
        System.out.println("------------------------------随机数组--------------------------------");
        System.out.println("插入排序测试1数据量为100" + SortTestHelper.testSort(integers0, new InsertionSort()));
        System.out.println("插入排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new InsertionSort()));
        System.out.println("插入排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new InsertionSort()));
        System.out.println("冒泡排序测试1数据量为100" + SortTestHelper.testSort(integers0, new BubbleSort()));
        System.out.println("冒泡排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new BubbleSort()));
        System.out.println("冒泡排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new BubbleSort()));
        System.out.println("希尔排序测试1数据量为100" + SortTestHelper.testSort(integers0, new ShellSort()));
        System.out.println("希尔排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new ShellSort()));
        System.out.println("希尔排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new ShellSort()));
    }

    /**
     * 归并排序
     */
    @Test
    public void mergeSortTest() {
        Integer[] integers0 = SortTestHelper.generateRandomArray(100, 0, 1000000);
        Integer[] integers1 = SortTestHelper.generateRandomArray(10000, 0, 1000000);
        Integer[] integers2 = SortTestHelper.generateRandomArray(100000, 0, 1000000);
        System.out.println("------------------------------随机数组--------------------------------");
        System.out.println("插入排序测试1数据量为100" + SortTestHelper.testSort(integers0, new InsertionSort()));
        System.out.println("插入排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new InsertionSort()));
        System.out.println("插入排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new InsertionSort()));
        System.out.println("冒泡排序测试1数据量为100" + SortTestHelper.testSort(integers0, new BubbleSort()));
        System.out.println("冒泡排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new BubbleSort()));
        System.out.println("冒泡排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new BubbleSort()));
        System.out.println("希尔排序测试1数据量为100" + SortTestHelper.testSort(integers0, new ShellSort()));
        System.out.println("希尔排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new ShellSort()));
        System.out.println("希尔排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new ShellSort()));
        System.out.println("归并排序测试1数据量为100" + SortTestHelper.testSort(integers0, new MergeSort()));
        System.out.println("归并排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new MergeSort()));
        System.out.println("归并排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new MergeSort()));
    }

    /**
     * 归并排序优化测试
     */
    @Test
    public void mergeOptimizeSortTest() {
        Integer[] integers0 = SortTestHelper.generateRandomArray(100, 0, 1000000);
        Integer[] integers1 = SortTestHelper.generateRandomArray(10000, 0, 1000000);
        Integer[] integers2 = SortTestHelper.generateRandomArray(100000, 0, 1000000);
        System.out.println("------------------------------随机数组--------------------------------");
        System.out.println("插入排序测试1数据量为100" + SortTestHelper.testSort(integers0, new InsertionSort()));
        System.out.println("插入排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new InsertionSort()));
        System.out.println("插入排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new InsertionSort()));
        System.out.println("归并排序测试1数据量为100" + SortTestHelper.testSort(integers0, new MergeSort()));
        System.out.println("归并排序测试2数据量为10000" + SortTestHelper.testSort(integers1, new MergeSort()));
        System.out.println("归并排序测试3数据量为100000" + SortTestHelper.testSort(integers2, new MergeSort()));
        System.out.println("归并排序优化测试1数据量为100" + SortTestHelper.testSort(integers0, new MergeSortOptimize()));
        System.out.println("归并排序优化测试2数据量为10000" + SortTestHelper.testSort(integers1, new MergeSortOptimize()));
        System.out.println("归并排序优化测试3数据量为100000" + SortTestHelper.testSort(integers2, new MergeSortOptimize()));

        Integer[] integers00 = SortTestHelper.generateNearlyOrderedArray(100, 50);
        Integer[] integers11 = SortTestHelper.generateNearlyOrderedArray(10000, 5000);
        Integer[] integers22 = SortTestHelper.generateNearlyOrderedArray(100000, 50000);
        System.out.println("------------------------------近乎有序数组--------------------------------");
        System.out.println("插入排序测试1数据量为100" + SortTestHelper.testSort(integers00, new InsertionSort()));
        System.out.println("插入排序测试2数据量为10000" + SortTestHelper.testSort(integers11, new InsertionSort()));
        System.out.println("插入排序测试3数据量为100000" + SortTestHelper.testSort(integers22, new InsertionSort()));
        System.out.println("归并排序测试1数据量为100" + SortTestHelper.testSort(integers00, new MergeSort()));
        System.out.println("归并排序测试2数据量为10000" + SortTestHelper.testSort(integers11, new MergeSort()));
        System.out.println("归并排序测试3数据量为100000" + SortTestHelper.testSort(integers22, new MergeSort()));
        System.out.println("归并排序优化测试1数据量为100" + SortTestHelper.testSort(integers00, new MergeSortOptimize()));
        System.out.println("归并排序优化测试2数据量为10000" + SortTestHelper.testSort(integers11, new MergeSortOptimize()));
        System.out.println("归并排序优化测试3数据量为100000" + SortTestHelper.testSort(integers22, new MergeSortOptimize()));
    }

}
