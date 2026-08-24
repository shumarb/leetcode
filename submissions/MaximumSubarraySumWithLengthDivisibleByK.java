// Question: https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/description/

class MaximumSubarraySumWithLengthDivisibleByK {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minimumPrefix = new long[k]; // smallest prefix sum seen whose prefix index % k == r.
        long prefixSum = 0;
        long result = Long.MIN_VALUE;

        Arrays.fill(minimumPrefix, Long.MAX_VALUE);

        // 1. Prefix of subarray ending at index 0 has a remainder of 0.
        minimumPrefix[0] = 0;

        for (int i = 0; i < n; i++) {
            int remainder = (i + 1) % k;
            prefixSum += nums[i];

            if (minimumPrefix[remainder] != Long.MAX_VALUE) {
                result = Math.max(prefixSum - minimumPrefix[remainder], result);
            }

            minimumPrefix[remainder] = Math.min(minimumPrefix[remainder], prefixSum);
        }

        return result;
    }
}
