// Question: https://leetcode.com/problems/minimum-common-value/description/

class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;

        /**
         1. Edge case: largest of one array is smaller than smallest of another,
            so no possible solution possible.
         */
        if (nums1[m - 1] < nums2[0] || nums2[n - 1] < nums1[0]) {
            return -1;
        }

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];

            } else if (nums1[i] < nums2[j]) {
                i++;

            } else {
                j++;
            }
        }

        return -1;
    }
}
