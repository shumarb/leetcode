// Question: https://leetcode.com/problems/find-triangular-sum-of-an-array/description/

class FindTriangularSumOfAnArray {
    private boolean isTest = false;

    public int triangularSum(int[] nums) {
        return triangularSum(nums, nums.length);
    }

    private int triangularSum(int[] nums, int n) {
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums) + ", n: " + n);
        }

        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n - 1; i++) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }

        nums[n - 1] = -1;
        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums) + ", n: " + n);
            System.out.println("-----------------------------------------");
        }

        return triangularSum(nums, n - 1);
    }
}