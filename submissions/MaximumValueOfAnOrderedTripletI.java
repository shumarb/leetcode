// Question: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/

class MaximumValueOfAnOrderedTripletI {
    public long maximumTripletValue(int[] nums) {
        long maximum = nums[0];
        long maximumDifference = 0;
        long result = 0;

        for (int k = 1; k < nums.length; k++) {
            long current = nums[k];
            result = Math.max(maximumDifference * current, result);
            maximumDifference = Math.max(maximumDifference, maximum - current);
            maximum = Math.max(current, maximum);
        }

        return result;
    }
}
