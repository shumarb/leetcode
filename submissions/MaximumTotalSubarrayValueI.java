// Question: https://leetcode.com/problems/maximum-total-subarray-value-i/description/

class MaximumTotalSubarrayValueI {
    public long maxTotalValue(int[] nums, int k) {
        boolean isTest = false;
        long result = 0;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        for (int e: nums) {
            maximum = Math.max(e, maximum);
            minimum = Math.min(e, minimum);
        }

        long difference = maximum - minimum;
        if (isTest) {
            System.out.println("maximum: " + maximum + "\nminimum: " + minimum + "\ndifference: " + difference);
        }

        return difference * (long) k;
    }
}
