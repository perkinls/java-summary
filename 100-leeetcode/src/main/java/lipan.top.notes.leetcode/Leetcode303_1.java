package lipan.top.notes.leetcode;

/**
 * @author li.pan
 * @title 区域和检索 - 数组不可变
 * @Date 2022/6/8
 * <p>
 * https://leetcode.cn/problems/range-sum-query-immutable/
 * </p>
 */
public class Leetcode303_1 {

    /* 方式一: 数组元素和累加的方式 */
    // index+1 存储的是前index个元素之和
    private int[] sums;
    public Leetcode303_1(int[] nums) {
        sums = new int[nums.length + 1];
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }
    }
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-2, 0, 3, -5, 2, -1};
        System.out.println(new Leetcode303_1(nums1).sumRange(0, 2));
        System.out.println(new Leetcode303_1(nums1).sumRange(2, 5));
        System.out.println(new Leetcode303_1(nums1).sumRange(0, 5));
    }
}
