// Question: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/

class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int secondMaximum = Integer.MIN_VALUE;

        for (int number: nums) {
            if (number > maximum) {
                secondMaximum = maximum;
                maximum = number;
            } else if (number > secondMaximum) {
                secondMaximum = number;
            }
        }

        return (maximum - 1) * (secondMaximum - 1);
    }
}