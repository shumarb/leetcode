// Question: https://leetcode.com/problems/longest-fibonacci-subarray/description/

class LongestFibonacciSubarray {
    public int longestSubarray(int[] nums) {
        int current = 2;
        int result = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                current++;
            } else {
                result = Math.max(current, result);
                current = 2;
            }
        }

        return Math.max(current, result);
    }
}
