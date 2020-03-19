package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class Sub081 {

    public static void main(String[] args) {
        Sub081 sub081 = new Sub081();
        int[] nums = new int[]{3, 1, 1};
        Printer.println(nums.length);
        boolean rst = sub081.search(nums, 3);
        Printer.println(rst);
    }

    public boolean search(int[] nums, int target) {
        int l, r;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) >>> 1;
            if (nums[middle] == target) {
                return true;
            }
            // 如果 左边的 比中间的小 说明 左边没有选装
            if (nums[l] < nums[middle]) {

                // 如果目标值 比中间的小 并且比左边值大 说明在左边
                if (target < nums[middle] && target >= nums[l]) {
                    r = middle - 1;
                } else {
                    l = middle + 1;
                }

            }
            // 如果中间值 比左边都小 说明 左边有旋转 那么右边一定没有旋转
            else if (nums[middle] < nums[l]) {
                // 在右边
                if (target > nums[middle] && target <= nums[r]) {
                    l = middle + 1;
                } else {
                    // 在左边
                    r = middle - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}
