package lipan.top.notes.leetcode;

import java.util.*;

/**
 * @author li.pan
 * @title 前k个高频元素
 * @Date 2022/6/7
 * <p>
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * </p>
 */
public class Lettcode347 {

    static class FreqComparable implements Comparable<FreqComparable> {
        int e, freq;

        public FreqComparable(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreqComparable o) {
            // 直接用比较为最小堆
            return Integer.compare(freq, o.freq);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numMaps = new HashMap<>();
        for (int num : nums) {
            if (numMaps.containsKey(num))
                numMaps.put(num, numMaps.get(num) + 1);
            else
                numMaps.put(num, 1);
        }
        // 返回其中出现频率k高的元素
        PriorityQueue<FreqComparable> priorityQueue = new PriorityQueue<FreqComparable>();
        for (Map.Entry<Integer, Integer> entry : numMaps.entrySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(new FreqComparable(entry.getKey(), entry.getValue()));
            else { // 和最小的比较,大于最小的移除并添加
                FreqComparable peek = priorityQueue.peek();
                if (peek != null && peek.freq < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(new FreqComparable(entry.getKey(), entry.getValue()));
                }
            }
        }
        int size = priorityQueue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++)
            res[i] = Objects.requireNonNull(priorityQueue.poll()).e;

        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));

    }
}
