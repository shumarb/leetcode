// Question: https://leetcode.com/problems/merge-sorted-array/description/

class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        boolean isTest = false;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        if (isTest) {
            System.out.println("nums1: " + Arrays.toString(nums1));
            System.out.println("nums2: " + Arrays.toString(nums2));
            System.out.println("m: " + m + "\nn: " + n);
            System.out.println("nums1Copy: " + Arrays.toString(nums1Copy));
        }

        while (i < m && j < n) {
            if (nums1Copy[i] <= nums2[j]) {
                nums1[k++] = nums1Copy[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = nums1Copy[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
        if (isTest) {
            System.out.println("----------------------------------------");
            System.out.println("nums1: " + Arrays.toString(nums1));
        }
    }
}