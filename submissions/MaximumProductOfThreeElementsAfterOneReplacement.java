// Question: https://leetcode.com/problems/maximum-product-of-three-elements-after-one-replacement/description/

class MaximumProductOfThreeElementsAfterOneReplacement {
    public long maxProduct(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        long limit = 100000l;
        long result = 0l;

        Arrays.sort(nums);

        /**
         1. For all positive, compute product of largest 2 elements with limit.
         */
        result = (long) nums[n - 1] * (long) nums[n - 2] * limit;

        /**
         2. For all negative, compute product of smallest 2 elements with limit.
         */
        result = Math.max(result, (long) nums[0] * (long) nums[1] * limit);

        /**
         3. If combination of positive and negative elements of largest, smallest, and negative limit.
         */
        result = Math.max(result,  (long) nums[0] * (long) nums[n - 1] * -limit);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nresult: " + result);
        }

        return result;
    }
}
