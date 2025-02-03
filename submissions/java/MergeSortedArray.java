// Question: https://leetcode.com/problems/merge-sorted-array/description/

class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("before | nums1: " + Arrays.toString(nums1) + "\nnums2: " + Arrays.toString(nums2));
            System.out.println("m: " + m + ", n: " + n);
        }
        int k = 0;
        for (int i = m; i < (m + n); i++) {
            nums1[i] = nums2[k++];
        }
        if (isTest) {
            System.out.println("after | nums1: " + Arrays.toString(nums1));
        }
        Arrays.sort(nums1);
        if (isTest) {
            System.out.println("final | nums1: " + Arrays.toString(nums1));
        }
    }
}