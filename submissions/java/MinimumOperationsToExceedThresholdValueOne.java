// Question: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/

class MinimumOperationsToExceedThresholdValueOne {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int number: nums) {
            if (number < k) {
                count++;
            }
        }
        return count;
    }
}