// Question: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/

class MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int result = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result = Math.max(j++ - i, result);
            } else {
                i++;
            }
        }

        return result;
    }
}
