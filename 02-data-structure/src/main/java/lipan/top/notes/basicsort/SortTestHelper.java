package lipan.top.notes.basicsort;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author li.pan
 * @version 1.0.0
 * @Description 为了方便对排序数组进行测试，工具类中定义了一些常用的方法：
 * <p>
 * 1. 生成随机数组Integer类型。
 * 2. 生成一个近乎有序的数组Integer类型。
 * 3. 数据位置交换Integer类型。
 * 4. 打印数据元素。
 * 5. 判断数组是否有序。
 * 6. 数组拷贝，返回一个新数组。
 * 7. 测试排序算法数据运行正确性和运行时间。
 * </p>
 * @createTime 2020年12月08日 12:43:00
 */
public class SortTestHelper {
    public SortTestHelper() {
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     *
     * @param n      元素个数
     * @param rangeL 数组元素起始位置
     * @param rangeR 数组元素结束位置
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] integerArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            integerArray[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return integerArray;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int rand1 = random.nextInt(n);
            int rand2 = random.nextInt(n);
            swap(arr, rand1, rand2);
        }

        return arr;
    }

    /**
     * 数据交换
     *
     * @param args     数组集合
     * @param i        待交换位置
     * @param minIndex 交换位置
     */
    public static void swap(Object[] args, int i, int minIndex) {
        if (i > args.length || minIndex > args.length) {
            throw new IllegalArgumentException("下标越界");
        }
        Object t = args[i];
        args[i] = args[minIndex];
        args[minIndex] = t;
    }

    /**
     * 遍历数组
     *
     * @param array 数组集合
     */
    public static void printArray(Object array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    /**
     * 判断一个数组是否有序
     *
     * @param arr 数组集合
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }

    /**
     * 数组拷贝, 返回一个数组的深度拷贝对象
     *
     * @param arr
     * @return
     */
    public static Integer[] copyArray(Integer[] arr) {
        Integer[] copyArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    /**
     * 返回排序算法时间
     *
     * @param arr
     * @param sort
     * @return
     */
    public static String testSort(Comparable[] arr, ISort sort) {
        long startTime = System.currentTimeMillis();
        sort.sort(arr);
        long endTime = System.currentTimeMillis();
        if (!isSorted(arr)) {
            throw new RuntimeException("数组排序异常");
        }
        return "排序时长为: "+(endTime - startTime) / 1000.0 + "s";
    }


    /**
     * 测试排序算法数据运行正确性和运行时间
     *
     * @param sortClassName 主类
     * @param arr           数组
     */
    public static void testSort(String sortClassName, Comparable[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
