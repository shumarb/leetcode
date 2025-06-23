// Question: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int currentDecreasing = 1;
        int currentIncreasing = 1;
        int len = nums.length;
        int longestDecreasing = 0;
        int longestIncreasing = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                currentIncreasing++;
            } else {
                longestIncreasing = Math.max(currentIncreasing, longestIncreasing);
                currentIncreasing = 1;
            }
        }
        longestIncreasing = Math.max(currentIncreasing, longestIncreasing);

        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                currentDecreasing++;
            } else {
                longestDecreasing = Math.max(currentDecreasing, longestDecreasing);
                currentDecreasing = 1;
            }
        }
        longestDecreasing = Math.max(currentDecreasing, longestDecreasing);

        return Math.max(longestDecreasing, longestIncreasing);
    }
}