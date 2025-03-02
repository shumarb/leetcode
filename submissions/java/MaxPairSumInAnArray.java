// Question: https://leetcode.com/problems/max-pair-sum-in-an-array/description/

class MaxPairSumInAnArray {
    public int maxSum(int[] nums) {
        int len = nums.length;
        int[] largestDigit = new int[len];
        boolean isTest = false;

        for (int i = 0; i < len; i++) {
            largestDigit[i] = findLargestDigit(nums[i]);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nlargest digit: " + Arrays.toString(largestDigit));
        }

        int maxPairSum = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (largestDigit[i] == largestDigit[j]) {
                    maxPairSum = Math.max(maxPairSum, nums[i] + nums[j]);
                }
            }
        }
        if (isTest) {
            System.out.println("max pair sum: " + maxPairSum);
        }

        return maxPairSum;
    }

    private int findLargestDigit(int number) {
        int largestDigit = 0;
        while (number != 0) {
            largestDigit = Math.max(largestDigit, number % 10);
            number /= 10;
        }
        return largestDigit;
    }
}