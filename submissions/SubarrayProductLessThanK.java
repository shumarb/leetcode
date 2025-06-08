// Question: https://leetcode.com/problems/subarray-product-less-than-k/description/

class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 1. Edge case: k == 1, so no subarrays to form.
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int left = 0;
        int product = 1;
        int right = 0;

        while (right < nums.length) {
            /**
             2.  Count current element on right
                 by multiplying product with it,
                 then remove each left element from product
                 until product < k (if required).
             */
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            /**
             3.  Subarray comprises of 1-based difference
                 between left and right indices.
             */
            count += right - left + 1;
            right++;
        }

        return count;
    }
}