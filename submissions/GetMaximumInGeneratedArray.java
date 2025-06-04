// Question: https://leetcode.com/problems/get-maximum-in-generated-array/description/

class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        // 1. Edge case: n == 0.
        if (n == 0) {
            return 0;
        }

        boolean isTest = false;
        int maximum = 1;
        int[] nums = new int[n + 1];

        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            maximum = Math.max(maximum, nums[i]);
        }
        if (isTest) {
            System.out.println("n: " + n + "\nnums: " + Arrays.toString(nums) + "\nmaximum: " + maximum);
        }

        return maximum;
    }
}