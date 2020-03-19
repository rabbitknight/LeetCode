package net.rabbitknight.leetcode.core;

public class Sub724 {


    public static int pivotIndex(int[] nums) {
        int ret = -1;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int right = 0;
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2, 3};
        System.out.print(pivotIndex(nums));
    }
}
