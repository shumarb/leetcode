// Question: https://leetcode.com/problems/maximum-product-of-three-numbers/description/

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        /**
         Maximum product comprises of maximum out of
         - product of last 3 numbers
         - product 2 smallest numbers & largest number
         */
        int product1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int product2 = nums[0] * nums[1] * nums[len - 1];

        return Math.max(product1, product2);
    }
}