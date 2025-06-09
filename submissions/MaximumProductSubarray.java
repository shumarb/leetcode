// Question: https://leetcode.com/problems/maximum-product-subarray/description/

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int maxProduct = nums[0];

        for (int number: nums) {
            maxProduct = Math.max(number, maxProduct);
        }
        for (int i = 0; i < len; i++) {
            int product = nums[i];
            for (int j = i + 1; j < len; j++) {
                int current = nums[j];
                product *= current;
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
}