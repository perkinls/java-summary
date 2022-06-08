package lipan.top.notes.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author li.pan
 * @title 两数之和
 * @Date 2022/6/7
 * <p>
 * https://leetcode.cn/problems/two-sum/
 * </p>
 */
public class Lettcode001 {
    public static int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(target - nums[i]))
                return new int[]{res.get(target - nums[i]), i};
            res.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum1(nums1, 9)));
        System.out.println(Arrays.toString(twoSum2(nums1, 9)));
        System.out.println("--------------------");
        int[] nums2 = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum1(nums2, 6)));
        System.out.println(Arrays.toString(twoSum2(nums2, 6)));
        System.out.println("--------------------");
        int[] nums3 = {3, 3};
        System.out.println(Arrays.toString(twoSum1(nums3, 6)));
        System.out.println(Arrays.toString(twoSum2(nums3, 6)));
        System.out.println("--------------------");
    }
}
