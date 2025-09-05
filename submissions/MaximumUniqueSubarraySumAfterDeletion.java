// Question: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/

class MaximumUniqueSubarraySumAfterDeletion {
    public int maxSum(int[] nums) {
        boolean[] isNumberPresent = new boolean[101];
        boolean isTest = false;
        int largest = Integer.MIN_VALUE;
        int maximumPositiveSum = 0;

        for (int number: nums) {
            if (number > 0 && !isNumberPresent[number]) {
                maximumPositiveSum += number;
                isNumberPresent[number] = true;
            }
            largest = Math.max(largest, number);
        }
        if (isTest) {
            System.out.println("largest: " + largest + "\nmaximumPositiveSum: " + maximumPositiveSum);
        }

        return largest < 0 ? largest : maximumPositiveSum;
    }
}