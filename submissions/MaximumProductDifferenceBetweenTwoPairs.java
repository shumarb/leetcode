// Question: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/

class MaximumProductDifferenceBetweenTwoPairs {
    public int maxProductDifference(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int secondMaximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;
        boolean isTest = false;

        for (int number: nums) {
            if (number > maximum) {
                secondMaximum = maximum;
                maximum = number;
            } else if (number > secondMaximum) {
                secondMaximum = number;
            }

            if (number < minimum) {
                secondMinimum = minimum;
                minimum = number;
            } else if (number < secondMinimum) {
                secondMinimum = number;
            }
        }

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("maximum: " + maximum + ", secondMaximum: " + secondMaximum);
            System.out.println("minimum: " + minimum + ", secondMinimum: " + secondMinimum);
        }

        return (maximum * secondMaximum) - (minimum * secondMinimum);
    }
}