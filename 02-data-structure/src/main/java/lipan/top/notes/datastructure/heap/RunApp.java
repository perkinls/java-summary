package lipan.top.notes.datastructure.heap;

import java.util.Random;

/**
 * @author li.pan
 * @title 测试最大堆
 */
public class RunApp {
    /**
     * 测试堆的行为是否符合预期
     */
    private static void testAddAndExtractMax() {
        int n = 1000000;
        // 随机往堆里添加n个元素
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        // 取出堆中的所有元素，放到arr中
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        // 由于堆的特性，此时arr中的元素理应是有序的
        // 所以这里校验一下arr是否是有序的，如果无序则代表堆的实现有问题
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }

    public static void main(String[] args) {
        testAddAndExtractMax();
    }
}
