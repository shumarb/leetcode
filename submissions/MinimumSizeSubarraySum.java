// Question: https://leetcode.com/problems/minimum-size-subarray-sum/description/

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minSubArrayLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (left < nums.length && sum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }
}