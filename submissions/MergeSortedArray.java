// Question: https://leetcode.com/problems/merge-sorted-array/description/

class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        boolean isTest = false;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        if (isTest) {
            System.out.println("nums1: " + Arrays.toString(nums1));
            System.out.println("nums2: " + Arrays.toString(nums2));
        }

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // 1. Copy remaining elements of nums2 if required.
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        if (isTest) {
            System.out.println("----------------------------------------");
            System.out.println("nums1: " + Arrays.toString(nums1));
        }
    }
}