// Question: https://leetcode.com/problems/subarray-sum-equals-k/description/

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // 1. Prefix sum is 0 before iteration, so include 0 in prefix sums so far.
        prefixSumMap.put(0, 1);

        for (int number: nums) {
            // 2. Increase prefix sum by current number.
            prefixSum += number;

            // 3. Obtain complement to find.
            int complement = prefixSum - k;

            /**
             4.  If complement exists,
                 subArray that ends at current number sums to k.
             */
            if (prefixSumMap.containsKey(complement)) {
                count += prefixSumMap.get(complement);
            }

            // 5. Increase number of occurrences of sum by 1.
            prefixSumMap.put(prefixSum, 1 + prefixSumMap.getOrDefault(prefixSum, 0));
        }

        return count;
    }
}