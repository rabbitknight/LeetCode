package net.rabbitknight.leetcode.core;

import net.rabbitknight.leetcode.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 */
public class Sub018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (null == nums | nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int tmpTarget = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if ((i != 0 && nums[i] == nums[i - 1])
                            || (j != i + 1 && nums[j] == nums[j - 1])) {
                        break;
                    }
                    if (left != j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    int sum = nums[left] + nums[right];
                    if (sum > tmpTarget) {
                        right--;
                    } else if (sum < tmpTarget) {
                        left++;
                    } else {
                        rst.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        right--;
                        left++;
                    }
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        Sub018 sub = new Sub018();
//        int[] input = new int[]{1, 0, -1, 0, -2, 2};
//        int[] input = new int[]{0, 0, 0, 0, 0, 0};
        int[] input = new int[]{-3, -1, 0, 2, 4, 5};
        Printer.println(sub.fourSum(input, 0));

    }
}
