// Question:

class HouseRobber {
    public int rob(int[] nums) {
        boolean isTest = false;
        int n = nums.length;

        // 1. 1 house to rob.
        if (n == 1) {
            return nums[0];
        }

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int i = n - 2; i >= 0; i--) {
            int robCurrent = nums[i] + ((i + 2 < n) ? nums[i + 2] : 0);
            int skipCurrent = nums[i + 1];
            nums[i] = Math.max(robCurrent, skipCurrent);
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return nums[0];
    }
}
