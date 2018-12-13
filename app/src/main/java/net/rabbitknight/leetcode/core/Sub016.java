package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.PrintHelper;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Sub016 {
    public int threeSumClosest(int[] nums, int target) {
        int rst = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (target == sum) {
                    return target;
                }
                int closest = Math.abs(sum - target);
                if (closest < diff) {
                    diff = closest;
                    rst = sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        Sub016 sub = new Sub016();
        int[] input = new int[]{-1, 2, 1, -4};
        PrintHelper.println(sub.threeSumClosest(input, 1));
    }
}
