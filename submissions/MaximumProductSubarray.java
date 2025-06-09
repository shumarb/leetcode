// Question: https://leetcode.com/problems/maximum-product-subarray/description/

class MaximumProductSubarray class Solution {
    public int maxProduct(int[] nums) {
        boolean isTest = false;
        int len = nums.length;
        int maxProduct = nums[0];
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int product = 1;

        prefix[0] = nums[0];
        suffix[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            if (prefix[i - 1] == 0) {
                prefix[i] = 1 * nums[i];
            } else {
                prefix[i] = nums[i] * prefix[i - 1];
            }
        }
        product = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (suffix[i + 1] == 0) {
                suffix[i] = 1 * nums[i];
            } else {
                suffix[i] = nums[i] * suffix[i + 1];
            }
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("nums:   " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }
        for (int i = 0; i < len; i++) {
            maxProduct = Math.max(maxProduct, Math.max(prefix[i], suffix[i]));
        }

        return maxProduct;
    }

}