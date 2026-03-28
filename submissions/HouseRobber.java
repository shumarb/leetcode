// Question: https://leetcode.com/problems/house-robber/description/

class HouseRobber class Solution {
    public int rob(int[] nums) {
        boolean isTest = false;
        int n = nums.length;

        // 1. Edge case: 1 house to rob.
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        if (n > 1) {
            /**
             2.  For every house, determine largest amount you will have
                 if you rob it vs skip it, and set the i-th element as that largest amount.
             */
            for (int i = n - 2; i >= 0; i--) {
                int amountIfRobCurrentHouse = nums[i] + (i + 2 < n ? nums[i + 2] : 0);
                int amountIfSkipCurrentHouse = nums[i + 1];
                nums[i] = Math.max(amountIfRobCurrentHouse, amountIfSkipCurrentHouse);
            }
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums) + "\nresult: " + nums[0]);
        }

        return nums[0];
    }
}
