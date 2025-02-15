// Question: https://leetcode.com/problems/neither-minimum-nor-maximum/description/

class NeitherMinimumNorMaximum {
    public int findNonMinOrMax(int[] nums) {
        int result = -1;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        boolean isTest = false;

        for (int number: nums) {
            maximum = Math.max(number, maximum);
            minimum = Math.min(number, minimum);
        }
        for (int number: nums) {
            if (number != maximum && number != minimum) {
                result = number;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("maximum: " + maximum + "\nminimum: " + minimum + "\nresult: " + result);
        }

        return result;
    }
}