package net.rabbitknight.leetcode.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sub001 {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i++);
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        Sub001 sub = new Sub001();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = sub.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
