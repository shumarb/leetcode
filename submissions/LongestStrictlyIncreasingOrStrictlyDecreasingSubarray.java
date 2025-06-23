// Question: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int currentDecreasing = 1;
        int currentIncreasing = 1;
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentIncreasing++;
                currentDecreasing = 1;
            } else if (nums[i] < nums[i - 1]) {
                currentIncreasing = 1;
                currentDecreasing++;
            } else {
                currentDecreasing = 1;
                currentIncreasing = 1;
            }
            longest = Math.max(longest, Math.max(currentDecreasing, currentIncreasing));
        }

        return longest;
    }
}