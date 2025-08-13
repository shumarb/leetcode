// Question: https://leetcode.com/problems/non-decreasing-array/description/

class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean isTest = false;
        int count = 0;

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count == 2) {
                    return false;
                }

                // 1. Lower previous.
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    // 2. Increase current.
                    nums[i] = nums[i - 1];
                }

                if (isTest) {
                    System.out.println(" * i: " + i + ", so far, nums: " + Arrays.toString(nums));
                }
            }
        }
        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums));
        }

        return true;
    }
}