// Question: https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/

class MaximumAbsoluteSumOfAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        boolean isTest = false;
        int currentMaximumSum = nums[0];
        int currentMinimumSum = nums[0];
        int maximumSum = nums[0];
        int minimumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMaximumSum = Math.max(nums[i], currentMaximumSum + nums[i]);
            currentMinimumSum = Math.min(nums[i], currentMinimumSum + nums[i]);
            maximumSum = Math.max(currentMaximumSum, maximumSum);
            minimumSum = Math.min(currentMinimumSum, minimumSum);
        }
        if (isTest) {
            System.out.println("maximumSum: " + maximumSum + "\nminimumSum: " + minimumSum);
        }

        return Math.max(Math.abs(maximumSum), Math.abs(minimumSum));
    }
}
