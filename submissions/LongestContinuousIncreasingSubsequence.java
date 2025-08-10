// Question: https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int i = 0;
        int len = nums.length;
        int longest = 0;

        while (i < len) {
            int current = 1;
            int j = i + 1;
            while (j < len && nums[j] > nums[j - 1]) {
                j++;
            }
            longest = Math.max(longest, j - 1 - i + 1);
            i = j;
        }

        return longest;
    }
}