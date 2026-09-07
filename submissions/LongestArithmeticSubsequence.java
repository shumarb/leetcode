// Question: https://leetcode.com/problems/longest-arithmetic-subsequence/description/

class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int maximum = 0;
        int minimum = 500;
        int range;
        int result = 0;

        for (int e: nums) {
            maximum = Math.max(e, maximum);
            minimum = Math.min(e, minimum);
        }

        range = maximum - minimum;
        for (int i = -range; i <= range; i++) {
            result = Math.max(longestSubsequence(nums, i), result);
            if (result == nums.length) {
                break;
            }
        }

        return result;
    }

    private int longestSubsequence(int[] nums, int difference) {
        int[] dp = new int[501];
        int result = 0;

        for (int e: nums) {
            int previous = e - difference;
            dp[e] = previous >= 0 && previous <= 500 ? 1 + dp[previous] : 1;
            result = Math.max(dp[e], result);
        }

        return result;
    }
}
