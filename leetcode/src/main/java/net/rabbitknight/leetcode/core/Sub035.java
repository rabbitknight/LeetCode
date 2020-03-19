package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <cost>
 * 执行用时 : 1 ms, 在Search Insert Position的Java提交中击败了98.32% 的用户
 * 内存消耗 : 36.8 MB, 在Search Insert Position的Java提交中击败了93.67% 的用户
 * </cost>
 */
public class Sub035 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            }
        }
//        Printer.println("l = ", l, "nums = ", nums);
        return l;
    }

    public static void main(String[] args) {
        Sub035 sub035 = new Sub035();
        Printer.println(sub035.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
