// Question: https://leetcode.com/problems/sum-of-subarray-ranges/description/

class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            int maximum = nums[i];
            int minimum = nums[i];
            for (int j = i; j < nums.length; j++) {
                maximum = Math.max(maximum, nums[j]);
                minimum = Math.min(minimum, nums[j]);
                result += (maximum - minimum);
            }
        }

        return result;
    }
}