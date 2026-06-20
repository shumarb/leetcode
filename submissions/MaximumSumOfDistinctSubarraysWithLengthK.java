// Question: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] count = new int[100001];
        int countDistinct = 0;
        int n = nums.length;
        long currentSubarraySum = 0;
        long result = 0;

        for (int i = 0; i < k; i++) {
            int incoming = nums[i];
            currentSubarraySum += incoming;
            if (++count[incoming] == 1) {
                countDistinct++;
            }
        }
        if (countDistinct == k) {
            result = currentSubarraySum;
        }

        for (int i = k; i < n; i++) {
            int remove = nums[i - k];
            currentSubarraySum -= remove;
            if (--count[remove] == 0) {
                countDistinct--;
            }

            int incoming = nums[i];
            currentSubarraySum += incoming;
            if (++count[incoming] == 1) {
                countDistinct++;
            }

            if (countDistinct == k) {
                result = Math.max(currentSubarraySum, result);
            }
        }

        return result;
    }
}
