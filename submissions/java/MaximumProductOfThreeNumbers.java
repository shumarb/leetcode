// Question: https://leetcode.com/problems/maximum-product-of-three-numbers/description/

class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        nums = sort(nums);
        int len = nums.length;

        /**
         Maximum product comprises of maximum out of
         - product of last 3 numbers
         - product 2 smallest numbers & largest number
         (array may contain >= 2 negative elements whose absolute values are larger than positive elements)
         */
        int product1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int product2 = nums[0] * nums[1] * nums[len - 1];

        return Math.max(product1, product2);
    }

    private int[] sort(int[] nums) {
        int[] frequency = new int[2001];
        for (int number: nums) {
            frequency[number + 1000]++;
        }
        int j = 0;
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i]-- > 0) {
                nums[j++] = i - 1000;
            }
        }
        return nums;
    }
}