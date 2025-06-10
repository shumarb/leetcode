// Question: https://leetcode.com/problems/maximum-product-subarray/description/

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        boolean isTest = false;
        int len = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        prefix[0] = nums[0];
        suffix[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            if (prefix[i - 1] == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = nums[i] * prefix[i - 1];
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (suffix[i + 1] == 0) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = nums[i] * suffix[i + 1];
            }
        }
        for (int i = 0; i < len; i++) {
            maxProduct = Math.max(maxProduct, Math.max(prefix[i], suffix[i]));
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("nums:   " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
            System.out.println("maxProduct: " + maxProduct);
        }

        return maxProduct;
    }
}