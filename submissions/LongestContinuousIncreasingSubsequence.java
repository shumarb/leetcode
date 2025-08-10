// Question: https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        // 1. Edge case: nums has 1 element.
        if (nums.length == 1) {
            return 1;
        }

        int currentLength = 1;
        int maximumLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                maximumLength = Math.max(currentLength, maximumLength);
                currentLength = 1;
            }
        }

        return Math.max(currentLength, maximumLength);
    }
}