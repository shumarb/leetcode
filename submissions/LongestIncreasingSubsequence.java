// Question: https://leetcode.com/problems/longest-increasing-subsequence/description/

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(dp[i], result);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ndp:   " + Arrays.toString(dp));
        }

        return result;
    }
}
