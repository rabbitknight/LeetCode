package net.rabbitknight.leetcode.core;

public class Sub026 {

    public static int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p] != nums[i]) {
                nums[++p] = nums[i];
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2,2, 3};

        System.out.println(removeDuplicates(nums
        ));
        System.out.println(nums);
    }
}
