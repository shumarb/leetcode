// Question: https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/

class MaximumAbsoluteSumOfAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int currentMaximum = nums[0];
        int currentMinimum = nums[0];
        int maximumSum = nums[0];
        int minimumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            currentMaximum = Math.max(current, current + currentMaximum);
            currentMinimum = Math.min(current, current + currentMinimum);
            maximumSum = Math.max(currentMaximum, maximumSum);
            minimumSum = Math.min(currentMinimum, minimumSum);
        }

        return Math.max(Math.abs(maximumSum), Math.abs(minimumSum));
    }
}
