package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <cost>
 * 执行用时 : 1 ms, 在Find First and Last Position of Element in Sorted Array的Java提交中击败了99.52% 的用户
 * 内存消耗 : 40.2 MB, 在Find First and Last Position of Element in Sorted Array的Java提交中击败了94.25% 的用户
 * </cost>
 */
public class Sub034 {

    public static void main(String[] args) {
        Sub034 sub034 = new Sub034();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 10;
        int[] rst = sub034.searchRange(nums, target);
        Printer.println(Arrays.toString(rst));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                l = mid;
                r = mid;
                while (l != 0 && nums[l - 1] == target) {
                    l--;

                }
                while (r != nums.length - 1 && nums[r + 1] == target) {
                    r++;
                }
                return new int[]{l, r};
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
