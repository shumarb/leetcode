// Question: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        boolean isTest = false;
        int len = nums.length;
        int longestDecreasing = 1;
        int longestIncreasing = 1;

        for (int i = 0; i < len; i++) {
            int currentIncreasing = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] <= nums[j - 1]) {
                    break;
                } else {
                    currentIncreasing++;
                }
            }
            longestIncreasing = Math.max(longestIncreasing, currentIncreasing);
        }
        for (int i = 0; i < len; i++) {
            int currentDecreasing = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] >= nums[j - 1]) {
                    break;
                } else {
                    currentDecreasing++;
                }
            }
            longestDecreasing = Math.max(longestDecreasing, currentDecreasing);
        }

        return Math.max(longestDecreasing, longestIncreasing);
    }
}
