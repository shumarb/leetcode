// Question: https://leetcode.com/problems/house-robber/description/

class HouseRobber {
    public int rob(int[] nums) {
        boolean isTest = false;
        int n = nums.length;

        if (n == 1) {
            return nums[0];

        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }

        for (int i = n - 2; i >= 0; i--) {
            int totalIfAvoidCurrent = nums[i + 1];
            int totalIfRobCurrent = nums[i] + ((i + 2 < n) ? nums[i + 2] : 0);
            nums[i] = Math.max(totalIfAvoidCurrent, totalIfRobCurrent);
        }

        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums));
        }

        return Math.max(nums[0], nums[1]);
    }
}
