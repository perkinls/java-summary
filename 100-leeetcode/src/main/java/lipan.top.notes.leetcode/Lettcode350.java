package lipan.top.notes.leetcode;

import java.util.*;

/**
 * @author li.pan
 * @title 两个数组的交集II
 */
public class Lettcode350 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        // 单词写入map集合中
        Map<Integer, Integer> mapS1 = new HashMap<>();
        for (int key : nums1) {
            if (mapS1.containsKey(key))
                mapS1.put(key, mapS1.get(key) + 1);
            else
                mapS1.put(key, 1);
        }

        ArrayList<Integer> resList = new ArrayList<>();
        // 遍历第二个集合
        for (int key : nums2) {
            if (mapS1.containsKey(key)) {
                resList.add(key);
                mapS1.put(key, mapS1.get(key) - 1);
                if (mapS1.get(key) == 0) {
                    mapS1.remove(key);
                }
            }
        }

        // 拼装返回数组
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,9,5};
        int[] b = new int[]{9,4,9,8,4};
        int[] res = intersection(a, b);
        assert res != null;
        for (int r : res) {
            System.out.println(r);
        }
    }
}
