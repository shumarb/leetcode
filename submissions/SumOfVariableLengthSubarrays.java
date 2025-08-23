// Question: https://leetcode.com/problems/sum-of-variable-length-subarrays/description/

class SumOfVariableLengthSubarrays {
    public int subarraySum(int[] nums) {
        int subarraySum = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                subarraySum += nums[j];
            }
        }

        return subarraySum;
    }
}