// Question: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int countDistinct = 0;
        int largest = nums[0];
        int len = nums.length;
        int[] frequency;
        long currentSubarraySum = 0;
        long maximumSubarraySum = 0;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];

        for (int i = 0; i < k; i++) {
            int current = nums[i];
            frequency[current]++;
            currentSubarraySum += current;
            if (frequency[current] == 1) {
                countDistinct++;
            }
        }
        if (countDistinct == k) {
            maximumSubarraySum = currentSubarraySum;
        }

        for (int i = k; i < len; i++) {
            int remove = nums[i - k];
            currentSubarraySum -= remove;
            frequency[remove]--;
            if (frequency[remove] == 0) {
                countDistinct--;
            }

            int incoming = nums[i];
            currentSubarraySum += incoming;
            frequency[incoming]++;
            if (frequency[incoming] == 1) {
                countDistinct++;
            }

            if (countDistinct == k) {
                maximumSubarraySum = Math.max(maximumSubarraySum, currentSubarraySum);
            }
        }

        return maximumSubarraySum;
    }
}