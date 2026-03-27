// Question: https://leetcode.com/problems/merge-sorted-array/description/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        boolean isTest = false;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        if (isTest) {
            System.out.println("before, nums1: " + Arrays.toString(nums1));
        }
        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        if (isTest) {
            System.out.println("after, nums1: " + Arrays.toString(nums1));
        }
    }
}