// Question: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/

class MinimumOperationsToMakeArraySumDivisibleByK {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int number: nums) {
            sum += number;
        }
        return sum % k;
    }
}