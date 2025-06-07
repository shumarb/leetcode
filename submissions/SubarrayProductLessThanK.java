// Question: https://leetcode.com/problems/subarray-product-less-than-k/description/

class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int product = nums[i];
            if (product < k) {
                count++;
            }
            for (int j = i + 1; j < len; j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}