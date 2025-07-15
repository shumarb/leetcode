// Question: https://leetcode.com/problems/maximum-subarray/description/

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maximumSum = nums[0];

        // 1. Kadane's algorithm.
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maximumSum = Math.max(currentSum, maximumSum);
        }

        return maximumSum;
    }
}