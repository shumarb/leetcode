// Question: https://leetcode.com/problems/minimum-size-subarray-sum/description/

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minSubArrayLen = Integer.MAX_VALUE;
        int left = 0;
        int len = nums.length;
        int right = 0;
        int runningSum = 0;

        while (right < len) {
            runningSum += nums[right];
            while (left < len && runningSum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, right - left + 1);
                runningSum -= nums[left++];
            }
            right++;
        }

        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }
}