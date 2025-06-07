// Question: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long runningSum = 0;
        long maximumSum = 0;
        int countDistinct = 0;
        int largest = nums[0];
        int[] frequency;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];
        for (int i = 0; i < k; i++) {
            int current = nums[i];
            runningSum += current;
            if (frequency[current] == 0) {
                countDistinct++;
            }
            frequency[current]++;
        }
        if (countDistinct == k) {
            maximumSum = Math.max(maximumSum, runningSum);
        }

        for (int i = k; i < nums.length; i++) {
            int remove = nums[i - k];
            runningSum -= remove;
            frequency[remove]--;
            if (frequency[remove] == 0) {
                countDistinct--;
            }

            int incoming = nums[i];
            runningSum += incoming;
            if (frequency[incoming] == 0) {
                countDistinct++;
            }
            frequency[incoming]++;

            if (countDistinct == k) {
                maximumSum = Math.max(maximumSum, runningSum);
            }
        }

        return maximumSum;
    }
}