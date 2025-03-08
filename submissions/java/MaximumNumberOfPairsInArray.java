// Question: https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/

class MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        // 1. No pairs formed with 1 element.
        if (nums.length == 1) {
            return new int[] {0, 1};
        }

        int maximum = nums[0];
        boolean isTest = false;
        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int number: nums) {
            numberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("numberFrequency: " + Arrays.toString(numberFrequency));
        }

        int count = 0;
        int leftOver = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            if (numberFrequency[i] > 0) {
                if (isTest) {
                    System.out.print(" * number " + i + " --> frequency: " + numberFrequency[i]);
                    System.out.println(" | numPairs: " + numberFrequency[i] / 2 + ", leftOver: " + numberFrequency[i] % 2);
                }
                count += numberFrequency[i] / 2;
                leftOver += (numberFrequency[i] % 2);
            }
        }
        return new int[] {count, leftOver};
    }
}