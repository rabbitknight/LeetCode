package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * {@link <url>https://leetcode-cn.com/problems/search-in-rotated-sorted-array/comments/</url>
 * <cost>执行用时 : 2 ms, 在Search in Rotated Sorted Array的Java提交中击败了95.40% 的用户
 * 内存消耗 : 35.2 MB, 在Search in Rotated Sorted Array的Java提交中击败了89.56% 的用户</cost>
 */
public class Sub033 {

    public static void main(String[] args) {
        Sub033 sub033 = new Sub033();
        int rst = sub033.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        Printer.println(rst);
    }

    public int search(int[] nums, int target) {
        int l, r;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) >>> 1;
            // 如果左边是规则的
            if (regular(nums, l, middle)) {
                int rst = search(nums, target, l, middle);
                if (-1 == rst) {
                    l = middle + 1;
                } else {
                    return rst;
                }
            }
            // 那么右边肯定是规则的
            else {
                int rst = search(nums, target, middle, r);
                if (-1 == rst) {
                    r = middle - 1;
                } else {
                    return rst;
                }
            }
        }
        return -1;
    }

    private boolean regular(int[] nums, int begin, int end) {
        int middle = (end + begin) >>> 1;
        return (nums[middle] >= nums[begin]) && (nums[middle] <= nums[end]);
    }

    private int search(int[] nums, int target, int l, int r) {
        int rst = -1;
        while (l <= r) {
            int middle = (r + l) >>> 1;
            if (nums[middle] == target) {
                return middle;
            }
            if (target > nums[middle]) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return rst;
    }

}
