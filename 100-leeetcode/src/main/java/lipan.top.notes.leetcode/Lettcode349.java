package lipan.top.notes.leetcode;

import java.util.*;

/**
 * @author li.pan
 * @title 两个数组的交集I
 */
public class Lettcode349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        // 对第一个集合中的元素去重
        Set<Integer> setS1 = new HashSet<>();
        for (int s1 : nums1) {
            setS1.add(s1);
        }

        ArrayList<Integer> resList = new ArrayList<>();
        // 遍历第二个集合
        for (int s2 : nums2) {
            if (setS1.contains(s2)) {
                resList.add(s2);
                // 防止第二个集合中相同元素多个
                setS1.remove(s2);
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
        int[] a = new int[]{1, 2, 2, 1};
        int[] b = new int[]{2, 2};
        int[] res = intersection(a, b);
        assert res != null;
        for (int r : res) {
            System.out.println(r);
        }
    }
}
