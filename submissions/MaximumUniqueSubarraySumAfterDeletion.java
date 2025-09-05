// Question: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int largest = Integer.MIN_VALUE;
        int maximumPositiveSum = 0;

        for (int number: nums) {
            if (number > 0 && !set.contains(number)) {
                maximumPositiveSum += number;
                set.add(number);
            }
            largest = Math.max(largest, number);
        }
        if (isTest) {
            System.out.println("set: " + set + "\nlargest: " + largest + "\nmaximumPositiveSum: " + maximumPositiveSum);
        }

        return largest < 0 ? largest : maximumPositiveSum;
    }
}