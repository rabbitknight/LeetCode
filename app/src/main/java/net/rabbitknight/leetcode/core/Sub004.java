package net.rabbitknight.leetcode.core;

public class Sub004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0D;
        int count = nums1.length + nums2.length;

        int mid = (nums1.length + nums2.length) / 2;

        if (count % 2 == 1) {
            return sort(nums1, nums2)[mid];
        } else {
            int[] rst = sort(nums1, nums2);
            return (rst[mid - 1] + rst[mid]) / 2.0f;
        }

    }

    private int[] sort(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, p = 0;

        while (i < nums1.length && j < nums2.length) {
            result[p++] = nums2[j] < nums1[i] ? nums2[j++] : nums1[i++];
        }

        if (i == nums1.length) {
            while (j < nums2.length) {
                result[p++] = nums2[j++];
            }
        }
        if (j == nums2.length) {
            while (i < nums1.length) {
                result[p++] = nums1[i++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Sub004 sub = new Sub004();
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        System.out.println(sub.findMedianSortedArrays(a, b));
    }
}
