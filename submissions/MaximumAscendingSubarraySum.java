// Question: https://leetcode.com/problems/maximum-ascending-subarray-sum/description/

class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int currentAscendingSum = 0;
        int maximumAscendingSum = 0;

        currentAscendingSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentAscendingSum += nums[i];
            } else {
                maximumAscendingSum = Math.max(currentAscendingSum, maximumAscendingSum);
                currentAscendingSum = nums[i];
            }
        }

        return Math.max(currentAscendingSum, maximumAscendingSum);
    }
}