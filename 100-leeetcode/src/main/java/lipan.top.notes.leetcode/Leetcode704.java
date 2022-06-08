package lipan.top.notes.leetcode;

import java.util.Stack;

/**
 * @author li.pan
 * @version 1.0.0
 * @title 力扣题
 * @createTime 2021年05月11日 20:45:00
 * <p>
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * </p>
 */
public class Leetcode704 {
    /*
     * 个人解答---- 使用递归方式实现内存消耗可能较大
     */
    //public static int search(int[] nums, int target) {
    //    return search(nums, target, 0, nums.length - 1);
    //}

    //private static int search(int[] nums, int target, int start, int end) {
    //    // 递归终止条件
    //    if (nums[0] > target || nums[nums.length - 1] < target)
    //        return -1;
    //    int midIndex = (start + end) / 2; // 计算中间位置

    //    if (nums[midIndex] == target)
    //        return midIndex;
    //    else if (nums[midIndex] != target && start == end)
    //        return -1;
    //    else if (nums[midIndex] > target)
    //        return search(nums, target, 0, midIndex - 1);
    //    else
    //        return search(nums, target, midIndex + 1, end);
    //}

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 2));
    }
}
