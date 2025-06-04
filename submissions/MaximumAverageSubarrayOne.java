// Question: https://leetcode.com/problems/maximum-average-subarray-i/description/

class MaximumAverageSubarrayOne {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += (double) nums[i];
        }
        maxAverage = sum / (double) k;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxAverage = Math.max(maxAverage, sum / (double) k);
        }

        return maxAverage;
    }
}