// Question: https://leetcode.com/problems/running-sum-of-1d-array/description/

class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int cumulativeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            nums[i] = cumulativeSum;
        }
        return nums;
    }
}