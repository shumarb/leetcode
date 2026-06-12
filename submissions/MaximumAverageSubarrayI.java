// Question: https://leetcode.com/problems/maximum-average-subarray-i/description/

class MaximumAverageSubarrayOne {
    public double findMaxAverage(int[] nums, int k) {
        double result;
        double sum = 0;
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum / k;

        for (int i = k; i < n; i++) {
            sum += (nums[i] - nums[i - k]);
            result = Math.max(result, sum / k);
        }

        return result;
    }
}
